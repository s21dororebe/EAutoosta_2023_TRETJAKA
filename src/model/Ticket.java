package model;

import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    /*
    * Ticket (5 punkti) - paredzēta biļešu izveidei. Ir jābūt unikālam id, biļetes iegādes datumam
    * un laikam, atlaidei (procentos), cenai, kasierim, kurš pārdeva biļeti,
    * un informācijai par to, vai biļete ir VIP biļete vai ne*/

    private final long generatedId;
    private static long idCounter = 0;
    private Date ticketPurchaseDate; //done
    private Time ticketPurchaseTime; //done
    private double discount = 0;
    private double price = 0;
    private Cashier cashierPerson;
    private boolean isVIP = false;

    public Date getTicketPurchaseDate() {
        return ticketPurchaseDate;
    }
    public double getDiscount() {
        return discount;
    }
    public double getPrice() {
        return price;
    }
    public Cashier getCashierPerson() {
        return cashierPerson;
    }

    //date is now
    public void setTicketPurchaseDate() {
        ticketPurchaseDate = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }
    //date is inputted manually
    public void setTicketPurchaseDate(Date ticketPurchaseDate) {
        if(ticketPurchaseDate != null)
            this.ticketPurchaseDate = ticketPurchaseDate;
    }
    public void setTicketPurchaseDate(int year, int month, int day) {
        ticketPurchaseDate = new Date(year, month, day);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCashierPerson(Cashier cashierPerson) {
        this.cashierPerson = cashierPerson;
    }

    public boolean isVIP() {
        return isVIP;
    }
    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public Time getTicketPurchaseTime() {
        return ticketPurchaseTime;
    }
    public void setTicketPurchaseTime() throws Exception {
        ticketPurchaseTime = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }
    public void setTicketPurchaseTime(Time inputTicketPurchaseTime) throws Exception {
        ticketPurchaseTime = new Time(inputTicketPurchaseTime.getHour(), inputTicketPurchaseTime.getMinute());
    }
    public void setTicketPurchaseTime(int hour) throws Exception {
        ticketPurchaseTime = new Time(hour);
    }
    public void setTicketPurchaseTime(int hour, int minute) throws Exception {
        ticketPurchaseTime = new Time(hour, minute);
    }

    public Ticket() throws Exception {
        generatedId = idCounter;
        idCounter++;
    }
    public Ticket(Time ticketPurchaseTime) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(ticketPurchaseTime);
    }
    public Ticket(int startHour, int endHour) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(startHour, endHour);
    }
    public Ticket(int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(startHour, startMinute, endHour, endMinute);
    }

    //TODO toString function
    @Override
    public String toString() {
        return "Ticket{" +
                "generatedId=" + generatedId +
                ", ticketPurchaseDate=" + ticketPurchaseDate +
                ", ticketPurchaseTime=" + ticketPurchaseTime +
                ", discount=" + discount +
                ", price=" + price +
                ", cashierPerson=" + cashierPerson +
                ", isVIP=" + isVIP +
                '}';
    }
}
