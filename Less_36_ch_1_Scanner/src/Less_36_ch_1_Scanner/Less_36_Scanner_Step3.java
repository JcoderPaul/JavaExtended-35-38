package Less_36_ch_1_Scanner;
/*
Простой пример работы класса Scanner и его методов:
*.next();
*.hasNext();
Методы с уточнением:
*.hasNextInt() — метод проверяет, является ли следующая
                 порция введенных данных числом, или нет
                 (возвращает true/false).

*.hasNextLine() — проверяет, является ли следующая порция
                  данных строкой.

*.hasNextByte(), *.hasNextShort(), *.hasNextLong(),
*.hasNextFloat(), *.hasNextDouble() — все эти методы делают
то же для остальных типов данных, что и *.hasNextInt().
*/
import java.util.Scanner;

public class Less_36_Scanner_Step3 {
    public static void main(String[] args) {
        /*
        Как написано в описании к классу Scanner, в
        качестве аргумента его конструктор может
        принимать разнообразные источники. В данном
        примере мы передаем строку.
         */
        Scanner in = new Scanner("Люблю тебя, Петра творенье,\n" +
                                       "Люблю твой строгий, стройный вид,\n" +
                                       "Невы державное теченье,\n" +
                                       "Береговой ее гранит");
        System.out.println("---------------- *.nextLine() ----------------");
        // Выводим первую строку четверостишья
        String single_name = in.nextLine();
        System.out.print(single_name);
        System.out.println("\n---------------- *.next() ----------------");
        // Метод *.next() выводит все данные до первого пробела (у нас одно слово)
        String single_word = in.next();
        System.out.print(single_word);
        System.out.println("\n---------------- *.hasNext() ----------------");
        /*
        Методом *.hasNext() проверяем, есть ли что-нибудь
        на вывод и в цикле выводим остатки четверостишья.
        */
        while (in.hasNext()){
            System.out.println(in.nextLine());
        }
        // Закрываем сканер.
        in.close();
    }
}
