package evg.megatron.proxy;

import java.util.List;

public interface Repository {
    void addPokemonsToDb(List<Pokemon> pokemons);
    void addPokemonToDb(Pokemon pokemon);
    List<Pokemon> loadAllPokemons();
}
