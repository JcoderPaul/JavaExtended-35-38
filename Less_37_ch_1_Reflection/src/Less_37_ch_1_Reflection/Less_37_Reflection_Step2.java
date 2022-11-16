package Less_37_ch_1_Reflection;
/*
Reflection - ключи от всех дверей.
Получаем информацию о методах класса.
*/
import Less_37_ch_1_Reflection.MyClases.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Less_37_Reflection_Step2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        /*
        Варианты создания объектов класса Class, данный
        метод этого класса выбрасывает исключение (ClassNotFoundException)
        */
        Class employeeClass = Class.forName("Less_37_ch_1_Reflection.MyClases.Employee"); // Вар.1
        Class employeeClassTwo = Employee.class; // Вар.2
        Employee newEmp = new Employee();
        Class employeeClassThree = newEmp.getClass(); // Вар.3
        System.out.println("---------------------- *.increaseSalary() ----------------------");
        /*
        Хотим получить информацию об открытом методе нашего класса
        данный метод тоже выбрасывает исключение (NoSuchMethodException)
        */
        Method someMeth = employeeClass.getMethod("increaseSalary");
        // Извлекаем тип метода и модификатор метода в классе Employee
        System.out.println("Name of method -> " + someMeth.getName());
        System.out.println("ReturnType of method -> " + someMeth.getReturnType());
        /*
        В случае множества входных параметров (у нас 0) в нашем исследуемом
        методе *.increaseSalary(), рефлексивный метод *.getParameterTypes()
        возвращает массив.
        */
        System.out.println("Parameters of method -> " + Arrays.toString(someMeth.getParameterTypes()));
        System.out.println("---------------------- *.setSalary() info ----------------------");
        /*
        Если исследуемый метод имеет ряд перегруженных экземпляров, то мы
        должны в параметрах метода *.getMethod() указывать эти параметры.
        Т.к. название метода *.setSalary() одно и отличие его возможных копий,
        только во входящих аргументах, то мы и должны передать в качестве
        пояснения в рефлексивный метод *.getMethod() эти аргументы.
        */
        Method someMethTwo = employeeClass.getMethod("setSalary", double.class);
        // Извлекаем возвращаемый тип и имя метода в классе Employee
        System.out.println("Name of method -> " + someMethTwo.getName());
        System.out.println("ReturnType of method -> " + someMethTwo.getReturnType());
        /*
        В случае множества входных параметров (у нас 1-н) в нашем исследуемом
        методе *.setSalary(), рефлексивный метод *.getParameterTypes() возвращает
        массив.
        */
        System.out.println("Parameters of method -> " + Arrays.toString(someMethTwo.getParameterTypes()));
        System.out.println("---------------------- All open methods ----------------------");
        /*
        Хотим посмотреть все открытые методы класса Employee,
        в том числе и методы унаследованные от предков (super)
        в данном случае, конечно Object.
        */
        Method[] methodsOfEmployee = employeeClass.getMethods();
        for (Method emp_math_prn : methodsOfEmployee) {
            System.out.println("Method '" + emp_math_prn.getName() +
                               "' have type '" + emp_math_prn.getReturnType() +
                               "' and parameters -> " + Arrays.toString(emp_math_prn.getParameterTypes()));
        }
        System.out.println("---------------------- All methods with private ----------------------");
        /*
        Использование метода *.getDeclaredMethods() позволяет изучить
        структуру методов нашего класса Employee включая и private.
        При этом это будут только методы самого класса без методов
        унаследованных от предков (как в примере выше).
        */
        Method[] allMethodsOfEmployee = employeeClass.getDeclaredMethods();
        for (Method emp_math_prn : allMethodsOfEmployee) {
            System.out.println("Method '" + emp_math_prn.getName() +
                    "' have type '" + emp_math_prn.getReturnType() +
                    "' and modifier '" + emp_math_prn.getModifiers() +
                    "' and parameters -> " + Arrays.toString(emp_math_prn.getParameterTypes()));
        }
        System.out.println("---------------------- All public methods of Employee ----------------------");
        /*
        Использование метода *.getDeclaredMethods() позволяет изучить
        структуру методов нашего класса Employee включая и private.
        При этом это будут только методы самого класса без методов
        унаследованных от предков (как в примере выше).

        Допустим мы хотим отфильтровать и получить методы по модификатору,
        только public, например.
        */
        Method[] allPublicMethodsOfEmployee = employeeClass.getDeclaredMethods();
        for (Method emp_math_prn : allPublicMethodsOfEmployee) {
            /*
            Как я понял *.getModifiers() возвращает некое число (1,2...)
            */
            if(Modifier.isPublic(emp_math_prn.getModifiers())) {
                System.out.println("Method '" + emp_math_prn.getName() +
                        "' have type '" + emp_math_prn.getReturnType() +
                        "' and modifier '" + emp_math_prn.getModifiers() +
                        "' and parameters -> " + Arrays.toString(emp_math_prn.getParameterTypes()));
            }
        }
    }
}
