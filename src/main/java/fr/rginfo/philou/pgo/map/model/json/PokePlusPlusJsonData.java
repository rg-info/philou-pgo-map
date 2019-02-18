package fr.rginfo.philou.pgo.map.model.json;

import java.util.ArrayList;
import java.util.List;

public class PokePlusPlusJsonData {
  private String uuid;
  private String validation1;
  private Double timestamp;
  private List<Pokestop> pokestops = new ArrayList<>();
  private String latitude;
  private String longitude;
  private Integer submit_version;
  private List<Spawnpoint> spawnpoints = new ArrayList<>();
  private Integer trainerlvl;
  private List<Pokemon> pokemon = new ArrayList<>();
  private List<NearbyPokemon> nearby_pokemon = new ArrayList<>();
  private List<Gym> gyms = new ArrayList<>();

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getValidation1() {
    return validation1;
  }

  public void setValidation1(String validation1) {
    this.validation1 = validation1;
  }

  public Double getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Double timestamp) {
    this.timestamp = timestamp;
  }

  public List<Pokestop> getPokestops() {
    return pokestops;
  }

  public void setPokestops(List<Pokestop> pokestops) {
    this.pokestops = pokestops;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Integer getSubmit_version() {
    return submit_version;
  }

  public void setSubmit_version(Integer submit_version) {
    this.submit_version = submit_version;
  }

  public List<Spawnpoint> getSpawnpoints() {
    return spawnpoints;
  }

  public void setSpawnpoints(List<Spawnpoint> spawnpoints) {
    this.spawnpoints = spawnpoints;
  }

  public Integer getTrainerlvl() {
    return trainerlvl;
  }

  public void setTrainerlvl(Integer trainerlvl) {
    this.trainerlvl = trainerlvl;
  }

  public List<Pokemon> getPokemon() {
    return pokemon;
  }

  public void setPokemon(List<Pokemon> pokemon) {
    this.pokemon = pokemon;
  }

  public List<NearbyPokemon> getNearby_pokemon() {
    return nearby_pokemon;
  }

  public void setNearby_pokemon(List<NearbyPokemon> nearby_pokemon) {
    this.nearby_pokemon = nearby_pokemon;
  }

  public List<Gym> getGyms() {
    return gyms;
  }

  public void setGyms(List<Gym> gyms) {
    this.gyms = gyms;
  }
}
