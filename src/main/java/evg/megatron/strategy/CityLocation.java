package evg.megatron.strategy;

public class CityLocation implements Location {
    @Override
    public void learnLocationBeforeCatchPokemon() {
        System.out.println("Изучаю локацию ГОРОД, прежде чем начать ловить покемона...");
    }

    @Override
    public String toString() {
        return "ГОРОД";
    }
}
