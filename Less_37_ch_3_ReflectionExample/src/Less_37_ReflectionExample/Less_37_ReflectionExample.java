package Less_37_ReflectionExample;

import Less_37_ReflectionExample.MyClasses.Calculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Less_37_ReflectionExample {
    public static void main(String[] args) {
        // Путь к текстовому файлу
        String pathToFile = "src\\Less_37_ReflectionExample\\MyFiles\\Data.txt";

        try(BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))) {
            // Считываем построчно данные из файла
            String nameMeth = fileReader.readLine();
            String argumentA = fileReader.readLine();
            String argumentB = fileReader.readLine();
            // Создаем объект калькулятора
            Calculator firstCalculator = new Calculator();
            // Создаем объект класса Class
            Class cl = firstCalculator.getClass();
            Method method_from_data_file = null;
            /*
            Нам нужны только методы класса Calculator, никаких
            методов предков. Получаем все 4-и private метода.
            */
            Method[] calcMethods = cl.getDeclaredMethods();
            // Перебираем названия методов
            for (Method mathMethFromClass: calcMethods) {
                /*
                Проверяем соответствие названия метода из первой
                строки файла данных, и названия методов из массива
                методов, полученных рефлексивным методом
                *.getDeclaredMethods() при совпадении передаем его
                в переменную класса Method.
                */
                if(nameMeth.equals(mathMethFromClass.getName())){
                    method_from_data_file = mathMethFromClass;
                }
            }
            // Применяем магию рефлексии и позволяем изменять приватные данные
            method_from_data_file.setAccessible(true);
            /*
            Запускаем соответствующий, первой строке файла данных,
            метод и передаем в него параметры из второй и третьей
            строки файла.
            */
            method_from_data_file.invoke(firstCalculator,
                                         Integer.parseInt(argumentA),
                                         Integer.parseInt(argumentB));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException |
                 IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}