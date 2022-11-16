package Less_38_ch_1_Annotation.HeroClassesAndAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
Внешняя аннотация определяющая к какому
элементу класса применима наша аннотация.
В данном случае к методам класса.
*/
@Target(ElementType.METHOD)
public @interface MyFirstAnnotation {
}
