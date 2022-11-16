package Less_36_ch_2_ScannerExample.MyClasses;
/*
Все максимально просто, public и static.
Пример показывает, как работает метод Scanner
*/
import java.util.ArrayList;
import java.util.List;

public class ShoppingListCommand {
    static List<String> shopList = new ArrayList<>();
    public static boolean isNumeric(String str)
    {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void addElemList(int position, String addStr)
    {
        if (position <= 0)
        {
            position = 0;
            shopList.add(position, addStr);
        } else
        if (position > shopList.size())
        {
            position = shopList.size();
            shopList.add(position, addStr);
        } else
            shopList.add(position, addStr);
    }

    public static void addElemList(String addStr)
    {
        shopList.add(addStr);
    }

    public static void outputList()
    {
        for(int i = 0; i < shopList.size(); i++)
        {
            System.out.println(i + " - " + shopList.get(i));
        }
    }
    public static void delElemList(int delElem)
    {
        if (delElem > shopList.size())
        {
            System.out.println("Enter wrong index!");
        } else
            shopList.remove(delElem);
    }
    public static void editElemList(int position, String addStr)
    {

        if (position < 0 || position > shopList.size())
        {
            System.out.println("Enter wrong index!");
        } else
            shopList.remove(position);
        shopList.add(position, addStr);
    }
}
