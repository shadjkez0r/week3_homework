package evg.megatron.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PokemonTest {
    private Pokemon pokemon;


    @Test
    @DisplayName("Мы можем создать покемона через билдер," +
            " указав только обязательные аргументы в констукторе билдера.")
    void shouldCreatePokemonThroughBuilderOnlyRequiredArgumentsAtBuilderConstructor() {
        pokemon = Pokemon.builder("Pikachu", PokemonType.ELECTRIC).build();

        assertThat(pokemon).isNotNull();
    }

    @Test
    @DisplayName("Мы можем создать покемона, указывая необязательные аргументы в любом порядке")
    void shouldCreatePokemonThroughBuilderWithUnrequiredArgumentsAtAnyOrder() {
        pokemon = Pokemon.builder("Pikachu", PokemonType.ELECTRIC)
                .gender(Gender.MALE)
                .height(10)
                .level(100)
                .psychoType(PsychoType.CHOLERIC)
                .weight(30)
                .build();

        assertThat(pokemon).isNotNull();
    }
}
