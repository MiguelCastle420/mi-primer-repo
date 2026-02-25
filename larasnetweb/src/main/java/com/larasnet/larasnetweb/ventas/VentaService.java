package com.larasnet.larasnetweb.ventas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class VentaService {

  private final VentaRepository repo;
  private final ObjectMapper om = new ObjectMapper();

  public VentaService(VentaRepository repo) {
    this.repo = repo;
  }

  public List<VentaDto> getAll() {
    var sort = Sort.by(Sort.Order.desc("date"), Sort.Order.desc("time"));
    return repo.findAll(sort).stream().map(this::toDto).toList();
  }

  @Transactional
  public void save(VentaDto sale) {
    repo.save(toEntity(sale));
  }

  private VentaDto toDto(VentaEntity e) {
    try {
      List<VentaItemDto> items = om.readValue(
          e.getItemsJson(),
          new TypeReference<List<VentaItemDto>>() {}
      );

      return new VentaDto(
          e.getId(),
          e.getCode(),
          e.getDate(),
          e.getTime(),
          e.getTotal(),
          items
      );
    } catch (Exception ex) {
      throw new RuntimeException("No se pudo parsear items_json de la venta " + e.getId(), ex);
    }
  }

  private VentaEntity toEntity(VentaDto d) {
    try {
      VentaEntity e = new VentaEntity();

      String safeId = (d.id() == null || d.id().isBlank())
          ? UUID.randomUUID().toString()
          : d.id();

      e.setId(safeId);
      e.setCode(d.code() == null ? "" : d.code());
      e.setDate(d.date() == null ? "" : d.date());
      e.setTime(d.time() == null ? "" : d.time());
      e.setTotal(d.total());
      e.setItemsJson(om.writeValueAsString(d.items() == null ? List.of() : d.items()));

      return e;
    } catch (Exception ex) {
      throw new RuntimeException("No se pudo serializar items de la venta", ex);
    }
  }
}
