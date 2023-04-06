package model;

import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
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
    //time is now
    public void setTicketPurchaseTime() throws Exception {
        ticketPurchaseTime = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }
    //time is inputted manually
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

        setTicketPurchaseTime(); //time now
        setTicketPurchaseDate(); //date today
    }
    public Ticket(Time ticketPurchaseTime) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(ticketPurchaseTime);
        setTicketPurchaseDate(); //date today
    }
    public Ticket(Date ticketPurchaseDate) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(); //time now
        setTicketPurchaseDate(ticketPurchaseDate);
    }
    public Ticket(int hour, int minute) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(hour, minute);
        setTicketPurchaseDate(); //date today
    }
    public Ticket(int hour) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(hour);
        setTicketPurchaseDate(); //date today
    }
    public Ticket(int year, int month, int day) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(); //time now
        setTicketPurchaseDate(year, month, day);
    }
    public Ticket(int hour, int minute, int year, int month, int day) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(hour, minute);
        setTicketPurchaseDate(year, month, day);
    }
    public Ticket(Time ticketPurchaseTime, Date ticketPurchaseDate) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(ticketPurchaseTime);
        setTicketPurchaseDate(ticketPurchaseDate);
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
