package Less_37_ch_2_Reflection.MyClasses;
/*
В данном классе поле salary private и
!!! Нет ни конструктора ни метода,
позволяющего изменить данный параметр !!!
Однако ... см.
*/
public class Worker {

    public int id;
    public String name;
    public String department;
    private double salary = 2500.99;

    public Worker() {
    }

    public Worker(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    private void changeDepartment(String newDepartment){
        department = newDepartment;
        System.out.println("New department is: " + department);
    }

    public void increaseSalary(){
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
