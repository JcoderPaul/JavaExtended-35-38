package Less_36_ch_2_ScannerExample.MyClasses;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBookMethods {

    public static Map<String, String> myPhoneBook = new TreeMap<>();
    public static String regexName = "([A-ZА-Я])([a-zа-я]+)";
    public static String regexPhone = "([0-9]+)";

    public static void printMap(Map<String, String> map)
    {
        for(String keyBase : map.keySet())
        {
            System.out.println("Subscriber name: " + keyBase +
                               " - Phone number: " + myPhoneBook.get(keyBase));
        }
    }

    public static void enterPhoneInBase(String enterData, Scanner scanData)
    {
        String keyOne ="";

        if (enterData.trim().matches(regexPhone) == true)
        {
            if (myPhoneBook.containsValue(enterData) == true) {
                for (String k : myPhoneBook.keySet()) {
                    if (myPhoneBook.get(k).equals(enterData)) {
                        keyOne = k;
                        break;
                    }
                }
                System.out.println("There is already a subscriber with the same phone in the database");
                System.out.println("Subscriber name: " + keyOne +
                                   " - Phone number: " + myPhoneBook.get(keyOne));
            } else {
                System.out.print("Enter subscriber name: ");
                String namePhBook = scanData.nextLine();
                myPhoneBook.put(namePhBook, enterData);
            }
        } else
            System.out.println("It is not phone number!\n Repeat enter data!");
    }
    public static void enterNameInBase(String enterData, Scanner scanData)
    {
        String keyOne = "";
        String phoneKey = "";

        if (enterData.trim().matches(regexName) == true)
        {
            if (myPhoneBook.containsKey(enterData) == true)
            {
                System.out.println("There is already a subscriber with such a name in the database");
                System.out.println("Subscriber name: " + enterData +
                                   " - Phone number: " + myPhoneBook.get(enterData));
            } else {
                System.out.print("Enter phone number: ");
                String numPhBook = scanData.nextLine();

                if (numPhBook.trim().matches(regexPhone) == true) {
                    myPhoneBook.put(enterData, numPhBook);
                }
            }
        } else
            System.out.println("It is not name!\n Repeat enter data!");
    }
}