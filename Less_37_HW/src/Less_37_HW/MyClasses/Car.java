package Less_37_HW.MyClasses;
/*
Шаг.1 Создали класс Car с полями String brand и String model
*/
import Less_37_HW.MyAnnotations.Column;
import Less_37_HW.MyAnnotations.Table;
/*
Шаг.3 Пометить класс аннотацией @Table
Поскольку задача симулирует запрос в
базу данных, то в данном конкретном
примере это можно перевести, как
"Таблица с именем car".
*/
@Table(name = "car")
public class Car {
    /*
    Шаг.3 Пометить поля аннотацией @Column
    В данном конкретном примере это можно
    перевести, как "колонка с именем brand"
    ниже "колонка с именем model".
    */
    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;
    /*
    Данного поля в задании нет, однако мы
    его создали и не пометили аннотацией,
    что бы увидеть как работает стрим
    отбирающий поля с аннотациями.
    */
    private int yearOfIssue;

    public Car(String brand, String model, int yearOfIssue) {
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public String toString() {
        return "Car: {" +
                "brand= '" + brand + '\'' +
                ", model= '" + model + '\'' +
                ", yearOfIssue= " + yearOfIssue +
                '}';
    }
}
