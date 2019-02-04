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

    logger.info("Listing Nearby Pokemon: ");
    request.getNearby_pokemon().forEach(nearbyPokemon -> logger.info(nearbyPokemon.toString()));

    logger.info("Listing Opened Pokemon: ");
    request.getPokemon().forEach(pokemon -> logger.info(pokemon.toString()));
  }
}
