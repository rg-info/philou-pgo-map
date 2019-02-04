package fr.rginfo.philou.pgo.map.model;

public abstract class AbstractPokemon extends Node {
  private Integer pokemon_id;
  private Integer gender;
  private Integer weather;
  private Integer costume;
  private Integer form;

  public Integer getPokemon_id() {
    return pokemon_id;
  }

  public void setPokemon_id(Integer pokemon_id) {
    this.pokemon_id = pokemon_id;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Integer getWeather() {
    return weather;
  }

  public void setWeather(Integer weather) {
    this.weather = weather;
  }

  public Integer getCostume() {
    return costume;
  }

  public void setCostume(Integer costume) {
    this.costume = costume;
  }

  public Integer getForm() {
    return form;
  }

  public void setForm(Integer form) {
    this.form = form;
  }

  @Override
  public String toString() {
    return PokemonEnum.toString(this.getPokemon_id());
  }
}
