package evg.megatron.chain_of_responsibility;

public class RegionalLeagueExamine extends Examine {
    @Override
    public boolean check(PokemonMaster pokemonMaster) {
        if (pokemonMaster.getWinsQuantity() < 12) {
            System.out.println("Мастер: " + pokemonMaster.getName() + " вылетел из регионального турнира!");
            System.out.println("Т.к у него меньше 12 побед");
            return false;
        }

        System.out.println("Региональная лига выйграна! Путь к Элитной Четверке открыт!");
        return checkNext(pokemonMaster);
    }
}
