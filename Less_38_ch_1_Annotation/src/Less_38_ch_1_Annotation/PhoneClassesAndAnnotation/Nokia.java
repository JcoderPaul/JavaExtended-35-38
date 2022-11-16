package Less_38_ch_1_Annotation.PhoneClassesAndAnnotation;

/*
В данном случае аннотация будет применена
с параметрами по умолчанию, в нашем случае
это:
- String OS() default "Symbian";
- int yearOfCompanyCreation() default 1865;
при выводе на экран в методе MAIN класса
Less_38_Annotation_Step1 именно они попадут
в вывод.
*/
@SmartPhone
public class Nokia {
    String model;
    double price;
}
