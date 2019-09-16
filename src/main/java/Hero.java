

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String hero_name;
    private int age;
    private String squad;
    private String powers;
    private String weakness;
    private static List<Hero> instances = new ArrayList<Hero>();

    public Hero(String name, int age, String squad, String powers, String weakness) {
        this.hero_name = name;
        this.age = age;
        this.squad = squad;
        this.powers = powers;
        this.weakness = weakness;
        instances.add(this);
    }

    public String getName() {
        return hero_name;
    }

    public int getAge() {
        return age;
    }

    public String getSquad() {
        return squad;
    }

    public String getPowers() {
        return powers;
    }

    public String getWeakness() {
        return weakness;
    }
    public static List<Hero> all() {
        return instances;
    }
}
