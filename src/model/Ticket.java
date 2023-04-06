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

    public void setDiscount(double inputDiscount) throws Exception {
        if(inputDiscount >= 0){
            discount = inputDiscount;
        } else {
            throw (new Exception("Invalid input discount data"));
        }
    }
    public void setPrice(double inputPrice) throws Exception {
        if(inputPrice >= 0){
            if(discount > 0) {
                price = inputPrice - (inputPrice / 100 * discount);
            } else price = inputPrice;
        } else {
            throw (new Exception("Invalid input price data"));
        }
    }
    public void setCashierPerson(Cashier inputCashierPerson) throws Exception {
        if(inputCashierPerson != null){
            cashierPerson = inputCashierPerson;
        } else {
            throw (new Exception("Invalid input data about cashier"));
        }
    }
    public void setVIP(VIPticket inputVIP) throws Exception {
        if(inputVIP == VIPticket.isVIP)
            isVIP = true;
        else if(inputVIP == VIPticket.notVIP)
            isVIP = false;
        else
            throw (new Exception("Invalid 'is it VIP ticket' input"));

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
        setDiscount(0);
        setPrice(0);
        setVIP(VIPticket.notVIP);
        setCashierPerson(new Cashier());
    }
    public Ticket(Time ticketPurchaseTime, double inputPrice, double inputDiscount, VIPticket inputVIP, Cashier inputCashierPerson) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTicketPurchaseTime(ticketPurchaseTime);
        setTicketPurchaseDate(); //date today
        try {
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

        setTicketPurchaseTime(); //time now
        setTicketPurchaseDate(ticketPurchaseDate);
        try {
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

        setTicketPurchaseTime(hour, minute);
        setTicketPurchaseDate(); //date today
        try {
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

        setTicketPurchaseTime(hour);
        setTicketPurchaseDate(); //date today
        try {
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

        setTicketPurchaseTime(); //time now
        setTicketPurchaseDate(year, month, day);
        try {
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

        setTicketPurchaseTime(hour, minute);
        setTicketPurchaseDate(year, month, day);
        try {
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

        setTicketPurchaseTime(ticketPurchaseTime);
        setTicketPurchaseDate(ticketPurchaseDate);
        try {
            setPrice(inputPrice);
            setDiscount(inputDiscount);
            setVIP(inputVIP);
            setCashierPerson(inputCashierPerson);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }

    //TODO toString function
    @Override
    public String toString() {
        return "Ticket " + generatedId + ": " + ticketPurchaseTime + " "
                + ticketPurchaseDate + ", " + price + "€, discount: " + discount + ", is the ticket a VIP: " + isVIP + ", cashier: " + cashierPerson;
    }
}
