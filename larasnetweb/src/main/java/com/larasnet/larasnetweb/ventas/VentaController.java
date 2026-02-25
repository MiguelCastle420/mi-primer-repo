package com.larasnet.larasnetweb.ventas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

  private final VentaService service;

  public VentaController(VentaService service) {
    this.service = service;
  }

  @GetMapping
  public List<VentaDto> getAll() {
    return service.getAll();
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody VentaDto sale) {
    service.save(sale);
    return ResponseEntity.noContent().build();
  }
}
