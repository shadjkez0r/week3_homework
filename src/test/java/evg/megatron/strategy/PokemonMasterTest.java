package evg.megatron.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PokemonMasterTest {
    private PokemonMaster ash;
    private Pokemon pikachu;
    private Pokemon raychu;
    private Pokemon charmander;
    private CityLocation cityLocation = new CityLocation();
    private FieldLocation fieldLocation = new FieldLocation();
    private ForestLocation forestLocation = new ForestLocation();

    @BeforeEach
    void setup() {
        ash = new PokemonMaster("Ash Ketchum");
        pikachu = new Pokemon("Pikachu", 1);
        raychu = new Pokemon("Raychu", 2);
        charmander = new Pokemon("Charmander", 1);
    }


    @Test
    @DisplayName("если через сеттер не указать локацию, покемон не будет добавлен")
    void shouldNotCatchPokemonIfLocationIsNotSet() {
        ash.catchPokemon(pikachu);
        assertThat(ash.getPokemons()).isEmpty();
    }

    @Test
    @DisplayName("меняя локацию местности у покемонмастера на ходу, мы успешно добавляем разных покемонов")
    void shouldCatchPokemonIfLocationIsSet() {
        ash.moveTo(cityLocation);
        ash.catchPokemon(pikachu);

        ash.moveTo(forestLocation);
        ash.catchPokemon(raychu);

        ash.moveTo(fieldLocation);
        ash.catchPokemon(charmander);

        assertThat(ash.getPokemons()).hasSize(3);
    }
}
