package fr.rginfo.philou.pgo.map.model.json;

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
    return super.toString() + " (" + this.getLat() + ":" + this.getLon() + ") spawn_id : " + this.getSpawn_id();
  }

  public Integer getIv() {
    return (this.getAttack() + this.getDefense() + this.getStamina()) * 100 / 45;
  }

  private Integer getAttack() {
    return this.getIntegerValueFromId(8);
  }

  private Integer getDefense() {
    return this.getIntegerValueFromId(9);
  }

  private Integer getStamina() {
    return this.getIntegerValueFromId(10);
  }

  private Integer getIntegerValueFromId(int index) {
    if (index >= this.spawn_id.length()) {
      return 0;
    }

    return Integer.parseInt(String.valueOf(this.spawn_id.charAt(index)), 16);
  }
}
