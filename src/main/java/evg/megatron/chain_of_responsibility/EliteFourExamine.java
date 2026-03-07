package evg.megatron.chain_of_responsibility;

public class EliteFourExamine extends Examine {
    @Override
    public boolean check(PokemonMaster pokemonMaster) {
        if (pokemonMaster.getWinsQuantity() < 16) {
            System.out.println("Мастер " + pokemonMaster.getName() + " не смог одолеть Элитную Четверку");
            System.out.println("Количество побед у Эша: " + pokemonMaster.getWinsQuantity());
            return false;
        }

        System.out.println("Элитная Четверка повержена! Впереди битва с Чемпионом!");
        return checkNext(pokemonMaster);
    }
}
