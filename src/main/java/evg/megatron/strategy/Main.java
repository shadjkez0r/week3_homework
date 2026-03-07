package evg.megatron.strategy;

public class Main {
    static void main() {
        PokemonMaster ash = new PokemonMaster("Эш Кетчум");
        Pokemon pikachu = new Pokemon("Pikachu", 10);
        Pokemon pidgey = new Pokemon("Pidgey", 5);

        // 1. Выбираем стратегию (Город)
        ash.moveTo(new CityLocation());
        ash.catchPokemon(pikachu);
        // Вывод: Изучаю местность города... Пойман Pikachu

        System.out.println("---");

        // 2. ПРЯМО НА ЛЕТУ меняем стратегию (Лес)
        ash.moveTo(new ForestLocation());
        ash.catchPokemon(pidgey);
        // Вывод: Изучаем локацию Лес... Пойман Pidgey
    }
}
