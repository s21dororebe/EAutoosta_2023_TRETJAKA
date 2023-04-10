package services;
/*
* @info testing class Ticket
*/


import model.Cashier;
import model.Ticket;
import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;

public class MainServiceTicket {
    public static void main(String[] args) {
        try {
            Time time = new Time(12, 15);
            Date date = new Date(2023, 5, 15);
            Cashier cashier = new Cashier("Daniel", "Jackson", "20123-65422", 2023, 5, 1);

            Ticket t1 = new Ticket();
            Ticket t2 = new Ticket(time, date, 10.8, 0, VIPticket.isVIP, cashier);
            Ticket t3 = new Ticket(12, 0, 2021, 6, 1, 20, 20, VIPticket.notVIP, cashier);
            Ticket t4 = new Ticket(18, 2023, 8, 30, 100, 90, VIPticket.isVIP, cashier);

            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
            System.out.println(t4);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
