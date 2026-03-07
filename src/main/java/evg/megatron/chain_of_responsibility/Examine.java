package evg.megatron.chain_of_responsibility;

public abstract class Examine {
    private Examine next;

    public Examine linkWith(Examine next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(PokemonMaster pokemonMaster);

    public boolean checkNext(PokemonMaster pokemonMaster) {
        if (next == null) {
            return true;
        }

        return next.check(pokemonMaster);
    }

}
