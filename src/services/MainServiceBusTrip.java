package services;

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;

public class MainServiceBusTrip {
    public static void main(String[] args) {
        try {
            Time timefrom = new Time(12);
            Time timeto = new Time(16);
            Date datefrom = new Date(2025, 2, 12);
            Date dateto = new Date(2025, 2, 12);
            Station stationfrom = new Station("Rainbow station", City.Ventspils, 12, 15);
            Station stationto = new Station("Cats station", City.Daugavpils, 10, 0, 21, 0);
            BusDriver driver1 = new BusDriver("William", "Didrihson", "123456-36695", 2023, 5, 5, 10);
            BusDriver driver2 = new BusDriver("Julian", "Didrihson", "123456-36695", 2025, 5, 5, 10);
            driver2.addCategory(BusCategory.minibus);
            driver1.addCategory(BusCategory.minibus);
            driver1.addCategory(BusCategory.largebus);


            BusTrip bt1 = new BusTrip(timefrom, timeto, 2023, 12, 12, 2023, 12, 12, stationfrom, stationto, 20, driver1);
            BusTrip bt2 = new BusTrip(12, 20, 13, 20, datefrom, dateto, stationfrom, stationto, 40, driver1);
            BusTrip bt3 = new BusTrip(9, 0, 11, 0, 2023, 4, 20, 2023, 4, 20, stationfrom, stationto, 40, driver1);
            BusTrip bt4 = new BusTrip(timefrom, timeto, datefrom, dateto, stationfrom, stationto, 50, driver1);

            System.out.println(bt1);
            System.out.println(bt2);
            System.out.println(bt3);
            System.out.println(bt4);

            Time time = new Time(12, 15);
            Date date = new Date(2023, 5, 15);
            Cashier cashier = new Cashier("Daniel", "Jackson", "20123-65422", 2023, 5, 1);

            Ticket t1 = new Ticket();
            Ticket t2 = new Ticket(time, date, 10.8, 0, VIPticket.isVIP, cashier);
            Ticket t3 = new Ticket(12, 0, 2025, 6, 1, 20, 20, VIPticket.notVIP, cashier);
            Ticket t4 = new Ticket(18, 2023, 8, 30, 100, 90, VIPticket.isVIP, cashier);

            bt1.addTicket(t1);
            bt1.addTicket(t2);
            bt1.addTicket(t3);
            bt1.addTicket(t4);
            bt1.printShortInfo();
            driver2.addCategory(BusCategory.largebus);
            bt1.changeBusDriver(driver2);
            bt1.printShortInfo();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
