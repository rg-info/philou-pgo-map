package fr.rginfo.philou.pgo.map;

import fr.rginfo.philou.pgo.map.model.PokemonGoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokePlusPlusController {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @PostMapping("webhook")
  public void pokePlusPlusWebHook(@RequestBody PokemonGoData request) {
    logger.info("Receiving request from uuid: " + request.getUuid());
    logger.info("Number of Nearby Pokemons: " + request.getNearby_pokemon().size());

    logger.info("Listing Pokemon at range: ");
    request.getPokemon().forEach(pokemon -> logger.info(pokemon.toString()));
  }
}
