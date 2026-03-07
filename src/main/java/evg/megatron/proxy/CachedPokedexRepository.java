package evg.megatron.proxy;

import java.util.List;

public class CachedPokedexRepository implements Repository {
    // ссылка на оригинальный (медленный) репозиторий
    private final Repository realRepository;

    // наш кэш бд
    private List<Pokemon> cache;

    public CachedPokedexRepository(Repository realRepository) {
        this.realRepository = realRepository;
    }

    @Override
    public void addPokemonsToDb(List<Pokemon> pokemons) {
        realRepository.addPokemonsToDb(pokemons);
        cache = null;
    }

    @Override
    public void addPokemonToDb(Pokemon pokemon) {
        realRepository.addPokemonToDb(pokemon);
        cache = null;
    }

    @Override
    public List<Pokemon> loadAllPokemons() {
        if (cache == null) {
            System.out.println("Кэш пуст, делегирую запрос в реальную БД...");
            cache = realRepository.loadAllPokemons();
        } else {
            System.out.println("Данные найдены в памяти, возвращаю кэш моментально!");
        }
        return cache;
    }
}
