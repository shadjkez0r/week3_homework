package evg.megatron.proxy;

import java.util.Objects;

public class Pokemon {
    private String name;
    private String type;
    private int level;

    public Pokemon(String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return level == pokemon.level && Objects.equals(name, pokemon.name) && Objects.equals(type, pokemon.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, level);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                '}';
    }
}
