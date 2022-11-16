package Less_38_ch_1_Annotation.PhoneClassesAndAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация данного типа (вида) применяется к классам
@Target(ElementType.TYPE)
/*
Аннотация данного типа (вида) определяет жизненный
цикл аннотации и позволяет использовать рефлексию
и ее методы, т.к. поля будут доступны после запуска
программы, !!! НО !!! два других варианта:
- RetentionPolicy.CLASS
- RetentionPolicy.SOURCE
будут выбрасывать исключения, NullPointerException
при работе с Reflection API, т.к. при обработке их
Java машина уже не увидит.
*/
@Retention(RetentionPolicy.RUNTIME)
public @interface SmartPhone {
    /*
    Применяем дефолтное значения для элементов аннотации,
    они будут применяться, если в случае применения аннотации
    к классу значения элементов явно не определены. См. пример
    с классом Nokia, где аннотация идет без параметров.
    */
    String OS() default "Symbian";
    int yearOfCompanyCreation() default 1865;
    /*
    !!! При создании элементов аннотации мы можем использовать
    примитивные переменные и массивы, однако не можем использовать
    большинство ссылочных типов данных (String и Array исключения) !!!
    */
}
