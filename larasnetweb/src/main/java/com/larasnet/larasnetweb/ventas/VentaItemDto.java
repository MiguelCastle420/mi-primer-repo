package com.larasnet.larasnetweb.ventas;

import java.math.BigDecimal;

public record VentaItemDto(
    String uid,
    String kind,
    String name,
    BigDecimal price,
    int qty
) {}
