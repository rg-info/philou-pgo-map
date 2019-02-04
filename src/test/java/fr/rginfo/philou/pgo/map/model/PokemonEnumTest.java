package fr.rginfo.philou.pgo.map.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PokemonEnumTest {

  @Test
  public void shouldGetBulbizarreWithCode0() {
    Assertions.assertThat(PokemonEnum.fromInt(0)).isEqualTo(PokemonEnum.BULBIZARRE);
  }

  @Test
  public void shouldRetreiveStringValueFromIntegerValue() {
    Assertions.assertThat(PokemonEnum.toString(0)).isEqualTo("Bulbizarre");
  }

}