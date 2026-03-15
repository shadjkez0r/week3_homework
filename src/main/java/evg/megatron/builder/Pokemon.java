package evg.megatron.builder;

public class Pokemon {
    private final String name;
    private final PokemonType type;
    private final int level;
    private final Gender gender;
    private final double weight;
    private final double height;
    private final PsychoType psychoType;

    private Pokemon(PokemonBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.level = builder.level;
        this.gender = builder.gender;
        this.weight = builder.weight;
        this.height = builder.height;
        this.psychoType = builder.psychoType;
    }

    public static PokemonBuilder builder(String name, PokemonType type) {
        return new PokemonBuilder(name, type);
    }

    public String getName() {
        return name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public Gender getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public PsychoType getPsychoType() {
        return psychoType;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                ", psychoType=" + psychoType +
                '}';
    }

    public static class PokemonBuilder {
        private final String name;
        private final PokemonType type;
        private int level;
        private Gender gender;
        private double weight;
        private double height;
        private PsychoType psychoType;


        private PokemonBuilder(String name, PokemonType type) {
            this.name = name;
            this.type = type;
        }

        public PokemonBuilder level(int level) {
            this.level = level;
            return this;
        }

        public PokemonBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public PokemonBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public PokemonBuilder height(double height) {
            this.height = height;
            return this;
        }

        public PokemonBuilder psychoType(PsychoType psychoType) {
            this.psychoType = psychoType;
            return this;
        }

        public Pokemon build() {
            return new Pokemon(this);
        }
    }
}
