package evg.megatron.proxy;

import java.util.List;

public class PokedexRepository implements Repository {
    Pokedex pokedex;

    public PokedexRepository(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public void addPokemonsToDb(List<Pokemon> pokemons) {
        pokedex.addPokemonToDb(pokemons);
    }

    @Override
    public void addPokemonToDb(Pokemon pokemon) {
        pokedex.addPokemonToDb(pokemon);
    }

    @Override
    public List<Pokemon> loadAllPokemons() {
        System.out.println("Имитация долго запроса к БД, будет длиться 5 секунд");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Покемоны успешно загружены");
        return pokedex.getPokemonsDb();
    }
}
