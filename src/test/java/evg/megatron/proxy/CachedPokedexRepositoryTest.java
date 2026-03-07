package evg.megatron.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class CachedPokedexRepositoryTest {
    private Repository proxyRepo;

    @BeforeEach
    public void setup() {
        Pokedex pokedex = new Pokedex("Ash Pokedex");
        Repository realRepo = new PokedexRepository(pokedex);
        proxyRepo = new CachedPokedexRepository(realRepo);
        proxyRepo.addPokemonsToDb(List.of(
                new Pokemon("Pikachu", "Electric", 8),
                new Pokemon("Haunter", "Ghost", 7),
                new Pokemon("Gungar", "Ghost", 6),
                new Pokemon("Charizard", "Fire", 5),
                new Pokemon("Mewtwo", "Psychic", 4),
                new Pokemon("Slowpoke", "Water", 3)
        ));
    }

    @Test
    @DisplayName("Первый запрос идет 5 секунд, второй возвращается моментально из кэша")
    void shouldCachedDataAfterFirstLoad() {
        // первый запрос
        long startTimeFirst = System.currentTimeMillis();
        List<Pokemon> firstCallResult = proxyRepo.loadAllPokemons();
        long endTimeFirst = System.currentTimeMillis();
        long firstCallDuration = endTimeFirst - startTimeFirst;

        //убеждаемся что запрос шел 5 секунд или больше
        assertThat(firstCallDuration).isGreaterThan(4000);
        assertThat(firstCallResult).hasSize(6);

        // второй запрос должен быть из кэша
        long startTimeSecond = System.currentTimeMillis();
        List<Pokemon> secondCallResult = proxyRepo.loadAllPokemons();
        long endTimeSecond = System.currentTimeMillis();
        long secondCallDuration = endTimeSecond - startTimeSecond;

        // запрос должен быть быстрее 1 секунды
        assertThat(secondCallDuration).isLessThanOrEqualTo(2000);

        // убеждаемся что списки идентичны
        assertThat(secondCallResult).isEqualTo(firstCallResult);
    }

    @Test
    @DisplayName("Кэш должен сброситься при добавлении новых данных в БД")
    void shouldDropCacheAfterAddedNewData() {
        // кэшируем запрос
        List<Pokemon> firstCallResult = proxyRepo.loadAllPokemons();

        // убеждаемся что запрос закэширован
        long startTimeFirst = System.currentTimeMillis();
        List<Pokemon> secondCallResult = proxyRepo.loadAllPokemons();
        long endTimeFirst = System.currentTimeMillis();
        long secondCallDuration = endTimeFirst - startTimeFirst;
        assertThat(secondCallDuration).isLessThanOrEqualTo(2000);
        assertThat(firstCallResult).isEqualTo(secondCallResult);

        // добавляем новые данные в БД, кэш должен сброситься
        proxyRepo.addPokemonsToDb(List.of(
                new Pokemon("Test1", "Test", 100),
                new Pokemon("Test2", "Test", 100),
                new Pokemon("Test3", "Test", 100)
        ));

        // проверяем закэшировались данные или нет
        long startTimeThird = System.currentTimeMillis();
        List<Pokemon> thirdCallResult = proxyRepo.loadAllPokemons();
        long endTimeThird = System.currentTimeMillis();
        long thirdCallDuration = endTimeThird - startTimeThird;
        assertThat(thirdCallDuration).isGreaterThan(4000);

    }
}
