package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;
import model.extraClasses.WorkingTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Collections.addAll;

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

            ///CASHIERS
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
            System.out.println("------------------------------");

            ///BUS DRIVERS
            System.out.println("Bus drivers list before:");
            System.out.println(findAllBusDrivers());
            System.out.println("Adding new bus drivers...");
            //String name, String surname, String personCode, Date contractDate, ArrayList<BusCategory> busCategory, int experience
            addNewBusDriver("Isabelle", "Smith", "345678-90123", new Date(2024, 5, 6), new ArrayList<>(List.of(BusCategory.minibus)), 5);
            addNewBusDriver("Ethan", "Kim", "789082-34467", new Date(2024, 9, 16), new ArrayList<>(List.of(BusCategory.minibus, BusCategory.schoolbus)), 6);
            System.out.println("Bus drivers list now:");
            System.out.println(findAllBusDrivers());

            System.out.println("------------------------------");
            System.out.println("Finding bus driver by category:");
            System.out.println("Category: schoolbus");
            System.out.println(findBusDriverForCategory(BusCategory.schoolbus));

            System.out.println("Finding bus driver by category:");
            System.out.println("Category: minibus");
            System.out.println(findBusDriverForCategory(BusCategory.minibus));

            System.out.println("------------------------------");

            System.out.println("Add new category for bus driver by person code:");
            System.out.println("Bus driver list before:");
            System.out.println(findAllBusDrivers());
            System.out.println("Person code - 345678-90123, category: largebus");
            addNewCategoryForBusDriverByPersonCode(BusCategory.largebus, "345678-90123");
            System.out.println("Updating...");
            System.out.println("Bus driver list now:");
            System.out.println(findAllBusDrivers());
            System.out.println("------------------------------");

            //STATION
            System.out.println("Stations");
            addNewStation(City.Ventspils, "Flowers station", new WorkingTime(6, 23)); //id 6
            addNewStation(City.Jelgava, "Cats station", new WorkingTime(5, 30, 23, 30)); //id 7
            addNewStation(City.Liepaja, "Dogs station", new WorkingTime(5, 22)); //id 8
            for(Station temp : stationArrayList)
                System.out.println(temp);
            System.out.println("------------------------------");

            System.out.println("Bus trips");
            //following bus trips have indexes 6-8
            addNewBusTrip(stationArrayList.get(6), stationArrayList.get(7), new Time(12), new Time(13), new Date(2023, 5, 9), new Date(2023, 5, 9), 20, findBusDriverForCategory(BusCategory.minibus).get(0));
            addNewBusTrip(stationArrayList.get(7), stationArrayList.get(8), new Time(15, 30), new Time(16, 30), new Date(2023, 5, 10), new Date(2023, 5, 10), 40, findBusDriverForCategory(BusCategory.largebus).get(0));
            addNewBusTrip(stationArrayList.get(6), stationArrayList.get(8), new Time(17, 30), new Time(18, 30), new Date(2023, 5, 11), new Date(2023, 5, 11), 20, findBusDriverForCategory(BusCategory.schoolbus).get(0));
            for(BusTrip temp : busTripArrayList)
                System.out.println(temp);
            System.out.println("------------------------------");

            System.out.println("Adding tickets");
            System.out.println(busTripArrayList.get(6));
            addTicketToBusTrip(new Time(12), new Date(2023, 6, 1), 20, 10, VIPticket.notVIP, findAllCashiers().get(0), stationArrayList.get(6), stationArrayList.get(7));
            addTicketToBusTrip(new Time(13), new Date(2023, 6, 1), 15, 0, VIPticket.isVIP, findAllCashiers().get(0), stationArrayList.get(6), stationArrayList.get(7));
            addTicketToBusTrip(new Time(14), new Date(2023, 6, 1), 20, 10, VIPticket.notVIP, findAllCashiers().get(0), stationArrayList.get(6), stationArrayList.get(7));
            System.out.println("Adding tickets to a bus trip...");
            for(Ticket temp : findAllTicketForBusTrip(stationArrayList.get(6), stationArrayList.get(7), new Time(12), new Date(2023, 5, 9)))
                System.out.println(temp);

            System.out.println();
            System.out.println(busTripArrayList.get(7));
            addTicketToBusTrip(new Time(15, 30), new Date(2023, 5, 10), 50, 15, VIPticket.isVIP, findAllCashiers().get(1), stationArrayList.get(7), stationArrayList.get(8));
            addTicketToBusTrip(new Time(16, 30), new Date(2023, 5, 10), 20, 10, VIPticket.notVIP, findAllCashiers().get(1), stationArrayList.get(7), stationArrayList.get(8));
            System.out.println("Adding tickets to a bus trip...");
            for(Ticket temp : findAllTicketForBusTrip(stationArrayList.get(7), stationArrayList.get(8), new Time(15, 30), new Date(2023, 5, 10)))
                System.out.println(temp);
            System.out.println("------------------------------");
            System.out.println("The number of free seats on the BusTrip 6 : " + howManyFreeSeatsOnBusTrip(stationArrayList.get(6), stationArrayList.get(7), new Time(12), new Date(2023, 5, 9)));
            System.out.println("All bus trips from Flowers station, Ventspils:");
            for(BusTrip temp : findAllBusTripsFromStationToday(stationArrayList.get(6)))
                System.out.println(temp);
            System.out.println("------------------------------");
            System.out.println("Income of the cashier with person code [200589-12459] : " + howManyIncomeTodayByCashier("200589-12459"));
            System.out.println("------------------------------");
            System.out.println("All VIP Tickets For Today : ");
            for(Ticket temp : findAllVipTicketsForToday())
                System.out.println(temp);
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");

            for(int i = 0; i < 100000; i++)
                generateBusTripsFromAllStationsToAllStationsThisWeek();

//            for(BusTrip temp : busTripArrayList)
//                System.out.println(temp);

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
    public static boolean addNewBusDriver(String name, String surname, String personCode, Date contractDate, ArrayList<BusCategory> busCategory, int experience) throws Exception {
        BusDriver busDriverTemp = new BusDriver(name, surname, personCode, contractDate.getYear(), contractDate.getMonth(), contractDate.getDay(), experience);
        for(BusCategory temp : busCategory)
            busDriverTemp.addCategory(temp);
        employeeArrayList.add(busDriverTemp);
        return true;
    }
    public static ArrayList<BusDriver> findBusDriverForCategory(BusCategory category){
        ArrayList<BusDriver> tempBusDriverList = new ArrayList<>();
        for(Employee temp : employeeArrayList){
            if(temp instanceof BusDriver tempBusDriver){
                if(tempBusDriver.getDriveCategories().contains(category))
                    tempBusDriverList.add(tempBusDriver);
            }
        }
        return tempBusDriverList;
    }
    public static boolean addNewCategoryForBusDriverByPersonCode(BusCategory category, String personCode) throws Exception {
        for(Employee temp : employeeArrayList){
            if(temp instanceof BusDriver tempBusDriver){
                if(Objects.equals(tempBusDriver.getPersonCode(), personCode)){
                    tempBusDriver.addCategory(category);
                    return true;
                }
            }
        }
        return false;
    }
    public static ArrayList<BusDriver> findAllBusDrivers(){
        ArrayList<BusDriver> tempBusDriverList = new ArrayList<>();
        for(Employee temp : employeeArrayList){
            if(temp instanceof BusDriver tempBusDriver){
                tempBusDriverList.add(tempBusDriver);
            }
        }
        return tempBusDriverList;
    }
    public static boolean addNewStation(City city, String title, WorkingTime workingTime) throws Exception {
        stationArrayList.add(new Station(title, city, workingTime));
        return true;
    }
    public static boolean addNewBusTrip(Station inputStationFrom, Station inputStationTo, Time timeFrom, Time timeTo, Date dateFrom, Date dateTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception{
        busTripArrayList.add(new BusTrip(timeFrom, timeTo, dateFrom, dateTo, inputStationFrom, inputStationTo, inputNumberOfSeats, inputDriver));
        return true;

    }
    public static int howManyFreeSeatsOnBusTrip(Station inputStationFrom, Station inputStationTo, Time timeFrom, Date dateFrom){
        for(BusTrip temp : busTripArrayList){
            if(Objects.equals(temp.getStationFrom().getTitle(), inputStationFrom.getTitle())
                    && Objects.equals(temp.getStationTo().getTitle(), inputStationTo.getTitle())
                    && Objects.equals(temp.getStationFrom().getCity(), inputStationFrom.getCity())
                    && Objects.equals(temp.getStationTo().getCity(), inputStationTo.getCity())
                    && temp.getTimeFrom().getHour() == timeFrom.getHour()
                    && temp.getTimeFrom().getMinute() == timeFrom.getMinute()
                    && temp.getDateFrom().getYear() == dateFrom.getYear()
                    && temp.getDateFrom().getMonth() == dateFrom.getMonth()
                    && temp.getDateFrom().getDay() == dateFrom.getDay()){
                return(temp.getNumberOfSeats() - temp.getAllTickets().size());
            }
        }
        return -1;
    }
    public static ArrayList<Ticket> findAllTicketForBusTrip(Station inputStationFrom, Station inputStationTo, Time timeFrom, Date dateFrom){
        Deque<Ticket> ticketDeque = new ArrayDeque<>();
        for(BusTrip temp : busTripArrayList){
            if(Objects.equals(temp.getStationFrom().getTitle(), inputStationFrom.getTitle())
                    && Objects.equals(temp.getStationTo().getTitle(), inputStationTo.getTitle())
                    && Objects.equals(temp.getStationFrom().getCity(), inputStationFrom.getCity())
                    && Objects.equals(temp.getStationTo().getCity(), inputStationTo.getCity())
                    && temp.getTimeFrom().getHour() == timeFrom.getHour()
                    && temp.getTimeFrom().getMinute() == timeFrom.getMinute()
                    && temp.getDateFrom().getYear() == dateFrom.getYear()
                    && temp.getDateFrom().getMonth() == dateFrom.getMonth()
                    && temp.getDateFrom().getDay() == dateFrom.getDay()){
                for(Object tempTicket : temp.getAllTickets()){
                    ticketDeque.add((Ticket) tempTicket);
                }
            }
        }
        return new ArrayList<>(ticketDeque);
    }
    public static ArrayList<BusTrip> findAllBusTripsFromStationToday(Station inputStationFrom){
        ArrayList<BusTrip> busTrips = new ArrayList<>();
        for(BusTrip temp : busTripArrayList){
            if(temp.getStationFrom() == inputStationFrom)
                busTrips.add(temp);
        }
        return busTrips;
    }
    public static boolean addTicketToBusTrip(Time ticketPurchaseTime, Date ticketPurchaseDate, double inputPrice, int inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson, Station inputStationFrom, Station inputStationTo) throws Exception {
        for(BusTrip temp : busTripArrayList){
            if(temp.getStationFrom() == inputStationFrom
                    && temp.getStationTo() == inputStationTo){
                temp.addTicket(new Ticket(ticketPurchaseTime, ticketPurchaseDate, inputPrice, inputDiscount, inputVIP, inputCashierPerson));
                return true;
            }
        }
        return false;
    }
    //TODO to test following 3 functions you need to change the date of the bus trips, don't forget - they need to be today but in the future by the time
    public static float howManyIncomeTodayByCashier(String personCode){
        float result = 0;

        for(BusTrip tempBusTrip : busTripArrayList){
            if(tempBusTrip.getDateFrom().getYear() == LocalDateTime.now().getYear()
                    && tempBusTrip.getDateFrom().getMonth() == LocalDateTime.now().getMonthValue()
                    && tempBusTrip.getDateFrom().getDay() == LocalDateTime.now().getDayOfMonth()) {
                ArrayList<Ticket> tempTicketList = findAllTicketForBusTrip(tempBusTrip.getStationFrom(), tempBusTrip.getStationTo(), tempBusTrip.getTimeFrom(), tempBusTrip.getDateFrom());
                if(!tempTicketList.isEmpty()){
                    for(Ticket ticket : tempTicketList){
                        if(Objects.equals(ticket.getCashierPerson().getPersonCode(), personCode)){
                            result += ticket.getPrice();
                        }
                    }
                }
            }
        }
        return result;
    }
    public static ArrayList<Ticket> findAllVipTicketsForToday(){
        ArrayList<Ticket> tempList = new ArrayList<>();

        for(BusTrip tempBusTrip : busTripArrayList){
            if(tempBusTrip.getDateFrom().getYear() == LocalDateTime.now().getYear()
                    && tempBusTrip.getDateFrom().getMonth() == LocalDateTime.now().getMonthValue()
                    && tempBusTrip.getDateFrom().getDay() == LocalDateTime.now().getDayOfMonth()) {
                ArrayList<Ticket> tempTicketList = findAllTicketForBusTrip(tempBusTrip.getStationFrom(), tempBusTrip.getStationTo(), tempBusTrip.getTimeFrom(), tempBusTrip.getDateFrom());
                if(!tempTicketList.isEmpty()){
                    for(Ticket ticket : tempTicketList){
                        if(ticket.isVIP()){
                            tempList.add(ticket);
                        }
                    }
                }
            }
        }
        return tempList;
    }
    public static ArrayList<BusTrip> sortBusTripByTimeToday(Station station){
        ArrayList<BusTrip> tempBusTripListResult = findAllBusTripsFromStationToday(station);
        //copy this list started from index=1 element
        ArrayList<BusTrip> tempBusTripListTemp = new ArrayList<>(tempBusTripListResult);
        tempBusTripListTemp.remove(0);

        for(BusTrip tempBusTripI : tempBusTripListResult){
            for(BusTrip tempBusTripJ : tempBusTripListTemp){
                if(tempBusTripI.getTimeFrom().getHour() > tempBusTripJ.getTimeFrom().getHour()){
                    BusTrip temp = tempBusTripI;
                    tempBusTripI = tempBusTripJ;
                    tempBusTripJ = temp;
                } else if(tempBusTripI.getTimeFrom().getHour() == tempBusTripJ.getTimeFrom().getHour()){
                    if(tempBusTripI.getTimeFrom().getMinute() > tempBusTripJ.getTimeFrom().getMinute()){
                        BusTrip temp = tempBusTripI;
                        tempBusTripI = tempBusTripJ;
                        tempBusTripJ = temp;
                    }
                }
            }
        }

        return tempBusTripListResult;
    }

    //TODO create more drivers
    public static void generateBusTripsFromAllStationsToAllStationsThisWeek() throws Exception {
        ArrayList<Station> tempStationArrayList = new ArrayList<>(stationArrayList);
        tempStationArrayList.remove(0);
        ArrayList<Integer> numberOfSeats = new ArrayList<>(Arrays.asList(20, 30, 40, 50));

        for(Station tempStationFrom : stationArrayList){
            //Station inputStationFrom, Station inputStationTo, Time timeFrom, Time timeTo, Date dateFrom, Date dateTo, int inputNumberOfSeats, BusDriver inputDriver
            //generate time and date
            for(Station tempStationTo : tempStationArrayList){
                if(tempStationTo.getCity() != tempStationFrom.getCity()){
                    Date randomDate = new Date(createRandomDate().getYear(), createRandomDate().getMonthValue(), createRandomDate().getDayOfMonth());
                    Time randomTime = createRandomTime();
                    int index = createRandomIntBetween(0, 3);
                    int timeIndex = createRandomIntBetween(1, 3);
                    int seats = numberOfSeats.get(index);
                    if (seats < 30){
                        addNewBusTrip(tempStationFrom, tempStationTo, randomTime,
                                new Time(randomTime.getHour()+timeIndex, randomTime.getMinute()), randomDate, randomDate, seats,
                                findBusDriverForCategory(BusCategory.minibus).get(0));
                    } else addNewBusTrip(tempStationFrom, tempStationTo, randomTime,
                            new Time(randomTime.getHour()+timeIndex, randomTime.getMinute()), randomDate, randomDate, seats,
                            findBusDriverForCategory(BusCategory.largebus).get(0));
                }
            }
        }

    }
    /*https://www.logicbig.com/how-to/code-snippets/jcode-java-random-random-dates.html*/

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate() {
        int day = createRandomIntBetween(LocalDate.now().getDayOfMonth(), LocalDate.now().getDayOfMonth()+10);
        return LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), day);
    }

    public static Time createRandomTime() throws Exception {
        int hourFrom = createRandomIntBetween(6, 20);
        int minuteFrom = createRandomIntBetween(0, 59);
        return new Time(hourFrom, minuteFrom);
    }


















}
