package model;

import model.enumerators.VIPticket;
import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private final long generatedId;
    private static long idCounter = 0;
    private Date ticketPurchaseDate;
    private Time ticketPurchaseTime;
    private int discount = 0;
    private double price = 0;
    private Cashier cashierPerson;
    private boolean isVIP = false;

    public Date getTicketPurchaseDate() {
        return ticketPurchaseDate;
    }
    public int getDiscount() {
        return discount;
    }
    public double getPrice() {
        return price;
    }
    public Cashier getCashierPerson() {
        return cashierPerson;
    }
    public boolean isVIP() {
        return isVIP;
    }

    //date is now
    public void setTicketPurchaseDate() throws Exception {
        ticketPurchaseDate = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }
    //date is inputted manually
    public void setTicketPurchaseDateByDateObject(Date ticketPurchaseDate) {
        if(ticketPurchaseDate != null)
            this.ticketPurchaseDate = ticketPurchaseDate;
    }
    public void setTicketPurchaseDateByYearMonthDay(int year, int month, int day) throws Exception {
        ticketPurchaseDate = new Date(year, month, day);
    }

    public void setDiscount(int inputDiscount) throws Exception {
        if(inputDiscount >= 0 && inputDiscount <= 100){
            discount = inputDiscount;
        } else throw (new Exception("Invalid discount input"));
    }
    public void setPrice(double inputPrice) throws Exception {
        if(inputPrice >= 0 && inputPrice <= 1000){
            if(discount > 0) {
                price = inputPrice - (inputPrice / 100 * discount);
            } else price = inputPrice;
        } else throw (new Exception("Invalid price input"));
    }
    public void setCashierPerson(Cashier inputCashierPerson) throws Exception {
        if(inputCashierPerson != null){
            cashierPerson = inputCashierPerson;
        } else throw (new Exception("Invalid input Cashier object"));
    }
    public void setVIP(VIPticket inputVIP) throws Exception {
        if(inputVIP == VIPticket.isVIP)
            isVIP = true;
        else if(inputVIP == VIPticket.notVIP)
            isVIP = false;
        else throw (new Exception("Invalid input data about VIP information"));
    }

    public Time getTicketPurchaseTime() {
        return ticketPurchaseTime;
    }
    //time is now
    public void setTicketPurchaseTime() throws Exception {
        ticketPurchaseTime = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }
    //time is inputted manually
    public void setTicketPurchaseTimeByTimeObject(Time inputTicketPurchaseTime) throws Exception {
        ticketPurchaseTime = new Time(inputTicketPurchaseTime.getHour(), inputTicketPurchaseTime.getMinute());
    }
    public void setTicketPurchaseTimeByHour(int hour) throws Exception {
        ticketPurchaseTime = new Time(hour);
    }
    public void setTicketPurchaseTimeByHourAndMinute(int hour, int minute) throws Exception {
        ticketPurchaseTime = new Time(hour, minute);
    }

    public Ticket() throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(); //time now
        setTicketPurchaseDate(); //date today
        setDiscount(0);
        setPrice(0);
        setVIP(VIPticket.notVIP);
        setCashierPerson(new Cashier());
    }
    public Ticket(Time ticketPurchaseTime, Date ticketPurchaseDate, double inputPrice, int inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;
        try {
            setTicketPurchaseTimeByTimeObject(ticketPurchaseTime);
            setTicketPurchaseDateByDateObject(ticketPurchaseDate);
            setDiscount(inputDiscount);
            setPrice(inputPrice);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public Ticket(int hour, int minute, int year, int month, int day, double inputPrice, int inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTimeByHourAndMinute(hour, minute);
        setTicketPurchaseDateByYearMonthDay(year, month, day);
        setDiscount(inputDiscount);
        setPrice(inputPrice);
        setVIP(inputVIP);
        setCashierPerson(inputCashierPerson);
    }
    public Ticket(int hour, int year, int month, int day, double inputPrice, int inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTimeByHour(hour);
        setTicketPurchaseDateByYearMonthDay(year, month, day);
        setDiscount(inputDiscount);
        setPrice(inputPrice);
        setVIP(inputVIP);
        setCashierPerson(inputCashierPerson);
    }

    @Override
    public String toString() {
        return "Ticket " + generatedId + ": " + ticketPurchaseDate + " "
                + ticketPurchaseTime + ", " + String.format("%.2f", price) + " EURO, discount: " + discount + "%, is the ticket a VIP: " + isVIP + ", cashier: " + cashierPerson.getName() + " " + cashierPerson.getSurname();
    }
}
