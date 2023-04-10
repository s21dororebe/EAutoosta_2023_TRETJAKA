package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;
import model.extraClasses.WorkingTime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class MainService {
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
            System.out.println("How many places left on the bus trip :");
            System.out.println("BusTrip: time 12:20, date 12/02/2025, Dogs station -> Birds station");
            for(BusTrip temp : busTripList){
                if(temp.getTimeFrom().equals(new Time(12, 20))
                        && temp.getDateFrom().equals(new Date(2025, 2, 12))
                        && temp.getStationFrom().getTitle().equals("Dogs station")
                        && temp.getStationTo().getTitle().equals("Birds station")){
                    int result = temp.getNumberOfSeats() - temp.getAllTickets().size();
                    System.out.println(result);
                }
            }
            System.out.println("--------------------------");
            System.out.println("All of the tickets on the bus trip :");
            System.out.println("BusTrip: time 09:00, date 20/04/2024, Rainbow station -> Birds station");
            for(BusTrip temp : busTripList){
                if(temp.getTimeFrom().equals(new Time(9, 0))
                        && temp.getDateFrom().equals(new Date(2024, 4, 20))
                        && temp.getStationFrom().getTitle().equals("Rainbow station")
                        && temp.getStationTo().getTitle().equals("Birds station")){
                    System.out.println(temp.getNumberOfSeats() - temp.getAllTickets().size());
                    for(Object tempTicket : temp.getAllTickets()){
                        System.out.println(tempTicket);
                    }
                }
            }
            System.out.println("--------------------------");
            System.out.println("All of the tickets today from this station :");
            Station stationHere = new Station("Nice station", City.Ventspils, 6, 23);
            BusTrip busTripToday1 = new BusTrip(9, 30, 12, 30, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationto1, 20, driver1);
            BusTrip busTripToday2 = new BusTrip(12, 30, 15, 30, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationto2, 30, driver2);
            BusTrip busTripToday3 = new BusTrip(18, 30, 22, 30, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationfrom1, 30, driver3);
            busTripList.add(busTripToday1);
            busTripList.add(busTripToday2);
            busTripList.add(busTripToday3);
            for(BusTrip temp : busTripList){
                if(Objects.equals(temp.getDateFrom(), new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()))
                        && temp.getStationFrom().getTitle().equals("Nice station")){
                    System.out.println(temp);
                }
            }
            System.out.println();


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

            //CRUD actions with the Cashier objects
            System.out.println("--------------------------");
            System.out.println("CRUD actions with the Cashier objects");
            System.out.println("Creating:");
            Cashier cashier1 = new Cashier("Augustus", "Hayes", "200591-21456", 2024, 1, 1);
            ArrayList<Cashier> cashierList = new ArrayList<>();
            System.out.println(cashier1);
            cashierList.add(cashier1);
            System.out.println();

            Cashier cashier2 = new Cashier("Aiden", "Blackwell", "123456-12345", 2024, 1, 1);
            Cashier cashier3 = new Cashier("Emeryn", "Marshall", "112233-36936", 2023, 9, 12);
            Cashier cashier4 = new Cashier("Felix", "Patterson", "232323-11223", 2024, 4, 14);
            Cashier cashier5 = new Cashier("Nevaeh", "Chen", "212121-30330", 2024, 5, 15);
            cashierList.add(cashier2);
            cashierList.add(cashier3);
            cashierList.add(cashier4);
            cashierList.add(cashier5);

            System.out.println("Finding cashier by person code:");
            System.out.println("Person code - 212121-30330");
            for(Cashier temp : cashierList){
                if(temp.getPersonCode().equals("212121-30330")){
                    System.out.println("FOUND, this is " + temp);
                }
            }
            System.out.println();

            System.out.println("Editing cashier data by person code:");
            System.out.println("Person code - 232323-11223");
            for(Cashier temp : cashierList){
                if(temp.getPersonCode().equals("232323-11223")){
                    System.out.println("FOUND, this is " + temp + "let's rename this person, now :");
                    temp.setName("Peter");
                    System.out.println(temp);
                }
            }
            System.out.println();

            System.out.println("Deleting cashier by person code:");
            System.out.println("Cashier list before:");
            for(Cashier temp : cashierList)
                System.out.println(temp);
            System.out.println("Person code - 112233-36936");
            for(Cashier temp : cashierList){
                if(temp.getPersonCode().equals("112233-36936")){
                    System.out.println("FOUND, this is " + temp + " ==> let's delete this person");
                    cashierList.remove(temp);
                    temp = null;
                    break;
                }
            }
            System.out.println("Cashier list now:");
            for(Cashier temp : cashierList)
                System.out.println(temp);
            System.out.println();

            System.out.println("--------------------------");
            System.out.println("Actions with BusDriver objects");
            System.out.println("Creating:");
            BusDriver busDriver1 = new BusDriver(e2, 5);
            System.out.println(busDriver1);

            ArrayList<BusDriver> busDriverList = new ArrayList<>();
            BusDriver busDriver2 = new BusDriver(e3, 10);

            BusDriver busDriver3 = new BusDriver("Ethan", "Reynolds", "670312-98123", 2024, 1, 1, 10);
            busDriver3.addCategory(BusCategory.minibus);

            BusDriver busDriver4 = new BusDriver("Ava", "Patel", "920509-65238", 2024, 1, 1, 9);
            busDriver4.addCategory(BusCategory.minibus);
            busDriver4.addCategory(BusCategory.largebus);

            BusDriver busDriver5 = new BusDriver("Isaac", "Ramirez", "820714-32067", 2024, 1, 1, 8);
            busDriver5.addCategory(BusCategory.minibus);
            busDriver5.addCategory(BusCategory.schoolbus);

            BusDriver busDriver6 = new BusDriver("Emily", "Kim", "550223-42108", 2024, 1, 1, 7);
            busDriver6.addCategory(BusCategory.schoolbus);


            busDriverList.add(busDriver1);
            busDriverList.add(busDriver2);
            busDriverList.add(busDriver3);
            busDriverList.add(busDriver4);
            busDriverList.add(busDriver5);
            busDriverList.add(busDriver6);

            System.out.println();

            System.out.println("Finding driver by drive category:");
            System.out.println("Drive category: School bus");
            for(BusDriver temp : busDriverList){
                try {
                    temp.addCategory(BusCategory.schoolbus);
                } catch (Exception e){
                    System.out.println(temp);
                }
            }
            System.out.println();

            System.out.println("Add category to driver by person code:");
            System.out.println("Person code: 550223-42108");
            for(BusDriver temp : busDriverList){
                if(temp.getPersonCode().equals("550223-42108")){
                    System.out.println("FOUND, this is " + temp + " ==> let's add category");
                    temp.addCategory(BusCategory.largebus);
                    System.out.println(temp);
                    break;
                }
            }
            System.out.println();

            System.out.println("All drivers:");
            for(BusDriver temp : busDriverList){
                System.out.println(temp);
            }
            System.out.println();


        } catch (Exception e){
            System.out.println(e);
        }
    }
}
