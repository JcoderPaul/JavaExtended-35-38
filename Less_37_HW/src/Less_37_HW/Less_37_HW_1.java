package Less_37_HW;
/*
Шаг.1 Создать класс Car с полями String brand и String model.
Шаг.2 Создать аннотации:
- @Table (принимает название схемы и таблицы в базе данных)
- @Column (принимает название колонки в таблице базы данных).
Шаг.3 Пометить класс аннотацией @Table, а поля аннотацией @Column.
Шаг.4 Написать программу, принимающую объект класс  Car c
проинициализированными полями и составляющую запрос "INSERT" в
виде строки на основании данных объекта.

Пример:
Дан объект Car car = new Car("Toyota", "Corolla");
Программа, принимающая этот объект, должна вывести в консоль строку:
"INSERT INTO garage.car (model, brand) VALUES ('Toyota', 'Corolla');"
*/
import Less_37_HW.MyAnnotations.*;
import Less_37_HW.MyClasses.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Less_37_HW_1 {
    public static void main(String[] args) {
        // Создали экземпляр класса
        System.out.println("--------------------- Наш объект перед добавлением в базу ---------------------");
        Car car = new Car("Toyota", "Corolla", 2003);
        // Вывели на экран
        System.out.println(car);
        System.out.println("--------------------- Промежуточные операции ---------------------");
        System.out.println(generateInsert(car));
    }
    // Метод генерирующий запрос к базе данных
    private static String generateInsert(Car car) {
        // Выходной формат запроса
        String template = "INSERT INTO %s.%s (%s) VALUES (%s);";
        /*
        Сначала методом *.getClass() извлекаем класс объекта
        или получили Class класса прямиком из экземпляра класса.
        Такой не самым оптимальным, т.к. в этом случае среда
        разработки не знает, экземпляр этого класса перед нами
        или его наследник.
        */
        Class<? extends Car> myClass = car.getClass();
        /*
        Далее извлекаем аннотацию из класса объекта класса Car.
        Метод *.getAnnotation() - возвращает аннотацию по типу.
        */
        Table table = myClass.getAnnotation(Table.class);
        /*
        *.getDeclaredFields() - метод возвращает все объявленные
        переменные в классе. Но только данного класса, а не его
        предков супер-классов.
        */
        Field[] fields = myClass.getDeclaredFields();
        // Мы получили массив полей. Превращаем его в стрим.
        String fieldNames = Arrays.stream(fields)
                // Фильтруем поля у которых есть аннотации и пропускаем их дальше
                .filter(field -> field.isAnnotationPresent(Column.class))
                // Наше поле 'yearOfIssue' уже до сюда не дошло, теперь сортируем поля по имени
                .sorted(Comparator.comparing(field1 -> field1.getName()))
                /*
                <R> Stream<R> map(Function<? super T,? extends R> mapper): преобразует элементы
                типа T в элементы типа R и возвращает стрим с элементами R. Промежуточная операция.
                Извлекаем аннотации из полученных полей и пропускаем дальше.
                 */
                .map(field -> field.getAnnotation(Column.class))
                /*
                У каждой аннотации @Column в классе Car есть соответствие name, вот его мы и получаем.
                */
                .map(column -> column.name())
                /*
                Метод collect принимает объект типа Collector, с помощью которого можно производить
                предварительные действия над элементами стрима. Элементы стрима можно объединять.
                Метод *.joining(CharSequence delimiter) соединяет значения стрима в строку с заданным
                разделителем (у нас запятая).
                */
                .collect(Collectors.joining(", "));
                /*
                Предыдущий стрим сформировал строку, которая заполнит первые скобочки в
                "INSERT INTO %s.%s (%s) VALUES (%s);". Для понимания того, что происходи,
                нужно поиграть именами полей в аннотациях класса Car и посмотреть на
                результаты выдачи на экран.
                */
        System.out.println("Результат работы stream, извлекающего 'name' у " +
                           "поля с аннотацией : " + fieldNames);
        /*
        Первые три метода делают все тоже самое, что и в первом стриме,
        извлекаются все поля, остаются только те у которых есть аннотация,
        сортируются по имени.
        */
        String fieldValues = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                // Получили упорядоченный набор полей
                .sorted(Comparator.comparing(Field::getName))
                /*
                В работу идет самописный статический метод извлекающий метод
                класса Car для поля c аннотацией.
                Например: @Column(name = "brand")
                          private String brand;
                Получим на выходе: getBrand
                Более подробно в самом методе, см. ниже *.getMethodName()
                */
                .map(field -> getMethodName(car, field))
                /*
                В данном случае метод *.invoke() извлекает значения
                соответствующих полей из объекта класса Car. Используя
                полученные имена геттеров класса Car. А соответствующие
                геттеры возвращают строковые значения полей model и brand.
                */
                .map(method -> {
                    try {
                        return method.invoke(car);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                // Приводим значения полученных полей в должный вид
                .map(value -> "'" + value + "'")
                // Превращаем поля в строку
                .collect(Collectors.joining(", "));
        System.out.println("--------------------- Запрос к базе данных ---------------------");
        return String.format(template, table.schema(), table.name(), fieldNames, fieldValues);
    }

    public static Method getMethodName(Car car, Field field) {
        /*
        Конечно можно было просто извлечь список методов.
        Но, мы легких путей не ищем. Сохраняем текущее имя поля.
        */
        String name = field.getName();
        try {
            /*
            Простая конкатенация 'get' +
                                 'первый символ в верхнем регистре' +
                                 'остальные символы после первого'
            Например: private String brand;
            На выходе: get + B + rand = getBrand
            */
            String methodName = "get" + name.substring(0, 1).toUpperCase()
                    + name.substring(1);
            System.out.println(methodName);
            return car.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
