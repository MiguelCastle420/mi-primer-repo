package com.larasnet.larasnetweb.ventas;

import java.math.BigDecimal;
import java.util.List;

public record VentaDto(
    String id,
    String code,
    String date,   // "YYYY-MM-DD"
    String time,   // "HH:mm"
    BigDecimal total,
    List<VentaItemDto> items
) {}
