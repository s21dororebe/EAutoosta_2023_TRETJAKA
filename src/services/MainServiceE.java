package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/*
* @info BusTrip class
* Darbības ar autobusa reisu jeb BusTrip objektiem (12 punkti- par katru 3 punkti)
* i. Pievienot jaunu autobusa reisu;
* ii. Noskaidrot, cik daudz vietas ir vēl brīvas uz konkrētu autobusa reisu, norādot izbraukšanas datumu un laiku, kā arī abas
* stacijas - no kuras izbrauks un uz kuru brauks;
* iii. Sameklēt visas biļetes uz konkrēto autobusa reisu, norādot izbraukšanas datumu un laiku, kā arī abas stacijas - no kuras
* izbrauks, un uz kuru brauks;
* iv. Sameklēt visus šīs dienas reisus no konkrētas stacijas;
* */

public class MainServiceE {
    public static void main(String[] args) {
        try {
            ArrayList<BusTrip> busTripList = new ArrayList<>();

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
            bt4.printShortInfo();
            bt4.changeBusDriver(driver3);
            bt4.printShortInfo();

            System.out.println("--------------------------");
            System.out.println("How many places left on the bus trip :");
            System.out.println("BusTrip: time 12:20, date 12/02/2025, Dogs station -> Birds station");
            for(BusTrip temp : busTripList){
                if(temp.getDateFrom().getYear() == 2025
                        && temp.getDateFrom().getMonth() == 2
                        && temp.getDateFrom().getDay() == 12
                        && temp.getTimeFrom().getHour() == 12
                        && temp.getTimeFrom().getMinute() == 20
                        && Objects.equals(temp.getStationFrom().getTitle(), "Dogs station")
                        && Objects.equals(temp.getStationTo().getTitle(), "Birds station")){
                    System.out.println((temp.getNumberOfSeats() - temp.getAllTickets().size()) + " tickets left");
                }
            }
            System.out.println("--------------------------");
            System.out.println("All of the tickets on the bus trip :");
            System.out.println("BusTrip: time 09:00, date 20/04/2024, Rainbow station -> Birds station");
            for(BusTrip temp : busTripList){
                if(temp.getDateFrom().getYear() == 2023
                        && temp.getDateFrom().getMonth() == 4
                        && temp.getDateFrom().getDay() == 20
                        && temp.getTimeFrom().getHour() == 9
                        && temp.getTimeFrom().getMinute() == 0
                        && Objects.equals(temp.getStationFrom().getTitle(), "Rainbow station")
                        && Objects.equals(temp.getStationTo().getTitle(), "Birds station")){
                    for(Object tempTicket : temp.getAllTickets()){
                        System.out.println(tempTicket);
                    }
                }
            }
            System.out.println("--------------------------");
            System.out.println("All of the bus trips today from this station in Ventspils :");
            Station stationHere = new Station("Nice station", City.Ventspils, 6, 23);
            BusTrip busTripToday1 = new BusTrip(24, 50, 23, 50, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationto1, 20, driver1);
            BusTrip busTripToday2 = new BusTrip(22, 50, 23, 50, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationto2, 20, driver2);
            BusTrip busTripToday3 = new BusTrip(22, 50, 23, 50, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationfrom2, 20, driver3);
            busTripList.add(busTripToday1);
            busTripList.add(busTripToday2);
            busTripList.add(busTripToday3);
            for(BusTrip temp : busTripList){
                if(temp.getDateFrom().getYear() == LocalDate.now().getYear()
                        && temp.getDateFrom().getMonth() == LocalDate.now().getMonthValue()
                        && temp.getDateFrom().getDay() == LocalDate.now().getDayOfMonth()
                        && temp.getStationFrom().getCity() == City.Ventspils){
                    System.out.println(temp);
                }
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
