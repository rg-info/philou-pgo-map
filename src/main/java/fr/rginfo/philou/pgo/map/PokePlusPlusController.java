package fr.rginfo.philou.pgo.map;

import com.google.protobuf.InvalidProtocolBufferException;
import fr.rginfo.philou.pgo.map.alert.AlertService;
import fr.rginfo.philou.pgo.map.model.json.PokemonEnum;
import fr.rginfo.philou.pgo.map.model.raw.PokePlusPlusRawData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pogoprotos.networking.responses.*;

import javax.inject.Inject;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PokePlusPlusController {

  private final static String MAP_OBJECT = "GetMapObjects";
  private final static String ENCOUNTER_RESPONSE = "EncounterResponse";
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final AlertService alertService;

  @Inject
  public PokePlusPlusController(AlertService alertService) {
    Assert.notNull(alertService, "AlertService can't be null");
    this.alertService = alertService;
  }

  @PostMapping("webhook")
  public void pokePlusPlusWebhook(@RequestBody PokePlusPlusRawData request) {
    logger.info("Receiving request from uuid: " + request.getUuid());

    this.rawDataProtosAnalysis(request.getProtos());
  }

  @PostMapping("walk_spawnpoint")
  public void walkSpawnpoint(@RequestBody String request) {
    logger.info("Receiving request on walk_spawnpoint: " + request);
  }

  private void rawDataProtosAnalysis(List<Map<String, String>> protos) {
    if (protos.isEmpty()) {
      logger.info("No protos found in the request");
      return;
    }

    logger.info("Start analysing the " + protos.size() + " protos found");

    List<String> mapProtos = protos.stream()
        .filter(proto -> proto.containsKey(MAP_OBJECT))
        .map(proto -> proto.get(MAP_OBJECT))
        .collect(Collectors.toList());
    logger.info("Extracting map related protos... Found " + mapProtos.size());

    mapProtos.forEach(this::protobufMapDataAnalysis);

    List<String> encounterProtos = protos.stream()
        .filter(proto -> proto.containsKey(ENCOUNTER_RESPONSE))
        .map(proto -> proto.get(ENCOUNTER_RESPONSE))
        .collect(Collectors.toList());
    logger.info("Extracting encounter related protos... Found " + encounterProtos.size());

    encounterProtos.forEach(this::protobufEncounterDataAnalysis);
    logger.info("########################################");
    logger.info("########################################");
  }

  private void protobufMapDataAnalysis(String requestString) {
    GetMapObjectsResponse.GetMapObjectResponse mapObjectResponse = this.mapRequestStringToProtobufBean(requestString);

    logger.info("Map object extracted with success");

    if (mapObjectResponse.getMapCellsList() != null && mapObjectResponse.getMapCellsList().size() > 0) {
      logger.info("Found " + mapObjectResponse.getMapCellsList().size() + " MapCells");
      mapObjectResponse.getMapCellsList().forEach(this::mapCellAnalysis);
      logger.info("########################################");
      logger.info("########################################");
    }
  }

  private void protobufEncounterDataAnalysis(String requestString) {
    EncounterResponseOuterClass.EncounterResponse encounterResponse = this.encounterRequestStringToProtobufBean(requestString);

    logger.info("Encounter object extracted with success");

    if (encounterResponse.hasWildPokemon()) {
      this.printingWildPokemonsData(encounterResponse.getWildPokemon());
    }
  }

  private GetMapObjectsResponse.GetMapObjectResponse mapRequestStringToProtobufBean(String requestString) {
    try {
      byte[] decodedBytes = Base64.getDecoder().decode(requestString);
      return GetMapObjectsResponse.GetMapObjectResponse.parseFrom(decodedBytes);
    } catch (InvalidProtocolBufferException e) {
      logger.error("Can't parse the object with ProtocolBuffer: " + e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }

  private EncounterResponseOuterClass.EncounterResponse encounterRequestStringToProtobufBean(String requestString) {
    try {
      byte[] decodedBytes = Base64.getDecoder().decode(requestString);
      return EncounterResponseOuterClass.EncounterResponse.parseFrom(decodedBytes);
    } catch (InvalidProtocolBufferException e) {
      logger.error("Can't parse the object with ProtocolBuffer: " + e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }

  private void mapCellAnalysis(MapCellOuterClass.MapCell mapCell) {
    logger.info("MapCell analysis... Pokemons founds: " + mapCell.getNearbyPokemonsCount() + " Nearby, " + mapCell.getCatchablePokemonsCount() + " Cachable, " + mapCell.getWildPokemonsCount() + " Wild");
    mapCell.getNearbyPokemonsList().forEach(this::lookingForParticularNearbyPokemon);
    mapCell.getWildPokemonsList().forEach(this::printingWildPokemonsData);
  }

  private void lookingForParticularNearbyPokemon(NearbyPokemonOuterClass.NearbyPokemon nearbyPokemon) {

    switch (nearbyPokemon.getPokemonId()) {
      case 214 : case 222 : case 324 : case 336 : case 369 : case 314 : case 313 : case 357 : case 417 : case 441 : case 455 :
        logger.info("Found regional Pokemon !!");
        logger.info("There is a " + PokemonEnum.toString(nearbyPokemon.getPokemonId()) + " at " + nearbyPokemon.getDistanceInMeters() + "M");
      default :
        break;
    }
  }

  private void printingWildPokemonsData(WildPokemonOuterClass.WildPokemon wildPokemon) {
    PokemonDataOuterClass.PokemonData pokemonData = wildPokemon.getPokemonData();
    String message = "Wild Pokemon found: " + PokemonEnum.toString(pokemonData.getPokemonId()) + ", stats: " + pokemonData.getIndividualAttack() + "-" + pokemonData.getIndividualDefense() + "-" + pokemonData.getIndividualStamina();
    logger.info(message);
    alertService.managePokemonAlert(wildPokemon);
  }
}
