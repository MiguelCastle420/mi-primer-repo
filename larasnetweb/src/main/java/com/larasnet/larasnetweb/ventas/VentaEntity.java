package com.larasnet.larasnetweb.ventas;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ventas")
public class VentaEntity {

  @Id
  @Column(length = 64, nullable = false)
  private String id;

  @Column(length = 10, nullable = false)
  private String code;

  @Column(length = 10, nullable = false)
  private String date; // YYYY-MM-DD

  @Column(length = 5, nullable = false)
  private String time; // HH:mm

  @Column(nullable = false, precision = 12, scale = 2)
  private BigDecimal total;

  @Lob
  @Column(name = "items_json", columnDefinition = "LONGTEXT", nullable = false)
  private String itemsJson;

  // getters/setters
  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getCode() { return code; }
  public void setCode(String code) { this.code = code; }

  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }

  public String getTime() { return time; }
  public void setTime(String time) { this.time = time; }

  public BigDecimal getTotal() { return total; }
  public void setTotal(BigDecimal total) { this.total = total; }

  public String getItemsJson() { return itemsJson; }
  public void setItemsJson(String itemsJson) { this.itemsJson = itemsJson; }
}
