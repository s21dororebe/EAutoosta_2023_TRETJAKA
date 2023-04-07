package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.extraClasses.Date;
import model.extraClasses.Time;
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

            System.out.println("------------------------------------------------");
            System.out.println("Time:");
            Time time0 = new Time(0, 0);
            Time time1 = new Time(12, 20);
            System.out.println(time0);
            System.out.println(time1);
            System.out.println("------------------------------------------------");

            System.out.println("Date:");
            Date date0 = new Date(0, 0, 0);
            Date date1 = new Date(2012, 11, 20);
            System.out.println(date0);
            System.out.println(date1);
            System.out.println("------------------------------------------------");

            System.out.println("Tickets");
            Ticket t1 = new Ticket();
            Ticket t2 = new Ticket();
            Ticket t3 = new Ticket();
            Ticket t4 = new Ticket();
            Ticket t5 = new Ticket();
            Ticket t6 = new Ticket();
            Ticket t7 = new Ticket();
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
            System.out.println(t4);
            System.out.println(t5);
            System.out.println(t6);
            System.out.println(t7);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
