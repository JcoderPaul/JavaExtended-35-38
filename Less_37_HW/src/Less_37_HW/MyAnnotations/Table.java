package Less_37_HW.MyAnnotations;
/*
Шаг.2 Создать аннотацию:
- @Table (принимает название схемы и таблицы в базе данных)
*/
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
Внешняя аннотация определяющая к какому
элементу класса применима наша аннотация.
Аннотация данного типа (вида) применяется
к классам.
*/
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
public @interface Table {
   /*
   Применяем дефолтное значения для элемента аннотации schema(),
   оно будет подставлено, если в случае применения аннотации
   к классу значение этого элемента явно не определены.

   Пример с классом Nokia, где аннотация идет без параметров:
   (см. /Less_38_ch_1_Annotation/PhoneClassesAndAnnotation).
   */
    String schema() default "public";
    String name();
}
