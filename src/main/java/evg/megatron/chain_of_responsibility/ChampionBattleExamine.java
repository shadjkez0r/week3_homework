package evg.megatron.chain_of_responsibility;

public class ChampionBattleExamine extends Examine {
    @Override
    public boolean check(PokemonMaster pokemonMaster) {
        if (pokemonMaster.getPokemons().size() < 6) {
            System.out.println("К битве с Чемпионом допускается только тренера с 6 и более покемонами!");
            return false;
        }

        if (pokemonMaster.getWinsQuantity() < 17) {
            System.out.println("Мастер " + pokemonMaster.getName() + " достойно сражался, но проиграл");
            System.out.println("Чемпион защитил свой титул");
            return false;
        }

        System.out.println("Победа! " + pokemonMaster.getName() + " становится новым Абсолютным Чемпионом региона!");
        return checkNext(pokemonMaster);
    }
}
