package fr.rginfo.philou.pgo.map.alert;

import fr.rginfo.philou.pgo.map.alert.mail.MailRecipient;
import fr.rginfo.philou.pgo.map.alert.mail.MailService;
import fr.rginfo.philou.pgo.map.model.json.PokemonEnum;
import org.springframework.util.Assert;
import pogoprotos.networking.responses.PokemonDataOuterClass;
import pogoprotos.networking.responses.WildPokemonOuterClass;

public class AlertService {

  private final MailService mailService;

  private final AlertRepository alertRepository;

  public AlertService(MailService mailService, AlertRepository alertRepository) {
    Assert.notNull(mailService, "MailService can't be null");
    Assert.notNull(mailService, "AlertRepository can't be null");
    this.mailService = mailService;
    this.alertRepository = alertRepository;
  }

  public void managePokemonAlert(WildPokemonOuterClass.WildPokemon wildPokemon) {
    Integer iv = getPokemonIv(wildPokemon.getPokemonData());
    alertRepository.findAll().forEach(alertBean -> {
        if (iv > alertBean.getMinIv()) {
          mailService.sendMessageToRecipient(new MailRecipient().setEmail(alertBean.getEmail()), this.getMessagePokemon(wildPokemon.getPokemonData()));
        }
    });
  }

  private Integer getPokemonIv(PokemonDataOuterClass.PokemonData pokemonData) {
    return (pokemonData.getIndividualAttack() + pokemonData.getIndividualDefense() + pokemonData.getIndividualStamina()) * 100 / 45;
  }


  private String getMessagePokemon(PokemonDataOuterClass.PokemonData pokemonData) {
    return "Wild Pokemon found: " + PokemonEnum.toString(pokemonData.getPokemonId()) + ", stats: " + pokemonData.getIndividualAttack() + "-" + pokemonData.getIndividualDefense() + "-" + pokemonData.getIndividualStamina();
  }
}
