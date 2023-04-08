package model;

import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalTime;
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
    //---------------------------------------------------------------------------------------------

    //TIME

    public void setTimeFrom() throws Exception {
        timeTo = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }
    public void setTimeFromByTimeObject(Time inputTimeFrom) throws Exception {
        timeTo = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
    }
    public void setTimeFromByHour(int hour) throws Exception {
        timeTo = new Time(hour);
    }
    public void setTimeFromByHourAndMinute(int hour, int minute) throws Exception {
        timeTo = new Time(hour, minute);
    }

    public void setTimeTo() throws Exception {
        timeFrom = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }
    public void setTimeToByTimeObject(Time inputTimeTo) throws Exception {
        timeFrom = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
    }
    public void setTimeToByHour(int hour) throws Exception {
        timeFrom = new Time(hour);
    }
    public void setTimeToByHourAndMinute(int hour, int minute) throws Exception {
        timeFrom = new Time(hour, minute);
    }


    //---------------------------------------------------------------------------------------------


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
