package Less_35_Enum;
/*
Программа, измеряет вес на Земле (в фунтах, хотя можно и в кило.),
вычисляет и печатает вес на всех планетах (в тех же единицах):
*/
import Less_35_Enum.MyEnum.Planet;
import static Less_35_Enum.MyEnum.Planet.EARTH;

public class Less_35_Enum_Step2 {
    public static void main(String[] args) {
        // Вес в фунтах: 1 фунт - 0,4536 кг
        double weight = 175.0;
        // Проверяем вес 'космонавта'
        if (weight < 48.0) {
            System.err.println("Usage: java Planet <earth_weight> or eat better!");
            System.exit(-1);
        }
        /*
        Расчет веса на других планетах, тоже в фунтах.
        Основные расчеты идут в методах самого Enum классе.
        */
        double earthWeight = weight;
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));

        System.out.println("------------------------------------------------------");
        // Выводим полный список объектов Enum
        for (Planet p : Planet.values()){
            System.out.println(p);
        }
    }
}
