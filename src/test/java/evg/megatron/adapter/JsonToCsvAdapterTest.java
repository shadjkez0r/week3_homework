package evg.megatron.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;


import static org.assertj.core.api.Assertions.assertThat;

public class JsonToCsvAdapterTest {
    private final LegacyCsvService legacyCsvService = new  LegacyCsvService();
    private JsonToCsvAdapter adapter = new JsonToCsvAdapter(legacyCsvService);
    Path path = Path.of(".", "src", "main", "resources", "looney_tunes_characters.csv");

    @Test
    @DisplayName("Адаптер принимает json,создает объект и записывает его в csv через старый сервис")
    void shouldWriteCsvFileFromJson() {
        String bugsBunnyJson = "{\"name\":\"Bugs Bunny\",\"gender\":\"MALE\",\"yearOfRelease\":1940}";
        String lolaBunnyJson = "{\"name\":\"Lola Bunny\",\"gender\":\"FEMALE\",\"yearOfRelease\":1996}";

        adapter.loadCharacter(bugsBunnyJson);
        adapter.loadCharacter(lolaBunnyJson);

        assertThat(Files.exists(path)).isTrue();
    }

}
