package Less_36_ch_1_Scanner;
/*
Простой пример работы класса Scanner и его методов:
*.nextInt();
*.close();
*.nextLine();
*.nextFloat();
*/
import java.util.Scanner;

public class Less_36_Scanner_Step2 {
    public static void main(String[] args) {
        /*
        Создали сканер. С помощью Scanner in мы указали,
        что переменная будет иметь имя in и будет
        относиться к классу Scanner. Далее именно к этой
        переменной будут применять необходимые методы.
         */
        Scanner in = new Scanner(System.in);
        System.out.print("Input name: ");
        /*
        Метод сканера nextLine() отвечает за то, чтобы считать
        введенный пользователем текст с консоли. С помощью
        *.nextLine () мы считываем введенный в консоли текст,
        как метод *.nextInt() отвечает за чтение с консоли
        целочисленных значений, а метод *.nextFloat() позволяет
        считывать дробные значение. Далее полученные данные
        присваиваются соответствующим переменным.
        */
        String name = in.nextLine();
        System.out.print("Input age: ");
        int age = in.nextInt();
        System.out.print("Input height: ");
        float height = in.nextFloat();
        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
        // Закрываем сканер.
        in.close();
    }
}
