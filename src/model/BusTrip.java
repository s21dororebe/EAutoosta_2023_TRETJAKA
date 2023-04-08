package model;

import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class BusTrip {
    private final long generatedId;
    private static long idCounter = 0;
    private Station stationFrom;
    private Station stationTo;
    //TODO test set functions for date and time
    private Date dateFrom; //done ---> need to test
    private Date dateTo; //done ---> need to test
    private Time timeFrom; //done ---> need to test
    private Time timeTo; //done ---> need to test
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


    public void setDateFrom() throws Exception {
        dateFrom = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }
    public void setDateFromByDateObject(Date inputDateFrom) {
        if(inputDateFrom != null){
            if(inputDateFrom.getYear() >= LocalDate.now().getYear() && inputDateFrom.getMonth() >= LocalDate.now().getMonthValue()){
                if(inputDateFrom.getMonth() == LocalDate.now().getMonthValue()){
                    if(inputDateFrom.getDay() >= LocalDate.now().getDayOfMonth()){
                        dateFrom = inputDateFrom;
                    }
                } else {
                    dateFrom = inputDateFrom;
                }
            }
        }
    }
    public void setDateFromByYearMonthDay(int year, int month, int day) throws Exception {
        if(year >= LocalDate.now().getYear() && month >= LocalDate.now().getMonthValue()){
            if(month == LocalDate.now().getMonthValue()){
                if(day >= LocalDate.now().getDayOfMonth()){
                    dateFrom = new Date(year, month, day);
                }
            } else {
                dateFrom = new Date(year, month, day);
            }
        }
    }

    public void setDateTo() throws Exception {
        dateTo = new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }
    public void setDateToByDateObject(Date inputDateTo) {
        if(inputDateTo != null){
            if(inputDateTo.getYear() >= LocalDate.now().getYear() && inputDateTo.getMonth() >= LocalDate.now().getMonthValue()){
                if(inputDateTo.getMonth() == LocalDate.now().getMonthValue()){
                    if(inputDateTo.getDay() >= LocalDate.now().getDayOfMonth()){
                        dateTo = inputDateTo;
                    }
                } else {
                    dateTo = inputDateTo;
                }
            }
        }
    }
    public void setDateToByYearMonthDay(int year, int month, int day) throws Exception {
        if(year >= LocalDate.now().getYear() && month >= LocalDate.now().getMonthValue()){
            if(month == LocalDate.now().getMonthValue()){
                if(day >= LocalDate.now().getDayOfMonth()){
                    dateTo = new Date(year, month, day);
                }
            } else {
                dateTo = new Date(year, month, day);
            }
        }
    }

    public void setTimeFrom() throws Exception {
        timeFrom = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }
    public void setTimeFromByTimeObject(Time inputTimeFrom) throws Exception {
        if(inputTimeFrom != null){
            if(inputTimeFrom.getHour() >= LocalTime.now().getHour()){
                if(inputTimeFrom.getHour() == LocalTime.now().getHour()){
                    if(inputTimeFrom.getMinute() >= LocalTime.now().getMinute()){
                        timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                    }
                } else {
                    timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                }
            }
        }

    }
    public void setTimeFromByHourAndMinute(int hour, int minute) throws Exception {
        if(hour >= LocalTime.now().getHour()){
            if(hour == LocalTime.now().getHour()){
                if(minute >= LocalTime.now().getMinute()){
                    timeFrom = new Time(hour, minute);
                }
            } else {
                timeFrom = new Time(hour, minute);
            }
        }
    }

    public void setTimeTo() throws Exception {
        timeTo = new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }
    public void setTimeToByTimeObject(Time inputTimeTo) throws Exception {
        if(inputTimeTo != null){
            if(inputTimeTo.getHour() >= LocalTime.now().getHour()){
                if(inputTimeTo.getHour() == LocalTime.now().getHour()){
                    if(inputTimeTo.getMinute() >= LocalTime.now().getMinute()){
                        timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
                    }
                } else {
                    timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
                }
            }
        }
    }
    public void setTimeToByHourAndMinute(int hour, int minute) throws Exception {
        if(hour >= LocalTime.now().getHour()){
            if(hour == LocalTime.now().getHour()){
                if(minute >= LocalTime.now().getMinute()){
                    timeTo = new Time(hour, minute);
                }
            } else {
                timeTo = new Time(hour, minute);
            }
        }
    }


    //---------------------------------------------------------------------------------------------


    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public void setDriver(BusDriver driver) {
        this.driver = driver;
    }

    //TODO test constructors and the conditions

    public BusTrip() throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTimeFrom();
        setTimeTo();
        setDateFrom();
        setDateTo();
    }
    public BusTrip(Time timeFrom, Time timeTo, int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByTimeObject(timeFrom);
            setTimeToByTimeObject(timeTo);
            setDateFromByYearMonthDay(yearFrom, monthFrom, dayFrom);
            setDateToByYearMonthDay(yearTo, monthTo, dayTo);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public BusTrip(int hourFrom, int minuteFrom, int hourTo, int minuteTo, Date dateFrom, Date dateTo) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByHourAndMinute(hourFrom, minuteFrom);
            setTimeToByHourAndMinute(hourTo, minuteTo);
            setDateFromByDateObject(dateFrom);
            setDateToByDateObject(dateTo);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public BusTrip(int hourFrom, int minuteFrom, int hourTo, int minuteTo, int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByHourAndMinute(hourFrom, minuteFrom);
            setTimeToByHourAndMinute(hourTo, minuteTo);
            setDateFromByYearMonthDay(yearFrom, monthFrom, dayFrom);
            setDateToByYearMonthDay(yearTo, monthTo, dayTo);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public BusTrip(Time timeFrom, Time timeTo, Date dateFrom, Date dateTo) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByTimeObject(timeFrom);
            setTimeToByTimeObject(timeTo);
            setDateFromByDateObject(dateFrom);
            setDateToByDateObject(dateTo);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }

    public void addTicket(){}
    //tickets <= numberOfSeats
    //VIP tickets are going 1st
    public void changeBusDriver(){}

}
