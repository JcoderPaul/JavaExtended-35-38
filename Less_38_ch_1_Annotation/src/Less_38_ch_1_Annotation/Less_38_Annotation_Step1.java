package Less_38_ch_1_Annotation;

import Less_38_ch_1_Annotation.PhoneClassesAndAnnotation.SmartPhone;

import java.lang.annotation.Annotation;

public class Less_38_Annotation_Step1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("Less_38_ch_1_Annotation.PhoneClassesAndAnnotation.Xiaomi");
        Annotation xiaomiAnnotation = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone smForXiaomi = (SmartPhone) xiaomiAnnotation;
        System.out.println("Аннотации для '" + xiaomiClass.getName() +
                           "' OS -> '" + smForXiaomi.OS() +
                           "', год создания компании -> " + smForXiaomi.yearOfCompanyCreation());

        Class iphoneClass = Class.forName("Less_38_ch_1_Annotation.PhoneClassesAndAnnotation.Iphone");
        Annotation iphoneAnnotation = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone smForIphone = (SmartPhone) iphoneAnnotation;
        System.out.println("Аннотации для '" + iphoneClass.getName() +
                           "' OS -> '" + smForIphone.OS() +
                           "', год создания компании -> " + smForIphone.yearOfCompanyCreation());

        Class nokiaClass = Class.forName("Less_38_ch_1_Annotation.PhoneClassesAndAnnotation.Nokia");
        Annotation nokiaAnnotation = nokiaClass.getAnnotation(SmartPhone.class);
        SmartPhone smForNokia = (SmartPhone) nokiaAnnotation;
        System.out.println("Аннотации для '" + nokiaClass.getName() +
                           "' OS -> '" + smForNokia.OS() +
                           "', год создания компании -> " + smForNokia.yearOfCompanyCreation());
    }
}
