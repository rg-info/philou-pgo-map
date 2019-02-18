package fr.rginfo.philou.pgo.map.model.json;

import java.math.BigDecimal;

public class NearbyPokemon extends AbstractPokemon {
  private BigDecimal encounter_id;
  private String fort_id;
  private Double distance;
  private Integer form;

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public String getFort_id() {
    return fort_id;
  }

  public void setFort_id(String fort_id) {
    this.fort_id = fort_id;
  }

  public BigDecimal getEncounter_id() {
    return encounter_id;
  }

  public void setEncounter_id(BigDecimal encounter_id) {
    this.encounter_id = encounter_id;
  }

  public Integer getForm() {
    return form;
  }

  public void setForm(Integer form) {
    this.form = form;
  }

  @Override
  public String toString() {
    return super.toString() + " (" + this.getDistance().intValue() + "M)";
  }
}
