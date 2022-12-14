package Less_36_ch_1_Scanner;
/*
Простой пример работы класса Scanner и его методы:
*.next();
*.hasNext();
Мы используем в качестве разделителя строк метод
*.useDelimeter() класса Scanner. Он отвечает за
деление входящих данных на части. В нашем случае
для разделения строк в качестве аргумента передаётся
и используется одиночная кавычка ("***").
ПОВТОРИМ:
- *.next () - считывает введённую строку до первого пробела;
- *.nextLine () - считывает всю введённую строку;
- *.nextInt () - считывает введённое число int;
- *.nextDouble () - считывает введённое число double;
*/
import java.util.Scanner;

public class Less_36_Scanner_Step4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(
                "Корабли постоят и ложатся на курс,\n" +
                "Но они возвращаются сквозь непогоду…\n" +
                "Не пройдёт и полгода — и я появлюсь,\n" +
                "Чтобы снова уйти,\n" +
                "чтобы снова уйти на полгода.\n" +
                "***" +
                "Возвращаются все, кроме лучших друзей,\n" +
                "Кроме самых любимых и преданных женщин.\n" +
                "Возвращаются все, — кроме тех, кто нужней.\n" +
                "Я не верю судьбе,\n" +
                "я не верю судьбе, а себе — ещё меньше.\n" +
                "***" +
                "И мне хочется верить, что это не так,\n" +
                "Что сжигать корабли скоро выйдет из моды.\n" +
                "Я, конечно, вернусь — весь в друзьях и в мечтах,\n" +
                "Я, конечно, спою — не пройдёт и полгода.\n");

        scan.useDelimiter("\\*{3}");

        while (scan.hasNext()) {
            System.out.println(scan.next());
        }

        scan.close();
    }
}