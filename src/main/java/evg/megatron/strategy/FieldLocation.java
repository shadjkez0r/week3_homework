package evg.megatron.strategy;

public class FieldLocation implements Location {
    @Override
    public void learnLocationBeforeCatchPokemon() {
        System.out.println("Изучаем локацию ПОЛЕ, прежде чем начать ловить покемона");
    }

    @Override
    public String toString() {
        return "ПОЛЕ";
    }
}

