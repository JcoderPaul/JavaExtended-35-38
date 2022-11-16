package Less_37_ch_1_Reflection;
/*
Reflection - ключи от всех дверей.
Получаем информацию о конструкторах класса.
*/
import Less_37_ch_1_Reflection.MyClases.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Less_37_Reflection_Step3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        /*
        Варианты создания объектов класса Class, данный
        метод этого класса выбрасывает исключение (ClassNotFoundException)
        */
        Class employeeClass = Class.forName("Less_37_ch_1_Reflection.MyClases.Employee"); // Вар.1
        Class employeeClassTwo = Employee.class; // Вар.2
        Employee newEmp = new Employee();
        Class employeeClassThree = newEmp.getClass(); // Вар.3

        System.out.println("---------------------- Constructor without parameters ----------------------");
        /*
        Хотим получить информацию о конструкторах класса, в данном случае
        мы применяем метод без параметров, а значит можем извлечь данные о
        конструкторе без параметров.
        */
        Constructor empConstructor = employeeClass.getConstructor();
        System.out.println("Has parameters -> " + empConstructor.getParameterCount());
        System.out.println("Parameters types -> " + Arrays.toString(empConstructor.getParameterTypes()));

        System.out.println("---------------------- Constructor with parameters ----------------------");
        Constructor empConstructorWithParam = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("Has parameters -> " + empConstructorWithParam.getParameterCount());
        System.out.println("Parameters types -> " + Arrays.toString(empConstructorWithParam.getParameterTypes()));

        System.out.println("---------------------- Info about all constructor ----------------------");
        Constructor[] constructorsOfEmployee = employeeClass.getConstructors();
        for (Constructor emp_cons_prn : constructorsOfEmployee) {
            System.out.println("Constructor '" + emp_cons_prn.getName() +
                               "' has '" + emp_cons_prn.getParameterCount() +
                               "' parameters with types -> " + Arrays.toString(emp_cons_prn.getParameterTypes()));
        }

        System.out.println("---------------------- Info about all constructor ----------------------");
        // Применяем другой метод получения информации.
        Constructor[] allConstructorsOfEmployee = employeeClass.getDeclaredConstructors();
        for (Constructor emp_cons_prn : allConstructorsOfEmployee) {
            System.out.println("Constructor '" + emp_cons_prn.getName() +
                    "' has '" + emp_cons_prn.getParameterCount() +
                    "' parameters with types -> " + Arrays.toString(emp_cons_prn.getParameterTypes()));
        }
    }
}
