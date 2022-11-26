package Less_37_HW.MyAnnotations;
/*
Шаг.2 Создать аннотацию:
- @Column (принимает название колонки в таблице базы данных)
*/
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
Внешняя аннотация определяющая к какому
элементу класса применима наша аннотация.
В данном случае к полям класса.
*/
@Target(ElementType.FIELD)
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
public @interface Column {
    String name();
}