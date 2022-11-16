package Less_37_ch_1_Reflection;
/*
Reflection - ключи от всех дверей.
Получаем информацию о полях класса.
*/
import Less_37_ch_1_Reflection.MyClases.Employee;

import java.lang.reflect.Field;

public class Less_37_Reflection_Step1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        /*
        Варианты создания объектов класса Class, данный
        метод этого класса выбрасывает исключение (ClassNotFoundException)
        */
        Class employeeClass = Class.forName("Less_37_ch_1_Reflection.MyClases.Employee"); // Вар.1
        Class employeeClassTwo = Employee.class; // Вар.2
        Employee newEmp = new Employee();
        Class employeeClassThree = newEmp.getClass(); // Вар.3
        /*
        Хотим получить информацию о любом поле нашего класса
        данный метод тоже выбрасывает исключение (NoSuchFieldException)
        */
        Field someFild = employeeClass.getField("id");
        /*
        Извлекаем тип поля класса Employee,
        мы помним, что ID у нас int
        */
        System.out.println("Type of ID field -> " + someFild.getType());
        System.out.println("---------------------- Open fields ----------------------");
        // Хотим посмотреть все ОТКРЫТЫЕ поля класса Employee
        Field[] fieldsOfEmployee = employeeClass.getFields();
        for (Field emp_field_prn : fieldsOfEmployee) {
            System.out.println("Type of '" + emp_field_prn.getName() + "' = " + emp_field_prn.getType());
        }
        System.out.println("---------------------- All fields ----------------------");
        // Хотим посмотреть АБСОЛЮТНО все поля класса Employee, даже private
        Field[] allFieldsOfEmployee = employeeClass.getDeclaredFields();
        for (Field emp_field_prn : allFieldsOfEmployee) {
            System.out.println("Type of '" + emp_field_prn.getName() + "' = " + emp_field_prn.getType());
        }
    }
}
