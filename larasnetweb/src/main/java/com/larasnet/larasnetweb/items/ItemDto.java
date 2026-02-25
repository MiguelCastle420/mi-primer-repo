package com.larasnet.larasnetweb.items;

import java.math.BigDecimal;

public record ItemDto(
    String id,
    String uid,
    String kind,     // "producto" | "articulo"
    String name,
    String brand,
    BigDecimal price,
    int qty,
    String unit,
    String desc,
    boolean featured
) {}
