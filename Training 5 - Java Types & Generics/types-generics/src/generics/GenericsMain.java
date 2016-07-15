package generics;

/**
 * Created by iciuta on 7/15/2016.
 */
public class GenericsMain {
    public static void main(String[] args) {
        EndavaStack<Pokemon> pokedex = new EndavaStack<>(new Pokemon("Pikachu", 10),
                                                         new Pokemon("Raichu", 20),
                                                         new Pokemon("Jolteon", 25));

        pokedex.push(new Pokemon("Ratata", 2));
        System.out.println(pokedex.toString());
        System.out.println(pokedex.size());

        pokedex.pop();
        System.out.println(pokedex.toString());
        System.out.println(pokedex.size());

        /*---------------------------------------------------------------------------*/
        NumericEndavaStack<Integer> calculator = new NumericEndavaStack<>(12, 14, 18, 100, 1, 101, 200, 300);
        System.out.println(calculator);
        System.out.println(calculator.getMax());
    }


    private static class Pokemon {
        private String name;
        private Integer level;

        public Pokemon(String name, Integer level) {
            this.name = name;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "Pokemon{" +
                    "name='" + name + '\'' +
                    ", level=" + level +
                    '}';
        }
    }
}
