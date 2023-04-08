package model;

import model.enumerators.BusCategory;
import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class BusTrip {
    private final long generatedId;
    private static long idCounter = 0;
    private Station stationFrom; //done ---> need to test
    private Station stationTo; //done ---> need to test
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

    public void setStations(Station inputStationFrom, Station inputStationTo) {
        if(inputStationFrom != null && inputStationTo != null){
            if(inputStationFrom != inputStationTo){
                stationFrom = inputStationFrom;
                stationTo = inputStationTo;
            }
        }
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

    public void setTimeFromByTimeObject(Time inputTimeFrom) throws Exception {
        if(inputTimeFrom != null){
            if(dateFrom.getYear() == LocalDate.now().getYear()
            && dateFrom.getMonth() == LocalDate.now().getMonthValue()
            && dateFrom.getDay() == LocalDate.now().getDayOfMonth()){
                if(inputTimeFrom.getHour() >= LocalTime.now().getHour()){
                    if(inputTimeFrom.getHour() == LocalTime.now().getHour()){
                        if(inputTimeFrom.getMinute() >= LocalTime.now().getMinute()){
                            timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                        }
                    } else {
                        timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                    }
                }
            } else {
                timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
            }
        }
    }
    public void setTimeFromByHourAndMinute(int hour, int minute) throws Exception {
        if(hour >= LocalTime.now().getHour()){
            if(dateFrom.getYear() == LocalDate.now().getYear()
                    && dateFrom.getMonth() == LocalDate.now().getMonthValue()
                    && dateFrom.getDay() == LocalDate.now().getDayOfMonth()){
                if(hour == LocalTime.now().getHour()){
                    if(minute >= LocalTime.now().getMinute()){
                        timeFrom = new Time(hour, minute);
                    }
                } else {
                    timeFrom = new Time(hour, minute);
                }
            } else {
                timeFrom = new Time(hour, minute);
            }
        }
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


    public void setNumberOfSeats(int inputNumberOfSeats) {
        if(inputNumberOfSeats > 0 && inputNumberOfSeats <= 60)
            numberOfSeats = inputNumberOfSeats;
    }
    public void setDriver(BusDriver inputDriver) {
        if(inputDriver != null){
            if(numberOfSeats < 30){
                for(BusCategory temp : driver.getDriveCategories()){
                    if(temp.equals(BusCategory.minibus) || temp.equals(BusCategory.largebus)){
                        driver = inputDriver;
                    }
                }
            } else if (numberOfSeats >= 30){
                for(BusCategory temp : driver.getDriveCategories()){
                    if(temp.equals(BusCategory.largebus)){
                        driver = inputDriver;
                    }
                }
            }
        }
    }

    //TODO test constructors and the conditions
    //TODO test Station input

    public BusTrip(Time timeFrom, Time timeTo, int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByTimeObject(timeFrom);
            setTimeToByTimeObject(timeTo);
            setDateFromByYearMonthDay(yearFrom, monthFrom, dayFrom);
            setDateToByYearMonthDay(yearTo, monthTo, dayTo);
            setStations(inputStationFrom, inputStationTo);
            setNumberOfSeats(inputNumberOfSeats);
            setDriver(inputDriver);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public BusTrip(int hourFrom, int minuteFrom, int hourTo, int minuteTo, Date dateFrom, Date dateTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByHourAndMinute(hourFrom, minuteFrom);
            setTimeToByHourAndMinute(hourTo, minuteTo);
            setDateFromByDateObject(dateFrom);
            setDateToByDateObject(dateTo);
            setStations(inputStationFrom, inputStationTo);
            setNumberOfSeats(inputNumberOfSeats);
            setDriver(inputDriver);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public BusTrip(int hourFrom, int minuteFrom, int hourTo, int minuteTo, int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByHourAndMinute(hourFrom, minuteFrom);
            setTimeToByHourAndMinute(hourTo, minuteTo);
            setDateFromByYearMonthDay(yearFrom, monthFrom, dayFrom);
            setDateToByYearMonthDay(yearTo, monthTo, dayTo);
            setStations(inputStationFrom, inputStationTo);
            setNumberOfSeats(inputNumberOfSeats);
            setDriver(inputDriver);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }
    public BusTrip(Time timeFrom, Time timeTo, Date dateFrom, Date dateTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        try {
            setTimeFromByTimeObject(timeFrom);
            setTimeToByTimeObject(timeTo);
            setDateFromByDateObject(dateFrom);
            setDateToByDateObject(dateTo);
            setStations(inputStationFrom, inputStationTo);
            setNumberOfSeats(inputNumberOfSeats);
            setDriver(inputDriver);
        } catch(Exception e) {
            throw (new Exception("Invalid input data"));
        }
    }

    public void addTicket(){

    }
    //tickets <= numberOfSeats
    //VIP tickets are going 1st
    public void changeBusDriver(){}

}
