package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;
import model.extraClasses.WorkingTime;

public class MainService {
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Rebeka", "Tretjaka", "300802-21636");
            Person p2 = new Person();
            Person p3 = new Person("Konstantins", "Tretjaks", "204099-12395");
            Employee e1 = new Employee(p1, 2023, 3, 24);
            Employee e2 = new Employee(p2, 2023, 6, 20);
            Employee e3 = new Employee("Svetlana", "Ko", "124556-26354", 2023, 6, 20);
            BusDriver bd1 = new BusDriver(p1, 2023, 3, 24, 0);
            BusDriver bd2 = new BusDriver(e2, 5);
            BusDriver bd3 = new BusDriver(p3, 2023, 9, 28, 10);
            Cashier cashier1 = new Cashier(p1, 2023, 12, 1);
            Cashier cashier2 = new Cashier(e1);
            Cashier cashier3 = new Cashier(e3);

            System.out.println("Cashiers:");
            System.out.println(cashier1);
            System.out.println(cashier2);
            System.out.println("------------------------------------------------");

            System.out.println(p1);
            System.out.println(e1);
            System.out.println(p2);
            System.out.println(e2);
            System.out.println("Bus Drivers: ");
            System.out.println(bd1);
            bd1.addCategory(BusCategory.minibus);
            bd2.addCategory(BusCategory.minibus);
            bd2.addCategory(BusCategory.schoolbus);
            System.out.println(bd2);
            bd2.removeCategory(BusCategory.schoolbus);
            System.out.println(bd2);
            bd3.addCategory(BusCategory.largebus);
            bd3.addCategory(BusCategory.minibus);
            bd3.addCategory(BusCategory.schoolbus);

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
            Ticket t2 = new Ticket(12, 2023, 20, 12, 25, 0, VIPticket.notVIP, cashier1);
            Ticket t6 = new Ticket(12, 33, 2023, 7, 20, 60, 50, VIPticket.isVIP, cashier1);
            Ticket t7 = new Ticket(time1, date1, 20, 0, VIPticket.isVIP, cashier3);
            System.out.println(t6);
            System.out.println(t7);
            System.out.println(t1);
            System.out.println(t2);
            System.out.println("------------------------------------------------");

            System.out.println("BusTrip");
            Time timefrom1 = new Time(12, 20);
            Time timeto1 = new Time(16);
            Time timefrom2 = new Time(13);
            Time timeto2 = new Time(18, 30);

            Date datefrom1 = new Date(2023, 6, 12);
            Date dateto1 = new Date(2022, 5, 15);
            Date datefrom2 = new Date(2023, 7, 7);
            Date dateto2 = new Date(2018, 9, 23);

            BusTrip bt1 = new BusTrip(timefrom1, timeto1, 2023, 6, 25, 2023, 6, 26, st2, st3, 20, bd1);
            BusTrip bt2 = new BusTrip(12, 20, 12, 40, datefrom1, dateto1, st2, st3, 50, bd3);
            BusTrip bt3 = new BusTrip(11, 0, 12, 50, 2023, 7, 25, 2023, 7, 26, st3, st2, 60, bd1);
            BusTrip bt4 = new BusTrip(timefrom2, timeto2, datefrom2, dateto2,  st2, st3, 10, bd2);

            System.out.println(bt1);
            System.out.println(bt2);
            System.out.println(bt3);
            System.out.println(bt4);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
