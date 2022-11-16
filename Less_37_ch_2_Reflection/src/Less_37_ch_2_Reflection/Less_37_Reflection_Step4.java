package Less_37_ch_2_Reflection;
/*
Создание экземпляра объекта при помощи Reflection
*/
import Less_37_ch_2_Reflection.MyClasses.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Less_37_Reflection_Step4 {
    public static void main(String[] args) throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  NoSuchMethodException,
                                                  InvocationTargetException {
        // Создали объект класса Class
        Class empClass = Class.forName("Less_37_ch_2_Reflection.MyClasses.Employee");
        System.out.println("\n---------------- *.newInstance() - deprecated ----------------");
        /*
        Вариант 1. Создадим объект Employee при помощи
        рефлексивного объекта empClass устаревшим методом
        *.newInstance() - deprecated.
        */
        Employee empOne = (Employee) empClass.newInstance();
        System.out.println(empOne);

        System.out.println("\n---------------- *.newInstance() of Object ----------------");
        /*
        Вариант 2. Создадим объект Object при помощи
        рефлексивного объекта Constructor методом
        *.newInstance(), в данном примере без кастомизации.
        */
        Constructor empTwo = empClass.getConstructor();
        Object objEmpTwo = empTwo.newInstance();
        System.out.println(objEmpTwo);

        System.out.println("\n---------------- *.newInstance() of Constructor<Employee> ----------------");
        /*
        Вариант 3. Создадим объект Employee при помощи
        рефлексивного объекта Constructor<T> методом
        *.newInstance()
        */
        Constructor<Employee> empThree = empClass.getConstructor();
        Employee EmpThree = empThree.newInstance();
        System.out.println(EmpThree);

        System.out.println("\n---------------- *.newInstance() with parameters ----------------");
        Constructor empFour = empClass.getConstructor(int.class, String.class, String.class);
        Object objEmpFour = empFour.newInstance(23, "Василий", "Seller");
        System.out.println(objEmpFour);





    }
}
