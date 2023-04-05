package services;

import model.enumerators.BusCategory;
import model.BusDriver;
import model.Employee;
import model.Person;
import model.extraClasses.WorkingTime;

public class MainService {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Rebeka", "Tretjaka", "300802-21636");
            Person p2 = new Person();
            Employee e1 = new Employee(p1, 2023, 3, 24);
            Employee e2 = new Employee(p2, 2023, 6, 20);
            BusDriver bd1 = new BusDriver(p1, 2023, 3, 24, 0);
            BusDriver bd2 = new BusDriver(e2, 5);

            System.out.println(p1);
            System.out.println(e1);
            System.out.println(p2);
            System.out.println(e2);
            System.out.println("Bus Drivers: ");
            System.out.println(bd1);
            bd2.addCategory(BusCategory.minibus);
            bd2.addCategory(BusCategory.schoolbus);
            System.out.println(bd2);
            bd2.removeCategory(BusCategory.schoolbus);
            System.out.println(bd2);

            WorkingTime wt1 = new WorkingTime(2, 15, 16, 5);
            System.out.println("WorkingTime: " + wt1);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
