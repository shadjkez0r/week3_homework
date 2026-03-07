package evg.megatron.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pokedex {
    private final String name;
    private final List<Pokemon> pokemonsDb;

    public Pokedex(String name) {
        this.name = name;
        this.pokemonsDb = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemonsDb() {
        return Collections.unmodifiableList(pokemonsDb);
    }

    public void addPokemonToDb(Pokemon pokemon) {
        pokemonsDb.add(pokemon);
    }

    public void addPokemonToDb(List<Pokemon> pokemons) {
        pokemonsDb.addAll(pokemons);
    }

    public void showAllInfo() {
        for (Pokemon pokemon : pokemonsDb) {
            System.out.println(pokemon);
        }
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "name='" + name + '\'' +
                ", pokemonsDb=" + pokemonsDb +
                '}';
    }
}
