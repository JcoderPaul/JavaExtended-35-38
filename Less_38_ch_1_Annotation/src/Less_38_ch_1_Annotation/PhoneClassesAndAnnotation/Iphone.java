package Less_38_ch_1_Annotation.PhoneClassesAndAnnotation;

/*
В данном случае параметры аннотации
переназначаются на другие явно,
нежели по умолчанию.
- String OS() = "IOS";
- int yearOfCompanyCreation() = 1976;
при выводе на экран в методе MAIN класса
Less_38_Annotation_Step1 именно они попадут
в вывод.
*/
@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
public class Iphone {
    String model;
    double price;
}
