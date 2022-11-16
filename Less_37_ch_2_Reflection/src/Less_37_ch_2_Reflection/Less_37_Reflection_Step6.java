package Less_37_ch_2_Reflection;
/*
Изменение приватных полей без явного
доступа к ним при помощи Reflection
*/

import Less_37_ch_2_Reflection.MyClasses.Worker;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Less_37_Reflection_Step6 {
    public static void main(String[] args) throws NoSuchFieldException,
                                                  IllegalAccessException {
        // Классический объект класса
        Worker workerFirst = new Worker(43, "Анна", "marketing");
        /*
        Запускаем черную магию Reflection.
        Получаем доступ к классу Worker
         */
        Class workerClass = workerFirst.getClass();
        // Запрашиваем private поле salary
        Field workerField = workerClass.getDeclaredField("salary");
        // Активируем заклинание *.setAccessible(true) с параметром true
        workerField.setAccessible(true);
        // Указываем на каком объекте меняем хотим посмотреть поле salary
        double salaryValue = (Double) workerField.get(workerFirst);
        System.out.println(salaryValue);
        System.out.println("\n------------- *.set(Object for change, new data) -------------");
        // Указываем на каком объекте меняем содержимое поля salary и на какое значение
        workerField.set(workerFirst, 9999.99);
        System.out.println(workerFirst);
    }
}
