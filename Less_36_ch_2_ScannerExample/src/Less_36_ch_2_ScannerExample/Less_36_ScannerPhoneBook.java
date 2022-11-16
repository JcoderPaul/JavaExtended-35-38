package Less_36_ch_2_ScannerExample;
/*
Задача:
С клавиатуры ввести имя или телефон или команду:
- LIST - вывести на экран телефонный справочник;
- QUIT или EXIT - выйти из программы;
- Если вводится имя, то проверяется есть ли
такое в справочнике Map(k,v), и если его нет,
то предлагается ввести телефон.
- Если вводится телефон, то проверяется, есть
ли такой в справочнике Map(k,v) и если нет,
то предлагается ввести имя.

(Реализовать код без защиты от дурака,
максимально примитивно, только демонстрация
работы класса Scanner и его методов)
*/
import java.util.Scanner;

import static Less_36_ch_2_ScannerExample.MyClasses.PhoneBookMethods.*;

public class Less_36_ScannerPhoneBook {

    public static void main(String[] args) {
        myPhoneBook.put("Rita", "2341342344");
        myPhoneBook.put("Alik", "8435724547");

        Scanner scanData = new Scanner(System.in);

        for (;;)
        {
            System.out.print("Enter data or command: ");
            String enterData = scanData.nextLine();

            if ((enterData.toUpperCase().trim()).equals("LIST"))
            {
                if (myPhoneBook.size() <= 0)
                {
                    System.out.println("Base is empty!");
                } else
                    printMap(myPhoneBook);
            } else if (enterData.trim().matches(regexName) == true) {
                enterNameInBase(enterData, scanData);
            } else if (enterData.trim().matches(regexPhone) == true) {
                enterPhoneInBase(enterData, scanData);
            } else if ((enterData.toUpperCase().trim()).equals("QUIT") ||
                       (enterData.toUpperCase().trim()).equals("EXIT")) {
                System.out.println("End program!");
                break;
            } else
                System.out.println("Unknown command or wrong data!");
        }
        scanData.close();
    }
}
