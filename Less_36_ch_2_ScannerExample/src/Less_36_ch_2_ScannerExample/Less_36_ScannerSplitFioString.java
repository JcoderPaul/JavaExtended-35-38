package Less_36_ch_2_ScannerExample;
/*
Задача получить с клавиатуры строку содержащую
имя отчество фамилию, разделить их и вывести
на экран в формате:
Name: Иван
PatronymicName: Иванович
SurName: Иванов
*/
import java.util.Scanner;

import static java.lang.Character.isWhitespace;

public class Less_36_ScannerSplitFioString {
    public static void main(String[] args) {
        System.out.print("Input you FIO (Name PatronymicName SurName): ");
        // Сканируем данные с клавиатуры и тут же обрезаем крайние пробелы
        String inputFio = new Scanner(System.in).nextLine().trim();
        // Расчет длинны введенной строки
        int countSymb = inputFio.length();
        int countGap = 0;
        /*
        Мы не используем метод *.split() а работаем
        с символами строки. В данном случае мы задаем
        значение искомого символа 'пробела'
        */
        char gap = ' ';

        // Цикл для подсчета пробелов в строке
        for (int i = 0; i < countSymb; i++)
        {
            // Переменной symb присваиваем значение i символа строки
            char symb = inputFio.charAt(i);
            // Если переменная symb пустой символ (пробел, табуляция) то true и счетчик +1
            if (isWhitespace(symb) == true)
            {
                countGap = countGap + 1;
            }
        }
        // Выводим на экран количество пробелов
        System.out.println("Count of gap more then: " + countGap);
        // Если пробелов в строке два, теоретически все верно
        if (countGap == 2)
        {
            // Находим индекс первого символа
            int findGap1 = inputFio.indexOf(gap);
            // Выводим имя начиная с первого символа и до значения первого пробела
            String name = inputFio.substring(0, findGap1);
            System.out.println("Name: " + name.trim());
            // Находим индекс второго пробела, поиск ведется с индекса первого пробела +1
            int findGap2 = inputFio.indexOf(gap, findGap1 + 1);
            // Выводим отчество начиная с первого пробела и до значения индекса второго пробела
            String patronymicName = inputFio.substring(findGap1, findGap2);
            System.out.println("PatronymicName: " + patronymicName.trim());
            // Выводим фамилию начиная со второго пробела и до конца всей строки
            String surName = inputFio.substring(findGap2 + 1);
            System.out.println("SurName: " + surName.trim());
        } else
        {
            // Выводим сообщение если что-то пошло не так
            System.out.println("Enter wrong Data. Please check!");
            System.out.println("You need enter one gap between words!");
        }
    }
}
