package Less_35_Enum;

import Less_35_Enum.MyEnum.AnotherDay;
import Less_35_Enum.MyEnum.Day;

import java.util.Arrays;

/*
Тестируем методы сравнения *.equals() и *.valueOf()
*/
public class Less_35_Enum_Step3 {
    public static void main(String[] args) {

        Day d1 = Day.MONDAY;
        // Объект отличного от Day перечисления
        AnotherDay d2 = AnotherDay.MONDAY;
        Day d3 = Day.SUNDAY;
        Day d4 = Day.MONDAY;

        System.out.println("d1 == d4 -> " + (d1 == d4)); // true
        System.out.println("d1 == d3 -> " + (d1 == d3)); // false
        /*
        Так нельзя:
        System.out.println(d1 == d2);
        но можно через *.equals()

        !!! Хотя и там и там MONDAY, объекты разные и
        будет false !!!

        */
        System.out.println("d1 == d4 -> " + d1.equals(d2)); // false
        // Объекты одного Enum
        System.out.println("d1 == d4 -> " + d1.equals(d4)); // true
        /*
        Превращаем текст в объект Enum, однако введенный текст
        должен четко соответствовать названиям объектов Enum.

        Например 'SUNDAY' преобразуется правильно, а вот 'sunday'
        или другое написание выкинет: " IllegalArgumentException:
        No enum constant Less_35_ch_1_Enum.MyEnum.Day.sunday "
        исключение.
        */
        Day d5 = Day.valueOf("SUNDAY");
        System.out.println("d5 == d3 -> " + (d5 == d3)); // true
        System.out.println("------------------------------------------------------");
        // Подобный пример рассмотрен в  Less_35_Enum_Step2
        for (Day d: Day.values()) {
            System.out.println(d);
        }
        System.out.println("------------------------------------------------------");
        Day[] weekdays = Day.values();
        System.out.println(Arrays.toString(weekdays));
    }
}
