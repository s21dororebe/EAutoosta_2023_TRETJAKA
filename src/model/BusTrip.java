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
    private Station stationFrom;
    private Station stationTo;
    private Date dateFrom;
    private Date dateTo;
    private Time timeFrom;
    private Time timeTo;
    private int numberOfSeats = 0;
    private BusDriver driver;

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

    public void setStations(Station inputStationFrom, Station inputStationTo) throws Exception {
        if(inputStationFrom != null && inputStationTo != null){
            if(inputStationFrom != inputStationTo){
                stationFrom = inputStationFrom;
                stationTo = inputStationTo;
            } else throw (new Exception("Input stations are the same"));
        } else {
            throw (new Exception("Invalid input Station data"));
        }
    }
    public void setDatesByDateObject(Date inputDateFrom, Date inputDateTo) throws Exception {
        if(inputDateFrom != null && inputDateTo != null){
            if(inputDateFrom.getYear() >= LocalDate.now().getYear() && inputDateFrom.getMonth() >= LocalDate.now().getMonthValue()){
                if(inputDateFrom.getMonth() == LocalDate.now().getMonthValue()){
                    if(inputDateFrom.getDay() >= LocalDate.now().getDayOfMonth()){
                        dateFrom = inputDateFrom;
                    }
                } else {
                    dateFrom = inputDateFrom;
                }
            } else {
                throw (new Exception("Invalid input date from"));
            }
            if(inputDateTo.getYear() >= LocalDate.now().getYear() && inputDateTo.getMonth() >= LocalDate.now().getMonthValue()){
                if(inputDateTo.getMonth() == LocalDate.now().getMonthValue()){
                    if(inputDateTo.getDay() >= LocalDate.now().getDayOfMonth()){
                        dateTo = inputDateTo;
                    }
                } else {
                    dateTo = inputDateTo;
                }
            } else {
                throw (new Exception("Invalid input date from"));
            }
        }
    }
    public void setDatesByYearMonthDay(int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo) throws Exception {
        setDatesByDateObject(new Date(yearFrom, monthFrom, dayFrom), new Date(yearTo, monthTo, dayTo));
    }

    public void setTimesByTimeObject(Time inputTimeFrom, Time inputTimeTo) throws Exception {
        if(inputTimeFrom != null && inputTimeTo != null){
            //1. if datefrom is today and further
            //1.1. if datefrom is today
            //1.1.2. check if the input time is now and further
            //1.1.2.1. set the time from
            //1.2. else set the time
            //2. else throw exception

            //3. if dateto is >= datefrom
            //3.1. if dateto == datefrom
            //3.1.1. if input timeto > timefrom
            //3.1.1.1. set the time to
            //3.1.2. else throw exception
            //3.2. else set the timeto
            //4. else throw exception

            if(dateFrom.getYear() >= LocalDate.now().getYear()
                    && dateFrom.getMonth() >= LocalDate.now().getMonthValue()
                    && dateFrom.getDay() >= LocalDate.now().getDayOfMonth()){
                if(dateFrom.getYear() == LocalDate.now().getYear()
                        && dateFrom.getMonth() == LocalDate.now().getMonthValue()
                        && dateFrom.getDay() == LocalDate.now().getDayOfMonth()){
                    if(inputTimeFrom.getHour() >= LocalTime.now().getHour()){
                        if(inputTimeFrom.getHour() == LocalTime.now().getHour()){
                            if(inputTimeFrom.getMinute() > LocalTime.now().getMinute()){
                                timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                            }
                        } else {
                            timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                        }
                    } else throw (new Exception("Invalid input time from"));
                } else {
                    timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                }
            } else throw (new Exception("Invalid input time from"));

            if(dateTo.getYear() >= dateFrom.getYear()
                    && dateTo.getMonth() >= dateFrom.getMonth()
                    && dateTo.getDay() >= dateFrom.getDay()){
                if(dateTo.getYear() == dateFrom.getYear()
                        && dateTo.getMonth() == dateFrom.getMonth()
                        && dateTo.getDay() == dateFrom.getDay()){
                    if(inputTimeTo.getHour() > inputTimeFrom.getHour()){
                        timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
                    } else throw (new Exception("Invalid input time to"));
                } else timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
            } else throw (new Exception("Invalid input time to"));
        } else {
            throw (new Exception("Invalid input Time objects"));
        }
    }

    public void setTimesByHourAndMinute(int hourFrom, int minuteFrom, int hourTo, int minuteTo) throws Exception {
        setTimesByTimeObject(new Time(hourFrom, minuteFrom), new Time(hourTo, minuteTo));
    }

    public void setNumberOfSeats(int inputNumberOfSeats) throws Exception {
        if(inputNumberOfSeats > 0 && inputNumberOfSeats <= 60)
            numberOfSeats = inputNumberOfSeats;
        else
            throw (new Exception("Invalid input number of seats"));
    }
    public void setDriver(BusDriver inputDriver) throws Exception {
        if(inputDriver != null){
            if(numberOfSeats < 30){
                for(BusCategory temp : inputDriver.getDriveCategories()){
                    if(temp.equals(BusCategory.minibus) || temp.equals(BusCategory.largebus)){
                        driver = inputDriver;
                        break;
                    }
                }
            } else if (numberOfSeats >= 30){
                for(BusCategory temp : inputDriver.getDriveCategories()){
                    if(temp.equals(BusCategory.largebus)){
                        driver = inputDriver;
                        break;
                    }
                }
            }
        } else {
            throw (new Exception("Invalid input driver data"));
        }
    }

    public BusTrip(Time timeFrom, Time timeTo, int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setDatesByYearMonthDay(yearFrom, monthFrom, dayFrom, yearTo, monthTo, dayTo);
        setTimesByTimeObject(timeFrom, timeTo);
        setStations(inputStationFrom, inputStationTo);
        setNumberOfSeats(inputNumberOfSeats);
        setDriver(inputDriver);
    }
    public BusTrip(int hourFrom, int minuteFrom, int hourTo, int minuteTo, Date dateFrom, Date dateTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setDatesByDateObject(dateFrom, dateTo);
        setTimesByHourAndMinute(hourFrom, minuteFrom, hourTo, minuteTo);
        setStations(inputStationFrom, inputStationTo);
        setNumberOfSeats(inputNumberOfSeats);
        setDriver(inputDriver);
    }
    public BusTrip(int hourFrom, int minuteFrom, int hourTo, int minuteTo, int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setDatesByYearMonthDay(yearFrom, monthFrom, dayFrom, yearTo, monthTo, dayTo);
        setTimesByHourAndMinute(hourFrom, minuteFrom, hourTo, minuteTo);
        setStations(inputStationFrom, inputStationTo);
        setNumberOfSeats(inputNumberOfSeats);
        setDriver(inputDriver);
    }
    public BusTrip(Time timeFrom, Time timeTo, Date dateFrom, Date dateTo, Station inputStationFrom, Station inputStationTo, int inputNumberOfSeats, BusDriver inputDriver) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setDatesByDateObject(dateFrom, dateTo);
        setTimesByTimeObject(timeFrom, timeTo);
        setStations(inputStationFrom, inputStationTo);
        setNumberOfSeats(inputNumberOfSeats);
        setDriver(inputDriver);
    }

    @Override
    public String toString() {
        return "BusTrip " + generatedId +
                ", stationFrom: " + stationFrom.getCity() +
                ", stationTo: " + stationTo.getCity() +
                ", dates: " + dateFrom +
                " --- " + dateTo +
                ", time: " + timeFrom +
                " --- " + timeTo +
                ", n.OfSeats: " + numberOfSeats +
                ", driver: " + driver;
    }

    public void addTicket(){

    }
    //tickets <= numberOfSeats
    //VIP tickets are going 1st
    public void changeBusDriver(){}

}
