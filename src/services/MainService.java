package services;

import model.Date;
import model.Employee;
import model.Person;

public class MainService {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Rebeka", "Tretjaka", "300802-21636");
            Person p2 = new Person();
            Employee e1 = new Employee(p1, 2023, 3, 24);
            Employee e2 = new Employee(p2, 2023, 6, 20);

            System.out.println(p1);
            System.out.println(e1);
            System.out.println(p2);
            System.out.println(e2);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
