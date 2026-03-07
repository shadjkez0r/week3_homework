package evg.megatron.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PokemonMaster {
    private final String name;
    private final List<Pokemon>  pokemons;

    // наша Стратегия - поведение, которое привязанно к классу ПокемонМастер
    // Класс постоянно хранит информацию о том, по какой стратегии он живет
    private Location currentLocation;

    public PokemonMaster(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    // сеттер для смены стратегии на лету
    public void moveTo(Location location) {
        this.currentLocation = location;
        System.out.println(this.name + " переместился в локацию: " + this.currentLocation);
    }

    public void catchPokemon(Pokemon pokemon) {
        if (currentLocation == null) {
            System.out.println("Сначала выбери локацию куда пойти!");
            return;
        }
        currentLocation.learnLocationBeforeCatchPokemon();
        pokemons.add(pokemon);
        System.out.println("Пойман покемон: " + pokemon.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonMaster that = (PokemonMaster) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public String toString() {
        return "PokemonMaster{" +
                "name='" + name + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }
}
