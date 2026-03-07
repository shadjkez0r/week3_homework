package evg.megatron.chain_of_responsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class PokemonExamineServiceTest {
    private PokemonExamineService pokemonExamineService;
    private PokemonMaster ash;

    @BeforeEach
    void setup() {
        pokemonExamineService = new PokemonExamineService();

        ash = new PokemonMaster("Ash");
        ash.catchPokemon(List.of(
                new Pokemon("Pikachu", 10),
                new Pokemon("Raychu", 10),
                new Pokemon("Charizard", 10),
                new Pokemon("Haunter", 10),
                new Pokemon("Gengar", 10),
                new Pokemon("Mewtwo", 10)
        ));


    }

    @Test
    @DisplayName("Тренер не проходит дальше, если у него меньше 8 значков")
    void shouldFailGymExamWhenNotEnoughBagdes() {
        ash.setBadgesQuantity(7);
        ash.setWinsQuantity(20);

        boolean result = pokemonExamineService.startChallenge(ash);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Тренер вылетает из Региональной лиги, если у него меньше 12 побед")
    void shouldFailRegionalExamWhenWinsIsLessThen12() {
        ash.setWinsQuantity(11);
        ash.setBadgesQuantity(100);

        boolean result = pokemonExamineService.startChallenge(ash);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Тренер вылетает из Элитной Четверки, если у него меньше 16 побед")
    void shouldFailEliteExamWhenWinsIsLessThen16() {
        ash.setWinsQuantity(15);
        ash.setBadgesQuantity(100);

        boolean result = pokemonExamineService.startChallenge(ash);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Тренер проигрывает борьбу за титул Чемпиона, если у него меньше 17 побед")
    void shouldFailChampionExamWhenWinsIsLessThen17() {
        ash.setWinsQuantity(16);
        ash.setBadgesQuantity(100);

        boolean result = pokemonExamineService.startChallenge(ash);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Тренер успешно становится Чемпионом Региона, " +
            "если он победил всех соперников " +
            "т.е его количество побед равно или больше 17")
    void shouldPassFullChainAndBecomeChampionIfHeHas17OrMoreWins() {
        ash.setWinsQuantity(17);
        ash.setBadgesQuantity(100);

        boolean result = pokemonExamineService.startChallenge(ash);
        assertThat(result).isTrue();
    }
}
