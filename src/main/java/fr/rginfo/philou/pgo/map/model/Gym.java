package fr.rginfo.philou.pgo.map.model;

import java.math.BigDecimal;

public class Gym extends Node {
  private String gym_id;
  private Integer cp;
  private Integer move1;
  private Integer move2;
  private Double latitude;
  private Double longitude;
  private Integer raidPokemon;
  private Long raidBattleMs;
  private String imageURL;
  private Integer slotsAvailble;
  private Boolean isExRaidEligible;
  private Long raidSpawnMs;
  private Integer guardingPokemonIdentifier;
  private Boolean enabled;
  private Integer points;
  private BigDecimal raidSeed;
  private Boolean isInBattle;
  private Long lastModifiedTimestampMs;
  private Integer raidLevel;
  private Long raidEndMs;
  private Integer form;
  private Integer team;

  public String getGym_id() {
    return gym_id;
  }

  public void setGym_id(String gym_id) {
    this.gym_id = gym_id;
  }

  public Integer getCp() {
    return cp;
  }

  public void setCp(Integer cp) {
    this.cp = cp;
  }

  public Integer getMove1() {
    return move1;
  }

  public void setMove1(Integer move1) {
    this.move1 = move1;
  }

  public Integer getMove2() {
    return move2;
  }

  public void setMove2(Integer move2) {
    this.move2 = move2;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Integer getRaidPokemon() {
    return raidPokemon;
  }

  public void setRaidPokemon(Integer raidPokemon) {
    this.raidPokemon = raidPokemon;
  }

  public Long getRaidBattleMs() {
    return raidBattleMs;
  }

  public void setRaidBattleMs(Long raidBattleMs) {
    this.raidBattleMs = raidBattleMs;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public Integer getSlotsAvailble() {
    return slotsAvailble;
  }

  public void setSlotsAvailble(Integer slotsAvailble) {
    this.slotsAvailble = slotsAvailble;
  }

  public Boolean getExRaidEligible() {
    return isExRaidEligible;
  }

  public void setExRaidEligible(Boolean exRaidEligible) {
    isExRaidEligible = exRaidEligible;
  }

  public Long getRaidSpawnMs() {
    return raidSpawnMs;
  }

  public void setRaidSpawnMs(Long raidSpawnMs) {
    this.raidSpawnMs = raidSpawnMs;
  }

  public Integer getGuardingPokemonIdentifier() {
    return guardingPokemonIdentifier;
  }

  public void setGuardingPokemonIdentifier(Integer guardingPokemonIdentifier) {
    this.guardingPokemonIdentifier = guardingPokemonIdentifier;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public BigDecimal getRaidSeed() {
    return raidSeed;
  }

  public void setRaidSeed(BigDecimal raidSeed) {
    this.raidSeed = raidSeed;
  }

  public Boolean getInBattle() {
    return isInBattle;
  }

  public void setInBattle(Boolean inBattle) {
    isInBattle = inBattle;
  }

  public Long getLastModifiedTimestampMs() {
    return lastModifiedTimestampMs;
  }

  public void setLastModifiedTimestampMs(Long lastModifiedTimestampMs) {
    this.lastModifiedTimestampMs = lastModifiedTimestampMs;
  }

  public Integer getRaidLevel() {
    return raidLevel;
  }

  public void setRaidLevel(Integer raidLevel) {
    this.raidLevel = raidLevel;
  }

  public Long getRaidEndMs() {
    return raidEndMs;
  }

  public void setRaidEndMs(Long raidEndMs) {
    this.raidEndMs = raidEndMs;
  }

  public Integer getForm() {
    return form;
  }

  public void setForm(Integer form) {
    this.form = form;
  }

  public Integer getTeam() {
    return team;
  }

  public void setTeam(Integer team) {
    this.team = team;
  }
}
