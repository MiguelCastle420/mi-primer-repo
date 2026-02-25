package com.larasnet.larasnetweb.items;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class ItemEntity {

  @Id
  @Column(length = 64, nullable = false)
  private String id;

  @Column(length = 3, nullable = false)
  private String uid;

  @Column(length = 20, nullable = false)
  private String kind;

  @Column(length = 140, nullable = false)
  private String name;

  @Column(length = 140)
  private String brand;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal price;

  @Column(nullable = false)
  private int qty;

  @Column(length = 40)
  private String unit;

  @Column(name = "description", columnDefinition = "TEXT")
  private String desc;

  @Column(nullable = false)
  private boolean featured;

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getUid() { return uid; }
  public void setUid(String uid) { this.uid = uid; }

  public String getKind() { return kind; }
  public void setKind(String kind) { this.kind = kind; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getBrand() { return brand; }
  public void setBrand(String brand) { this.brand = brand; }

  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }

  public int getQty() { return qty; }
  public void setQty(int qty) { this.qty = qty; }

  public String getUnit() { return unit; }
  public void setUnit(String unit) { this.unit = unit; }

  public String getDesc() { return desc; }
  public void setDesc(String desc) { this.desc = desc; }

  public boolean isFeatured() { return featured; }
  public void setFeatured(boolean featured) { this.featured = featured; }
}
