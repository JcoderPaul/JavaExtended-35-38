package Less_36_ch_1_Scanner;
/*
Простой пример работы класса Scanner и его методов:
*.nextInt();
*.close();
*/
import java.util.Scanner;

public class Less_36_Scanner_Step1 {
    public static void main(String[] args) {
        /*
        Создаем объект сканер, и передаем в него
        возможность считывать информацию с консоли.
        */
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");
        // Читаем целочисленное значение
        int num = sc.nextInt();
        // Выводим на экран, то что ввели с клавиатуры
        System.out.printf("Your number: %d \n", num);
        // Закрыли сканирующий поток
        sc.close();
    }
}
