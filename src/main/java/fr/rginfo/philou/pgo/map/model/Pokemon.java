package fr.rginfo.philou.pgo.map.model;

import java.math.BigDecimal;

public class Pokemon extends AbstractPokemon {
  private BigDecimal id;
  private Double lat;
  private Double lon;
  private Integer type;
  private Long despawn_time;
  private Long true_despawn;
  private String spawn_id;

  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Long getDespawn_time() {
    return despawn_time;
  }

  public void setDespawn_time(Long despawn_time) {
    this.despawn_time = despawn_time;
  }

  public Long getTrue_despawn() {
    return true_despawn;
  }

  public void setTrue_despawn(Long true_despawn) {
    this.true_despawn = true_despawn;
  }

  public String getSpawn_id() {
    return spawn_id;
  }

  public void setSpawn_id(String spawn_id) {
    this.spawn_id = spawn_id;
  }

  @Override
  public String toString() {
    return super.toString() + " (" + this.getLat() + ":" + this.getLon() + ")";
  }
}
