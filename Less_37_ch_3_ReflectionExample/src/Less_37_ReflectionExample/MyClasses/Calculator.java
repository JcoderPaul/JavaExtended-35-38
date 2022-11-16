package Less_37_ReflectionExample.MyClasses;

public class Calculator {

    private void sum(int a, int b){
        int result = a + b;
        System.out.println("Сумма '" + a + "' и '" + b + "' = " + result);
    }

    private void subtraction(int a, int b){
        int result = a - b;
        System.out.println("Разность '" + a + "' и '" + b + "' = " + result);
    }

    private void multiplication(int a, int b){
        int result = a * b;
        System.out.println("Произведение '" + a + "' и '" + b + "' = " + result);
    }

    private void division(int a, int b){
        int result = a / b;
        System.out.println("Целое от деления '" + a + "' и '" + b + "' = " + result);
    }
}
