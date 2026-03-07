package evg.megatron.chain_of_responsibility;

public class PokemonExamineService {
    private final Examine challengeChain;

    public PokemonExamineService() {
        Examine badgeExamine = new GymBadgeExamine();
        Examine leagueExamine = new RegionalLeagueExamine();
        Examine eliteExamine = new EliteFourExamine();
        Examine championExamine = new ChampionBattleExamine();

        badgeExamine.linkWith(leagueExamine).linkWith(eliteExamine).linkWith(championExamine);

        this.challengeChain = badgeExamine;
    }

    public boolean startChallenge(PokemonMaster pokemonMaster) {
        return challengeChain.check(pokemonMaster);
    }
}
