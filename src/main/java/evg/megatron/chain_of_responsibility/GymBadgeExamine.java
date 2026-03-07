package evg.megatron.chain_of_responsibility;

public class GymBadgeExamine extends Examine {

    @Override
    public boolean check(PokemonMaster pokemonMaster) {

        if (pokemonMaster.getBadgesQuantity() < 8) {
            System.out.println("Вы собрали только: " + pokemonMaster.getBadgesQuantity());
            System.out.println("Вам нужно минимум 8 значков для пропуска в Региональную лигу");
            return false;
        }

        System.out.println("8 значков получено. Пропуск в Региональную лигу открыт!");
        return checkNext(pokemonMaster);
    }
}
