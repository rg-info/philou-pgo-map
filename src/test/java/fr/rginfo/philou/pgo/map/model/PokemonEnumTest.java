package fr.rginfo.philou.pgo.map.model;

import fr.rginfo.philou.pgo.map.model.json.PokemonEnum;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PokemonEnumTest {

  @Test
  public void shouldGetUnknownFromCodeZero() {
    Assertions.assertThat(PokemonEnum.fromInt(0)).isEqualTo(PokemonEnum.UNKNOWN);
  }

  @Test
  public void shouldGetEnumFromIntCode() {
    Assertions.assertThat(PokemonEnum.fromInt(1)).isEqualTo(PokemonEnum.BULBIZARRE);
  }

  @Test
  public void shouldRetrieveStringValueFromIntCode() {
    Assertions.assertThat(PokemonEnum.toString(151)).isEqualTo("Mew");
  }

}