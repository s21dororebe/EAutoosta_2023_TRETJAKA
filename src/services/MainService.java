package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;
import model.extraClasses.WorkingTime;

import java.util.ArrayList;
import java.util.Objects;

public class MainService {

    public static ArrayList<BusTrip> busTripArrayList = new ArrayList<>();
    public static ArrayList<Employee> employeeArrayList = new ArrayList<>();
    public static ArrayList<Station> stationArrayList = new ArrayList<>();
    public static void main(String[] args) {
        try {
            Person pe1 = new Person("James", "Jordan", "120599-65896");
            Employee e1 = new Employee(pe1, 2023, 5, 1);
            Employee e2 = new Employee("Elena", "Grey", "180974-45236", 2023, 6, 1);
            Employee e3 = new Employee("Michael", "Philips", "181296-23641", 2023, 7, 1);
            Employee e4 = new Employee("Irene", "Black", "050598-78523", 2023, 9, 1);
            Employee e5 = new Employee("Mary", "Philips", "160288-36412", 2023, 9, 1);
            Employee e6 = new Employee("Augustus", "Hayes", "200591-21456", 2023, 9, 1);
            employeeArrayList.add(e1);
            employeeArrayList.add(e2);
            employeeArrayList.add(e3);
            employeeArrayList.add(e4);
            employeeArrayList.add(e5);
            employeeArrayList.add(e6);

            WorkingTime wtSt1 = new WorkingTime(6, 0, 23, 30);
            Station st1 = new Station("Flowers station", City.Ventspils, wtSt1);
            Station st2 = new Station("Fabulous station", City.Ventspils, 6, 23);
            Station st3 = new Station("Funny station", City.Ventspils, 5, 30, 23, 30);
            Station st4 = new Station("Dogs station", City.Daugavpils, 5, 30, 23, 30);
            Station st5 = new Station("Cats station", City.Jelgava, 5, 30, 23, 30);
            Station st6 = new Station("Music station", City.Liepaja, 5, 30, 23, 30);
            stationArrayList.add(st1);
            stationArrayList.add(st2);
            stationArrayList.add(st3);
            stationArrayList.add(st4);
            stationArrayList.add(st5);
            stationArrayList.add(st6);

            BusDriver bd1 = new BusDriver(e1, 5);
            BusDriver bd2 = new BusDriver(e2, 5);
            BusDriver bd3 = new BusDriver(e3, 5);
            bd1.addCategory(BusCategory.minibus);
            bd1.addCategory(BusCategory.largebus);
            bd2.addCategory(BusCategory.schoolbus);
            bd2.addCategory(BusCategory.minibus);
            bd3.addCategory(BusCategory.minibus);

            Time timeFrombt1 = new Time(17);
            Time timeTobt1 = new Time(18);
            Time timeFrombt2 = new Time(17, 30);
            Time timeTobt2 = new Time(18, 30);
            Date dateFrombt1 = new Date(2023, 5, 23);
            Date dateTobt1 = new Date(2023, 5, 23);
            Date dateFrombt2 = new Date(2023, 12, 22);
            Date dateTobt2 = new Date(2023, 12, 22);
            BusTrip bt1 = new BusTrip(timeFrombt1, timeTobt1, dateFrombt1, dateTobt1, st1, st4, 40, bd1);
            BusTrip bt2 = new BusTrip(timeFrombt2, timeTobt2, dateFrombt2, dateTobt2, st3, st4, 20, bd2);
            BusTrip bt3 = new BusTrip(18, 0, 19, 0, 2023, 4, 14, 2023, 4, 14, st5, st6, 20, bd3);
            BusTrip bt4 = new BusTrip(18, 30, 19, 30, 2023, 8, 14, 2023, 8, 14, st1, st5, 40, bd1);
            BusTrip bt5 = new BusTrip(11, 0, 13, 0, 2023, 4, 20, 2023, 4, 20, st2, st4, 20, bd2);
            BusTrip bt6 = new BusTrip(12, 0, 14, 0, 2023, 7, 1, 2023, 7, 1, st1, st6, 20, bd3);
            busTripArrayList.add(bt1);
            busTripArrayList.add(bt2);
            busTripArrayList.add(bt3);
            busTripArrayList.add(bt4);
            busTripArrayList.add(bt5);
            busTripArrayList.add(bt6);

            System.out.println("Employees:");
            for(Employee temp : employeeArrayList)
                System.out.println(temp);
            System.out.println("------------------------------");
            System.out.println("Stations:");
            for(Station temp : stationArrayList)
                System.out.println(temp);
            System.out.println("------------------------------");
            System.out.println("Bus trips:");
            for(BusTrip temp : busTripArrayList)
                System.out.println(temp);

            System.out.println("------------------------------");
            System.out.println("Adding tickets to Bus trip 1:");

            Ticket t1 = new Ticket(18, 30, 2023, 4, 15, 25, 0, VIPticket.isVIP, new Cashier("Irene", "Black", "050598-78523", 2023, 9, 1));
            Ticket t2 = new Ticket(17, 20, 2023, 4, 16, 12, 10, VIPticket.notVIP, new Cashier("Mary", "Philips", "160288-36412", 2023, 9, 1));
            Ticket t3 = new Ticket(15, 30, 2023, 4, 17, 15, 15, VIPticket.notVIP, new Cashier("Mary", "Philips", "160288-36412", 2023, 9, 1));
            Ticket t4 = new Ticket(14, 45, 2023, 4, 18, 20, 0, VIPticket.isVIP, new Cashier("Mary", "Philips", "160288-36412", 2023, 9, 1));
            Ticket t5 = new Ticket(12, 30, 2023, 4, 19, 21, 20, VIPticket.isVIP, new Cashier("Irene", "Black", "050598-78523", 2023, 9, 1));
            Ticket t6 = new Ticket(11, 45, 2023, 4, 20, 40, 15, VIPticket.isVIP, new Cashier("Irene", "Black", "050598-78523", 2023, 9, 1));

            System.out.println(busTripArrayList.get(0));
            bt1.addTicket(t1);
            bt1.addTicket(t2);
            bt1.addTicket(t3);
            bt1.addTicket(t4);
            busTripArrayList.get(0).printShortInfo();

            System.out.println("------------------------------");
            System.out.println("Changing driver to Bus trip 2:");
            System.out.println("Bus Trip 1: " + busTripArrayList.get(1));
            bt2.changeBusDriver(bd3);
            System.out.println("Bus Trip 1: " + busTripArrayList.get(1));

            System.out.println("------------------------------");

            System.out.println("Cashier list before:");
            System.out.println(findAllCashiers());

            System.out.println("Adding new cashiers");
            addNewCashier("Amber", "Peterson", "200589-12459", new Date(2023, 8, 1));
            addNewCashier("Liliana", "Crawford", "543210-54321", new Date(2023, 5, 27));
            addNewCashier("Omar", "Patel", "789012-34567", new Date(2023, 9, 2));

            System.out.println("Cashier list now:");
            System.out.println(findAllCashiers());

            System.out.println("------------------------------");

            System.out.println("Finding cashier by person code:");
            System.out.println("Person code: 200589-12459");
            System.out.println(findCashierByPersonCode("200589-12459"));

            System.out.println("Finding cashier by person code:");
            System.out.println("Person code: 543210-54321");
            System.out.println(findCashierByPersonCode("543210-54321"));

            System.out.println("------------------------------");

            System.out.println("Updating cashier data by person code:");
            System.out.println("Person code - 789012-34567");
            System.out.println(findCashierByPersonCode("789012-34567"));
            System.out.println("Updating...");
            updateCashierByPersonCode("Abigail", "Switzerlandine", "789012-34567", new Date(2023, 7, 1));
            System.out.println(findCashierByPersonCode("789012-34567"));
            System.out.println("------------------------------");

            System.out.println("Deleting cashier by person code:");
            System.out.println("Cashier list before:");
            System.out.println(findAllCashiers());
            System.out.println("Person code - 789012-34567");
            deleteCashierByPersonCode("789012-34567");
            System.out.println("Cashier list now:");
           System.out.println(findAllCashiers());

        } catch (Exception e){
            System.out.println(e);
        }

    }

    public static boolean addNewCashier(String name, String surname, String personCode, Date contractDate) throws Exception {
        employeeArrayList.add(new Cashier(name, surname, personCode, contractDate.getYear(), contractDate.getMonth(), contractDate.getDay()));
        return true;
    }
    public static Cashier findCashierByPersonCode(String personCode){
        for(Employee temp : employeeArrayList){
            if(temp instanceof Cashier tempCashier){
                if(Objects.equals(tempCashier.getPersonCode(), personCode)){
                    return tempCashier;
                }
            }
        }
        return null;
    }
    public static boolean updateCashierByPersonCode(String name, String surname, String personCode, Date contractDate) throws Exception {
        for(Employee temp : employeeArrayList){
            if(temp instanceof Cashier tempCashier){
                if(Objects.equals(tempCashier.getPersonCode(), personCode)){
                    tempCashier.setName(name);
                    tempCashier.setSurname(surname);
                    tempCashier.setPersonCode(personCode);
                    tempCashier.setContractDate(contractDate.getYear(), contractDate.getMonth(), contractDate.getDay());
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean deleteCashierByPersonCode(String personCode){
        for(Employee temp : employeeArrayList){
            if(temp instanceof Cashier tempCashier){
                if(Objects.equals(tempCashier.getPersonCode(), personCode)){
                    employeeArrayList.remove(tempCashier);
                    tempCashier = null;
                    return true;
                }
            }
        }
        return false;
    }
    public static ArrayList<Cashier> findAllCashiers(){
        ArrayList<Cashier> tempCashierList = new ArrayList<>();
        for(Employee temp : employeeArrayList){
            if(temp instanceof Cashier tempCashier){
                tempCashierList.add(tempCashier);
            }
        }
        return tempCashierList;
    }
    /*

    public static boolean addNewBusDriver(String name, String surname, String personCode, Date contractDate, ArrayList<BusCategory> busCategory, int experience){}
    public static ArrayList<BusDriver> findBusDriverForCategory(BusCategory category){}
    public static boolean addNewCategoryForBusDriverByPersonCode(BusCategory category, String personCode)
    public static ArrayList<BusDriver> findAllBusDrivers(){}
    public static boolean addNewStation(City city, String title, WorkingTime workingTime){}
    public static boolean addNewBusTrip(Station inputStationFrom, Station inputStationTo, Time timeFrom, Time timeTo, Date dateFrom, Date dateTo, int inputNumberOfSeats, BusDriver inputDriver){}
    public static int howFreeSeatsOnBusTrip(Station inputStationFrom, Station inputStationTo, Time timeFrom, Date dateFrom){}
    public static ArrayList<Ticket> findAllTicketForBusTrip(Station inputStationFrom, Station inputStationTo, Time timeFrom, Date dateFrom){}
    public static ArrayList<BusTrip> findAllBusTripsFromStationToday(Station inputStationFrom){}
    public static boolean addTicketToBusTrip(Time ticketPurchaseTime, Date ticketPurchaseDate, double inputPrice, int inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson){}
    public static float howManyIncomeTodayByCashier(String personCode){}
    public static ArrayList<Ticket> findAllVipTicketsForToday(){}
    public static ArrayList<BusTrip> sortBusTripByTimeToday(Station station){}
    public static void generateBusTripsFromAllStationsToAllStationsThisWeek(){}*/

}
