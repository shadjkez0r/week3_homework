package evg.megatron.adapter;

import com.google.gson.Gson;

public class JsonToCsvAdapter implements Loadable {
    private final LegacyCsvService legacyCsvService;
    private final Gson gson;

    public JsonToCsvAdapter(LegacyCsvService legacyCsvService) {
        this.legacyCsvService = legacyCsvService;
        this.gson = new Gson();
    }

    @Override
    public void loadCharacter(String jsonData) {
        LooneyTunesCharacter character = gson.fromJson(jsonData, LooneyTunesCharacter.class);
        legacyCsvService.writeCsv(character);
    }

}
