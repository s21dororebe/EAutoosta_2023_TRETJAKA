package services;
/*
* g. *Papildus funkcionalitāte (7 punkti)
* i. Sakārtot visus šīs dienas autobusa reisus pēc laika augošā secībā konkrētajā stacijā (3 punkti);
* ii. Uzģenerēt autobusa reisus no visām stacijām uz jebkuru citu staciju visas nedēļas garumā, ņemot vērā, ka nedrīkst ļaut
* vienlaicīgi izbraukt no vienas stacijas uz vairākiem galapunktiem (4 punkti);
*/

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class MainServiceG {
    public static void main(String[] args) {
        try {
            Time time = new Time(12, 15);
            Date date = new Date(2023, 5, 15);
            Cashier cashier = new Cashier("Daniel", "Jackson", "201234-65422", 2023, 5, 1);

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

            ArrayList<BusTrip> busTripList = new ArrayList<>();


            Ticket t1 = new Ticket();
            Ticket t2 = new Ticket(time, date, 10.8, 0, VIPticket.isVIP, cashier);
            Ticket t3 = new Ticket(12, 0, 2025, 6, 1, 20, 20, VIPticket.notVIP, cashier);
            Ticket t4 = new Ticket(18, 2023, 8, 30, 100, 90, VIPticket.isVIP, cashier);
            ArrayList<Ticket> allTickets = new ArrayList<>();
            allTickets.add(t1);
            allTickets.add(t2);
            allTickets.add(t3);
            allTickets.add(t4);

            System.out.println("--------------------------");
            System.out.println("All of the bus trips today from this station in Ventspils:");
            Station stationHere = new Station("Nice station", City.Ventspils, 6, 23);
            BusTrip busTripToday1 = new BusTrip(4, 50, 5, 50, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationto1, 20, driver1);
            BusTrip busTripToday2 = new BusTrip(6, 50, 7, 50, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationto2, 20, driver2);
            BusTrip busTripToday3 = new BusTrip(8, 50, 9, 50, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), stationHere, stationfrom2, 20, driver3);
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
            System.out.println("Ordered bus trip list from this station in Ventspils:");
            ArrayList<BusTrip> busTripToday = new ArrayList<>();
            for(BusTrip temp : busTripList){
                if(temp.getDateFrom().getYear() == LocalDate.now().getYear()
                        && temp.getDateFrom().getMonth() == LocalDate.now().getMonthValue()
                        && temp.getDateFrom().getDay() == LocalDate.now().getDayOfMonth()
                        && temp.getStationFrom().getCity() == City.Ventspils){
                    busTripToday.add(temp);
                }
            }


        } catch (Exception e){
            System.out.println(e);
        }
    }
}
