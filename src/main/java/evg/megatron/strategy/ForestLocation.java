package evg.megatron.strategy;

public class ForestLocation implements Location {
    @Override
    public void learnLocationBeforeCatchPokemon() {
        System.out.println("Изучаем локацию ЛЕС, прежде чем начать ловить покемона");
    }

    @Override
    public String toString() {
        return "ЛЕС";
    }
}

