package services;

import model.Employee;
import model.Person;

public class MainServiceEmployee {
    public static void main(String[] args) {
        try {
            Person person = new Person("John", "Washington", "123564-25698");
            Employee e1 = new Employee();
            Employee e2 = new Employee("March", "Summer", "123456-78963", 2023, 4, 9);
            Employee e3 = new Employee(person, 2023, 3, 28);

            System.out.println(e1);
            System.out.println(e2);
            System.out.println(e3);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
