package Less_38_ch_1_Annotation.HeroClassesAndAnnotation;

import java.util.Objects;
@MySecondAnnotation
public class Hero {

    /*
    В данном случае, если разместить аннотацию
    @MySecondAnnotation, то будет предупреждение
    от среды разработки, т.е. данная аннотация
    предназначена нами же для Методов и Классов.
    */
    private String heroName;
    private double heroPower;

    public Hero(String heroName, double heroPower) {
        this.heroName = heroName;
        this.heroPower = heroPower;
    }

    // Аннотации легко могут идти каскадом
    @MySecondAnnotation
    @MyFirstAnnotation
    public void increasePower(){
        heroPower *= 2;
    }

    public String getHeroName() {
        return heroName;
    }

    public double getHeroPower() {
        return heroPower;
    }

    @Override
    public String toString() {
        return "Hero: {" +
                "heroName='" + heroName + '\'' +
                ", heroPower=" + heroPower +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return heroPower == hero.heroPower &&
               Objects.equals(heroName, hero.heroName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroName, heroPower);
    }
}
