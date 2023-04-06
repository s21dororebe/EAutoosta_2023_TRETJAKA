package services;

import model.Station;
import model.enumerators.BusCategory;
import model.BusDriver;
import model.Employee;
import model.Person;
import model.enumerators.City;
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

            WorkingTime wt1 = new WorkingTime(0, 0, 23, 59);
            System.out.println("WorkingTime: " + wt1);

            System.out.println("Stations:");
            for(int i = 0; i < 10; i++)
                new Station();
            Station st2 = new Station("First station", City.Ventspils, wt1);
            Station st3 = new Station("Second station", City.Daugavpils, 6, 20);
            Station st4 = new Station("Third station", City.Jelgava, 5, 0, 23, 59);
            System.out.println(st2);
            System.out.println(st3);
            System.out.println(st4);


        } catch (Exception e){
            System.out.println(e);
        }
    }
}
