package fr.rginfo.philou.pgo.map.model;

public enum PokemonEnum {
  BULBIZARRE,
  HERBIZARRE,
  FLORIZARRE,
  SALAMECHE,
  REPTINCEL,
  DRACAUFEU,
  CARAPUCE,
  CARABAFFE,
  TORTANK,
  CHENIPAN,
  CHRYSACIER,
  PAPILUSION,
  ASPICOT,
  COCONFORT,
  DARDARGNAN,
  ROUCOOL,
  ROUCOUPS,
  ROUCARNAGE,
  RATTATA,
  RATTATAC,
  PIAFABEC,
  RAPASDEPIC,
  ABO,
  ARBOK,
  PIKACHU,
  RAICHU,
  SABELETTE,
  SABLAIREAU,
  NIDORANF,
  NIDORINA,
  NIDOQUEEN,
  NIDORANM,
  NIDORINO,
  NIDOKING,
  MELOFEE,
  MELODELFE,
  GOUPIX,
  FEUNARD,
  RONDOUDOU,
  GRODOUDOU,
  NOSFERAPTI,
  NOSFERALTO,
  MYSTHERBE,
  ORTIDE,
  RAFFLESIA,
  PARAS,
  PARASECT,
  MIMITOSS,
  AEROMITE,
  TAUPIQUEUR,
  TRIOPIKEUR,
  MIAOUSS,
  PERSIAN,
  PSYKOKWAK,
  AKWAKWAK,
  FEROSINGE,
  COLOSSINGE,
  CANINOS,
  ARCANIN,
  PTITARD,
  TETARTE,
  TARTARD,
  ABRA,
  KADABRA,
  ALAKAZAM,
  MACHOC,
  MACHOPEUR,
  MACKOGNEUR,
  CHETIFLOR,
  BOUSTIFLOR,
  EMPIFLOR,
  TENTACOOL,
  TENTACRUEL,
  RACAILLOU,
  GRAVALANCH,
  GROLEM,
  PONYTA,
  GALOPA,
  RAMOLOSS,
  FLAGADOSS,
  MAGNETI,
  MAGNETON,
  CANARTICHO,
  DODUO,
  DODRIO,
  OTARIA,
  LAMANTINE,
  TADMORV,
  GROTADMORV,
  KOKIYAS,
  CRUSTABRI,
  FANTOMINUS,
  SPECTRUM,
  ECTOPLASMA,
  ONIX,
  SOPORIFIK,
  HYPNOMADE,
  KRABBY,
  KRABBOSS,
  VOLTORBE,
  ELECTRODE,
  NOEUNOEUF,
  NOADKOKO,
  OSSELAIT,
  OSSATUEUR,
  KICKLEE,
  TYGNON,
  EXCELANGUE,
  SMOGO,
  SMOGOGO,
  RHINOCORNE,
  RHINOFEROS,
  LEVEINARD,
  SAQUEDENEU,
  KANGOUREX,
  HYPOTREMPE,
  HYPOCEAN,
  POISSIRENE,
  POISSOROY,
  STARI,
  STAROSS,
  MMIME,
  INSECATEUR,
  LIPPOUTOU,
  ELEKTEK,
  MAGMAR,
  SCARABRUTE,
  TAUROS,
  MAGICARPE,
  LEVIATOR,
  LOKHLASS,
  METAMORPH,
  EVOLI,
  AQUALI,
  VOLTALI,
  PYROLI,
  PORYGON,
  AMONITA,
  AMONISTAR,
  KABUTO,
  KABUTOPS,
  PTERA,
  RONFLEX,
  ARTIKODIN,
  ELECTHOR,
  SULFURA,
  MINIDRACO,
  DRACO,
  DRACOLOSSE,
  MEWTWO,
  MEW;

  public static PokemonEnum fromInt(int code) {
    return PokemonEnum.values()[code];
  }

  public static String toString(int code) {
    if (code >= PokemonEnum.values().length) {
      return "" + code;
    }

    String stringUpperCaseValue = PokemonEnum.fromInt(code).toString();
    return stringUpperCaseValue.substring(0, 1) + stringUpperCaseValue.substring(1).toLowerCase();
  }
}
