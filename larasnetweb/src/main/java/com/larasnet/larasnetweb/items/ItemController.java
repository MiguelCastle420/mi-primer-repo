package com.larasnet.larasnetweb.items;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

  private final ItemService service;

  public ItemController(ItemService service) {
    this.service = service;
  }

  @GetMapping
  public List<ItemDto> getAll() {
    return service.getAll();
  }

  @PutMapping("/snapshot")
  public ResponseEntity<Void> saveSnapshot(@RequestBody List<ItemDto> items) {
    service.saveSnapshot(items);
    return ResponseEntity.noContent().build();
  }
}
