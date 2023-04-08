package model;

import model.extraClasses.Date;
import model.extraClasses.Time;

import java.util.PriorityQueue;

public class BusTrip {
    private final long generatedId;
    private static long idCounter = 0;
    private Station stationFrom;
    private Station stationTo;
    private Date dateFrom;
    private Date dateTo;
    private Time timeFrom;
    private Time timeTo;
    private int numberOfSeats = 0;
    private BusDriver driver;
    //if numberOfSeats < 30 => minibus || largebus
    //if numberOfSeats >= 30 => largebus


    public Station getStationFrom() {
        return stationFrom;
    }
    public Station getStationTo() {
        return stationTo;
    }
    public Date getDateFrom() {
        return dateFrom;
    }
    public Date getDateTo() {
        return dateTo;
    }
    public Time getTimeFrom() {
        return timeFrom;
    }
    public Time getTimeTo() {
        return timeTo;
    }
    public BusDriver getDriver() {
        return driver;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setStationFrom(Station stationFrom) {
        this.stationFrom = stationFrom;
    }
    public void setStationTo(Station stationTo) {
        this.stationTo = stationTo;
    }
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }
    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public void setDriver(BusDriver driver) {
        this.driver = driver;
    }

    public BusTrip(){}
//    public BusTrip(){}
//    public BusTrip(){}

    public void addTicket(){}
    //tickets <= numberOfSeats
    //VIP tickets are going 1st
    public void changeBusDriver(){}

}
