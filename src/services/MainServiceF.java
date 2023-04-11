package services;
/*
* @info testing class Ticket
* i. Pievienot biļeti konkrētajam autobusa reisam (neaizmirstam pārbaudīt, vai reiss nav pilns);
* ii. Sameklēt visas pārdotās VIP biļetes;
* iii. Aprēķināt, cik daudz ieņēmumus šodien ir iekasējis konkrēts kasieris, ja ir zināms kasiera persona kods;
*/

import model.*;
import model.enumerators.BusCategory;
import model.enumerators.City;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;

import java.util.ArrayList;
import java.util.Objects;

public class MainServiceF {
    public static void main(String[] args) {
        try {
            Time time = new Time(12, 15);
            Date date = new Date(2023, 5, 15);
            Cashier cashier = new Cashier("Daniel", "Jackson", "201234-65422", 2023, 5, 1);
            Station stationfrom = new Station("Rainbow station", City.Ventspils, 12, 15);
            Station stationto = new Station("Cats station", City.Daugavpils, 10, 0, 21, 0);
            BusDriver driver1 = new BusDriver("William", "Didrihson", "123456-36695", 2023, 5, 5, 10);
            driver1.addCategory(BusCategory.minibus);
            driver1.addCategory(BusCategory.largebus);

            BusTrip busTrip = new BusTrip(9, 0, 11, 0, 2023, 4, 20, 2023, 4, 20, stationfrom, stationto, 40, driver1);

            Ticket t1 = new Ticket();
            Ticket t2 = new Ticket(time, date, 10.8, 0, VIPticket.isVIP, cashier);
            Ticket t3 = new Ticket(12, 0, 2025, 6, 1, 20, 20, VIPticket.notVIP, cashier);
            Ticket t4 = new Ticket(18, 2023, 8, 30, 100, 90, VIPticket.isVIP, cashier);
            ArrayList<Ticket> allTickets = new ArrayList<>();
            allTickets.add(t1);
            allTickets.add(t2);
            allTickets.add(t3);
            allTickets.add(t4);

            System.out.println("Tickets");
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
            System.out.println(t4);
            System.out.println("--------------------------");
            System.out.println("Adding ticket to bus trip");
            busTrip.addTicket(t2);
            busTrip.addTicket(t3);
            busTrip.addTicket(t4);
            System.out.println("Tickets in the bus trip");
            for(Object temp : busTrip.getAllTickets()){
                System.out.println(temp);
            }
            System.out.println("--------------------------");
            System.out.println("VIP tickets");
            for(Ticket temp : allTickets){
                if(temp.isVIP())
                    System.out.println(temp);
            }
            System.out.println("--------------------------");
            System.out.println("Cashier's salary for today");
            double result = 0.0;
            for(Ticket temp : allTickets){
                if(Objects.equals(temp.getCashierPerson().getPersonCode(), "201234-65422"))
                    result += temp.getPrice();
            }
            System.out.println(String.format("%.2f", result) + " EURO");

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
