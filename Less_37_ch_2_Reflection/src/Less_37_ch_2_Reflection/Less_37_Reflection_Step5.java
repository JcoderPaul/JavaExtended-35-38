package Less_37_ch_2_Reflection;
/*
Создание МЕТОДОВ и экземпляров объекта при помощи Reflection
*/
import Less_37_ch_2_Reflection.MyClasses.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Less_37_Reflection_Step5 {
    public static void main(String[] args) throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  NoSuchMethodException,
                                                  InvocationTargetException {
        // Создали объект класса Class
        Class empClass = Class.forName("Less_37_ch_2_Reflection.MyClasses.Employee");

        System.out.println("\n---------------- *.newInstance() with parameters ----------------");
        Constructor empFour = empClass.getConstructor(int.class, String.class, String.class);
        Object objEmpFour = empFour.newInstance(23, "Василий", "Seller");
        System.out.println(objEmpFour);

        // Создаем рефлексивный метод и используем его для доступа к полю класса.
        System.out.println("\n---------------- *.getMethod() and *.invoke() ----------------");
        Method setSalaryMethod = empClass.getMethod("setSalary", double.class);
        setSalaryMethod.invoke(objEmpFour, 777.77);
        System.out.println(objEmpFour);





    }
}
