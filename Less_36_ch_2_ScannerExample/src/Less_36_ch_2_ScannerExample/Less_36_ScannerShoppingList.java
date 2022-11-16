package Less_36_ch_2_ScannerExample;
/*
Пример примитивного списка продуктов.
Программа реализует следующие команды:
- ADD (index, product) - добавить продукт на нужную позицию;
- ADD (product) - просто добавить продукт в конец списка;
- EDIT (index, product) - редактировать название продукта
                          по индексу в списке;
- DELETE (index) - удалить продукт по индексу;
- LIST - вывести полный список продуктов;
- EXIT - выйти из программы.
*/
import java.util.Scanner;

import static Less_36_ch_2_ScannerExample.MyClasses.ShoppingListCommand.*;
import static java.lang.Character.isWhitespace;

public class Less_36_ScannerShoppingList {
    public static void main(String[] args) {
        {   Scanner sc = new Scanner(System.in);
            System.out.println("Enter data format: \n" +
                "- Command + parameter + 'product' \n" +
                "(for example: ADD milk, EDIT 1 potato, DELETE 3, ADD 2 bread)\n" +
                "- Command only (LIST, EXIT)\n" +
                "-------------------------------------------------------------------");
            for(;;)
            {
                System.out.print("Input you command: ");
                // Сканируем данные с клавиатуры и тут же обрезаем крайние пробелы
                String inputCommand = sc.nextLine().trim();
                // Расчет длинны введенной строки
                String commandName = "";
                String commandStr = "";
                String commandParam = "";
                int commandNumPar = 0;
                int countGap = 0;
                char gap = ' ';
                int countSymb = inputCommand.length();
                String enterComand = inputCommand;

                for (int i = 0; i < countSymb; i++) {
                    // Переменной symb присваиваем значение i символа строки
                    char symb = enterComand.charAt(i);
                    // Если переменная symb пустой символ (пробел, табуляция) то true и счетчик +1
                    if (isWhitespace(symb) == true) {
                        countGap = countGap + 1;
                    }
                }
                // Если в строке только один пробел, то это команда + index
                if (countGap == 1) {
                    int findGap1 = enterComand.indexOf(gap);
                    /*
                    Находим индекс первого пробела. Выводим команду
                    (текст команды) начиная с первого символа индекс '0'
                    и до значения первого пробела
                    */
                    commandName = (enterComand.substring(0, findGap1)).toUpperCase();
                    System.out.println("Command: " + commandName.trim());
                    /*
                    Выводим команду (текст команды) начиная
                    с первого пробела и до конца строки
                    */
                    commandParam = enterComand.substring(findGap1);
                    System.out.println("Command parameter: " + commandParam.trim());

                    //Проверяем содержит ли строка параметр index для работы со списком
                    if (isNumeric(commandParam.trim()) == true) {
                        commandNumPar = Integer.parseInt(commandParam.trim());
                    } else
                        System.out.println("Parameter in not number!");
                        commandStr = commandParam.trim();
                } else
                // Если в строке два пробела, то это команды + index + название продукта
                if (countGap >= 2) {
                    // Находим индекс первого пробела
                    int findGap1 = enterComand.indexOf(gap);
                    /*
                    Выводим команду (текст команды) начиная
                    с первого символа и до значения первого пробела
                    */
                    commandName = (enterComand.substring(0, findGap1)).toUpperCase();
                    System.out.println("Command: " + commandName.trim());

                    /*
                    Находим индекс второго пробела, поиск
                    ведется с индекса первого пробела +1
                    */
                    int findGap2 = enterComand.indexOf(gap, findGap1 + 1);
                    /*
                    Выводим 'index' - позицию товара в списке начиная
                    с первого пробела и до значения индекса второго пробела
                    */
                    commandParam = enterComand.substring(findGap1, findGap2);
                    System.out.println("Command parameter: " + commandParam.trim());
                    if (isNumeric(commandParam.trim()) == true) {
                        commandNumPar = Integer.parseInt(commandParam.trim());
                    } else
                        System.out.println("Parameter in not number!");
                    /*
                    Выводим продукт (название продукта) начиная
                    со второго пробела и до конца всей строки.
                    */
                    commandStr = enterComand.substring(findGap2 + 1);
                    System.out.println("Command string: " + commandStr.trim());
                } else
                    /*
                    Если в строке нет ни одного пробела, то это
                    скорее всего команда, без параметров и названия
                    продукта. Т.е. EXIT или LIST иначе ошибка ввода.
                    */
                    commandName = inputCommand.toUpperCase();
                /*
                Проверка введенных команд и запуск соответствующих
                методов из класса ShoppingListCommand.
                */
                if (commandName.equals("DELETE") && isNumeric(commandParam.trim()) == true) {
                    delElemList(commandNumPar);
                } else if (commandName.equals("ADD")) {
                    if (isNumeric(commandParam.trim()) == true) {
                        addElemList(commandNumPar, commandStr);
                    } else
                        addElemList(commandStr);
                } else if (commandName.equals("EDIT") && isNumeric(commandParam.trim()) == true) {
                    editElemList(commandNumPar, commandStr);
                } else if (commandName.equals("LIST")) {
                    outputList();
                } else if (commandName.equals("EXIT")) {
                    break;
                } else
                    System.out.println("Unknown command!");

                System.out.println("**************** LIST of PRODUCT ****************");
                outputList();
            }
            // Закрываем поток сканера
            sc.close();
            System.out.println("END PROGRAM");
        }
    }
}
