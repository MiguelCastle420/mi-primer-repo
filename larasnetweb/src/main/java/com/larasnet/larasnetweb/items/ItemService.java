package com.larasnet.larasnetweb.items;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

  private final ItemRepository repo;

  public ItemService(ItemRepository repo) {
    this.repo = repo;
  }

  public List<ItemDto> getAll() {
    return repo.findAll().stream().map(ItemService::toDto).toList();
  }

  @Transactional
  public void saveSnapshot(List<ItemDto> items) {
    repo.deleteAllInBatch();
    repo.flush();
    repo.saveAll(items.stream().map(ItemService::toEntity).toList());
  }

  private static ItemDto toDto(ItemEntity e) {
    return new ItemDto(
        e.getId(),
        e.getUid(),
        e.getKind(),
        e.getName(),
        e.getBrand(),
        e.getPrice(),
        e.getQty(),
        e.getUnit(),
        e.getDesc(),
        e.isFeatured()
    );
  }

  private static ItemEntity toEntity(ItemDto d) {
    ItemEntity e = new ItemEntity();

    String safeId = (d.id() == null || d.id().isBlank())
        ? UUID.randomUUID().toString()
        : d.id();

    e.setId(safeId);
    e.setUid(d.uid());
    e.setKind(d.kind());
    e.setName(d.name());
    e.setBrand(d.brand());
    e.setPrice(d.price());
    e.setQty(d.qty());
    e.setUnit(d.unit());
    e.setDesc(d.desc());
    e.setFeatured(d.featured());
    return e;
  }
}
