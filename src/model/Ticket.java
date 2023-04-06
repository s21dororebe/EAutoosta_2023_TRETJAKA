package model;

import model.enumerators.City;
import model.extraClasses.Date;
import model.extraClasses.WorkingTime;

public class Ticket {
    /*
    * Ticket (5 punkti) - paredzēta biļešu izveidei. Ir jābūt unikālam id, biļetes iegādes datumam
    * un laikam, atlaidei (procentos), cenai, kasierim, kurš pārdeva biļeti,
    * un informācijai par to, vai biļete ir VIP biļete vai ne*/

    private final long generatedId;
    private static long idCounter = 0;
    private Date ticketPurchaseDate;
    private WorkingTime ticketPurchaseTime;
    private double discount = 0;
    private double price = 0;
    private Cashier cashierPerson;
    private boolean isVIP = false;

    public WorkingTime getTicketPurchaseTime() {
        return ticketPurchaseTime;
    }
    public void setTicketPurchaseTime(WorkingTime inputTicketPurchaseTime) throws Exception {
        ticketPurchaseTime = new WorkingTime(inputTicketPurchaseTime.getStartHour(),
                inputTicketPurchaseTime.getStartMinute(),
                inputTicketPurchaseTime.getEndHour(),
                inputTicketPurchaseTime.getEndMinute());
    }
    public void setTicketPurchaseTime(int startHour, int endHour) throws Exception {
        ticketPurchaseTime = new WorkingTime(startHour, endHour);
    }
    public void setTicketPurchaseTime(int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        ticketPurchaseTime = new WorkingTime(startHour, startMinute, endHour, endMinute);
    }

    public Station() throws Exception {
        generatedId = idCounter;
        idCounter++;
        setTitle("Unknown");
    }
    public Station(String title, City city, WorkingTime workingTime) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTitle(title);
        setCity(city);
        setWorkingTime(workingTime);
    }
    public Station(String title, City city, int startHour, int endHour) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTitle(title);
        setCity(city);
        setWorkingTime(startHour, endHour);
    }
    public Station(String title, City city, int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTitle(title);
        setCity(city);
        setWorkingTime(startHour, startMinute, endHour, endMinute);
    }


}
