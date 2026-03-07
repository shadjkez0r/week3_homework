package evg.megatron.adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class LegacyCsvService {
    public void writeCsv(LooneyTunesCharacter character) {
        String name = character.getName();
        String gender = character.getGender().toString();
        int yearOfRelease = character.getYearOfRelease();
        String result = name + ";" + gender + ";" + yearOfRelease + "\n";

        Path path = Path.of(
                ".", "src", "main", "resources", "looney_tunes_characters.csv");
        try {
            Files.writeString(path, result, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeCsv(List<LooneyTunesCharacter> characters) {
        for (LooneyTunesCharacter character : characters) {
            writeCsv(character);
        }
    }
}
