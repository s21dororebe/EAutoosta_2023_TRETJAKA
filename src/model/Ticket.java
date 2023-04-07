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

    public void setDiscount(double inputDiscount) {
        if(inputDiscount >= 0){
            discount = inputDiscount;
        }
    }
    public void setPrice(double inputPrice) {
        if(inputPrice >= 0){
            if(discount > 0) {
                price = inputPrice - (inputPrice / 100 * discount);
            } else price = inputPrice;
        }
    }
    public void setCashierPerson(Cashier inputCashierPerson) {
        if(inputCashierPerson != null){
            cashierPerson = inputCashierPerson;
        }
    }
    public void setVIP(VIPticket inputVIP) {
        if(inputVIP == VIPticket.isVIP)
            isVIP = true;
        else if(inputVIP == VIPticket.notVIP)
            isVIP = false;
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
    public Ticket(Time ticketPurchaseTime, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;
        try {
            setTicketPurchaseTimeByTimeObject(ticketPurchaseTime);
            setTicketPurchaseDate(); //date today
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public Ticket(Date ticketPurchaseDate, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTicketPurchaseTime(); //time now
            setTicketPurchaseDateByDateObject(ticketPurchaseDate);
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public Ticket(int hour, int minute, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTicketPurchaseTimeByHourAndMinute(hour, minute);
            setTicketPurchaseDate(); //date today
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public Ticket(int hour, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTicketPurchaseTimeByHour(hour);
            setTicketPurchaseDate(); //date today
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public Ticket(int year, int month, int day, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTicketPurchaseTime(); //time now
            setTicketPurchaseDateByYearMonthDay(year, month, day);
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public Ticket(int hour, int minute, int year, int month, int day, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTicketPurchaseTimeByHourAndMinute(hour, minute);
            setTicketPurchaseDateByYearMonthDay(year, month, day);
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public Ticket(Time ticketPurchaseTime, Date ticketPurchaseDate, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTicketPurchaseTimeByTimeObject(ticketPurchaseTime);
            setTicketPurchaseDateByDateObject(ticketPurchaseDate);
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }

    //TODO euro symbol
    //TODO price view is: 10.5; needs to be: 10,50 euro
    //TODO discount view 0.0 => 0%
    @Override
    public String toString() {
        return "Ticket " + generatedId + ": " + ticketPurchaseTime + " "
                + ticketPurchaseDate + ", " + price + "€, discount: " + discount + ", is the ticket a VIP: " + isVIP + ", cashier: " + cashierPerson;
    }
}
