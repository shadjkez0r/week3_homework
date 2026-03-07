package evg.megatron.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonMaster {
    private final String name;
    private final List<Pokemon> pokemons;
    private int badgesQuantity;
    private int winsQuantity;

    public PokemonMaster(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.badgesQuantity = 0;
        this.winsQuantity = 0;
    }

    public void catchPokemon(Pokemon pokemon) {
        System.out.println("Покемона: " + pokemon + ", успешно пойман!");
        pokemons.add(pokemon);
    }

    public void catchPokemon(List<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            this.catchPokemon(pokemon);
        }
    }

    public void fightWithOtherPokemonMaster(PokemonMaster enemy) {
        long sumOfOurPokemonsLevel = pokemons
                .stream()
                .mapToInt(Pokemon::getLevel)
                .sum();

        long sumOfEnemyPokemonsLevel = enemy.getPokemons()
                .stream()
                .mapToInt(Pokemon::getLevel)
                .sum();

        if (sumOfOurPokemonsLevel == sumOfEnemyPokemonsLevel) {
            System.out.println("Ничья, прокачайте покемонов и попробуйте снова...");
            return;
        }
        boolean isWeWin = sumOfOurPokemonsLevel > sumOfEnemyPokemonsLevel;
        if (isWeWin) {
            System.out.println("Мы выйграли: " + enemy.getName());
            this.badgesQuantity++;
            this.winsQuantity++;
        } else {
            System.out.println("Вы проиграли, бро, надо тренироваться...");
            enemy.badgesQuantity++;
            enemy.winsQuantity++;
        }
    }


    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }


    public int getBadgesQuantity() {
        return badgesQuantity;
    }

    public void setBadgesQuantity(int badgesQuantity) {
        this.badgesQuantity = badgesQuantity;
    }

    public int getWinsQuantity() {
        return winsQuantity;
    }

    public void setWinsQuantity(int winsQuantity) {
        this.winsQuantity = winsQuantity;
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

    @Override
    public String toString() {
        return "PokemonMaster{" +
                "name='" + name + '\'' +
                ", pokemons=" + pokemons +
                ", badgesQuantity=" + badgesQuantity +
                ", winsQuantity=" + winsQuantity +
                '}';
    }
}
