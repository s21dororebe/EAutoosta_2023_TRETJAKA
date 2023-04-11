package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;
import model.extraClasses.WorkingTime;

import java.util.ArrayList;

/*
* a. Informācijas sistēmas pārbaudei (0 punkti)
* i. Izveidot trīs sarakstus datu saglabāšanai - BusTrip tipa, Employee tipa (kur glabāsies gan autobusa vadītāji, gan
* kasieres) un Station tipa. Ja ir nepieciešams, varat izveidot arī citus sarakstus, bet visu var realizēt tikai ar šiem trim.
* ii. Notestēt jeb izsaukt katru servisu funkciju, lai saprastu, vai izveidotā funkcija strādā korekti.
 * */

public class MainServiceA {
    public static void main(String[] args) {
        try {
            ArrayList<BusTrip> busTripList = new ArrayList<>();
            ArrayList<Employee> employeeList = new ArrayList<>();
            ArrayList<Station> stationList = new ArrayList<>();

            //busTripList creation
            System.out.println("Creating BusTrip list");

            Time timefrom = new Time(12);
            Time timeto = new Time(16);
            Date datefrom = new Date(2025, 2, 12);
            Date dateto = new Date(2025, 2, 12);
            Station stationfrom1 = new Station("Rainbow station", City.Ventspils, 12, 15);
            Station stationto1 = new Station("Cats station", City.Daugavpils, 10, 0, 21, 0);
            Station stationfrom2 = new Station("Dogs station", City.Jelgava, 12, 15);
            Station stationto2 = new Station("Birds station", City.Liepaja, 10, 0, 21, 0);
            BusDriver driver1 = new BusDriver("William", "Didrihson", "123456-36695", 2023, 5, 5, 10);
            BusDriver driver2 = new BusDriver("Julian", "Didrihson", "123456-36695", 2025, 5, 5, 10);
            BusDriver driver3 = new BusDriver("Daniel", "Peterson", "123456-36695", 2025, 5, 5, 10);
            driver2.addCategory(BusCategory.minibus);
            driver1.addCategory(BusCategory.minibus);
            driver1.addCategory(BusCategory.largebus);
            driver3.addCategory(BusCategory.minibus);
            driver3.addCategory(BusCategory.largebus);


            BusTrip bt1 = new BusTrip(timefrom, timeto, 2023, 12, 12, 2023, 12, 12, stationfrom1, stationto1, 20, driver2);
            BusTrip bt2 = new BusTrip(12, 20, 13, 20, datefrom, dateto, stationfrom2, stationto2, 40, driver3);
            BusTrip bt3 = new BusTrip(9, 0, 11, 0, 2023, 4, 20, 2023, 4, 20, stationfrom1, stationto2, 40, driver1);
            BusTrip bt4 = new BusTrip(timefrom, timeto, datefrom, dateto, stationfrom2, stationto1, 50, driver1);

            busTripList.add(bt1);
            busTripList.add(bt2);
            busTripList.add(bt3);
            busTripList.add(bt4);

            for (BusTrip temp : busTripList)
                System.out.println(temp);

            //testing functionality
            System.out.println("--------------------------");
            System.out.println("Adding tickets:");

            Time time = new Time(12, 15);
            Date date = new Date(2023, 5, 15);
            Cashier cashier = new Cashier("Daniel", "Jackson", "20123-65422", 2023, 5, 1);

            Ticket t1 = new Ticket();
            Ticket t2 = new Ticket(time, date, 10.8, 0, VIPticket.isVIP, cashier);
            Ticket t3 = new Ticket(12, 0, 2025, 6, 1, 20, 20, VIPticket.notVIP, cashier);
            Ticket t4 = new Ticket(18, 2023, 8, 30, 100, 90, VIPticket.isVIP, cashier);
            Ticket t5 = new Ticket(12, 2023, 9, 9, 20, 10, VIPticket.notVIP, cashier);
            Ticket t6 = new Ticket(13, 2025, 10, 10, 30, 0, VIPticket.notVIP, cashier);
            Ticket t7 = new Ticket(14, 2024, 11, 11, 40, 0, VIPticket.isVIP, cashier);

            bt1.addTicket(t1);
            bt1.addTicket(t2);
            bt1.addTicket(t3);
            bt1.addTicket(t4);

            bt2.addTicket(t5);
            bt2.addTicket(t6);
            bt2.addTicket(t7);
            bt2.addTicket(t4);

            bt3.addTicket(t6);
            bt3.addTicket(t7);

            bt4.addTicket(t5);
            bt4.addTicket(t4);

            for (BusTrip temp : busTripList)
                temp.printShortInfo();

            System.out.println("--------------------------");
            System.out.println("Changing driver:");

            bt1.printShortInfo();
            bt1.changeBusDriver(driver1);
            bt1.printShortInfo();
            System.out.println("--------------------------");
            bt4.printShortInfo();
            bt4.changeBusDriver(driver3);
            bt4.printShortInfo();

            System.out.println("--------------------------");
            System.out.println("Creating Employee List");

            Person person = new Person("John", "Washington", "123564-25698");
            Employee e1 = new Employee();
            Employee e2 = new Employee("March", "Summer", "123456-78963", 2025, 4, 9);
            Employee e3 = new Employee(person, 2023, 3, 28);

            employeeList.add(e1);
            employeeList.add(e2);
            employeeList.add(e3);

            for (Employee temp : employeeList)
                System.out.println(temp);

            System.out.println("--------------------------");
            System.out.println("Creating Station List");

            WorkingTime wt1 = new WorkingTime(12, 0, 13, 0);
            Station st1 = new Station();
            Station st2 = new Station("Flowers station", City.Jelgava, wt1);
            Station st3 = new Station("Rainbow station", City.Daugavpils, 12, 15);
            Station st4 = new Station("Cats station", City.Ventspils, 10, 0, 21, 0);

            stationList.add(st1);
            stationList.add(st2);
            stationList.add(st3);
            stationList.add(st4);

            for (Station temp : stationList)
                System.out.println(temp);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
