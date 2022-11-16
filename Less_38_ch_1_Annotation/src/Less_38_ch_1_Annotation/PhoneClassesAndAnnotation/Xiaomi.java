package Less_38_ch_1_Annotation.PhoneClassesAndAnnotation;

/*
В данном случае параметры аннотации
переназначаются на другие явно,
нежели по умолчанию.
- String OS() = "Android";
- int yearOfCompanyCreation() = 2010;
при выводе на экран в методе MAIN класса
Less_38_Annotation_Step1 именно они попадут
в вывод.
*/
@SmartPhone(OS = "Android", yearOfCompanyCreation = 2010)
public class Xiaomi {
    String model;
    double price;
}
