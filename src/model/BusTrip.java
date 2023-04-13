package model;

import model.enumerators.BusCategory;
import model.extraClasses.Date;
import model.extraClasses.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
    private final Deque<Ticket> allTickets = new ArrayDeque<>();

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
    public Deque getAllTickets() {
        return allTickets;
    }

    public void setStations(Station inputStationFrom, Station inputStationTo) throws Exception {
        if(inputStationFrom != null && inputStationTo != null){
            if(inputStationFrom.getCity() != inputStationTo.getCity()){
                stationFrom = inputStationFrom;
                stationTo = inputStationTo;
            } else throw (new Exception("Input stations are the same"));
        } else {
            throw (new Exception("Invalid input Station data"));
        }
    }
    public void setDatesByDateObject(Date inputDateFrom, Date inputDateTo) throws Exception {
        if(inputDateFrom != null && inputDateTo != null){
            if(inputDateFrom.getYear() >= LocalDate.now().getYear()){
                if(inputDateFrom.getYear() == LocalDate.now().getYear()){
                    if(inputDateFrom.getMonth() >= LocalDate.now().getMonthValue()){
                        if(inputDateFrom.getMonth() == LocalDate.now().getMonthValue()){
                            if(inputDateFrom.getDay() >= LocalDate.now().getDayOfMonth()){
                                dateFrom = inputDateFrom;
                            } else throw (new Exception("Invalid input day from"));
                        } else dateFrom = inputDateFrom;
                    } else throw (new Exception("Invalid input month from"));
                } else dateFrom = inputDateFrom;
            } else throw (new Exception("Invalid input year from"));

            if(inputDateTo.getYear() >= dateFrom.getYear()){
                if(inputDateTo.getMonth() >= dateFrom.getMonth()){
                    if(inputDateTo.getDay() >= dateFrom.getDay()){
                        dateTo = inputDateTo;
                    } else throw (new Exception("Invalid input day to"));
                } else throw (new Exception("Invalid input month to"));
            } else throw (new Exception("Invalid input year to"));
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

            if(dateFrom.getYear() >= LocalDate.now().getYear()){
                //==
                if(dateFrom.getYear() == LocalDate.now().getYear()){
                    if(dateFrom.getMonth() >= LocalDate.now().getMonthValue()){
                        //==
                        if(dateFrom.getMonth() == LocalDate.now().getMonthValue()){
                            if(dateFrom.getDay() >= LocalDate.now().getDayOfMonth()){
                                //==
                                if(dateFrom.getDay() == LocalDate.now().getDayOfMonth()){
                                    if(inputTimeFrom.getHour() >= LocalTime.now().getHour()){
                                        if(inputTimeFrom.getHour() == LocalTime.now().getHour()){
                                            if(inputTimeFrom.getMinute() > LocalTime.now().getMinute()){
                                                timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                                            }
                                        } else {
                                            timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                                        }
                                    } else throw (new Exception("Invalid input hour from"));
                                } else timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute());
                            } else throw (new Exception("Invalid input day from"));
                        } else timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute()); // >
                    } else throw (new Exception("Invalid input month from"));
                } else timeFrom = new Time(inputTimeFrom.getHour(), inputTimeFrom.getMinute()); // >
            } else throw (new Exception("Invalid input year from"));
//---------------------------------------------------------------------------------------------------------------------------------
            if(dateTo.getYear() >= dateFrom.getYear()){
                //==
                if(dateTo.getYear() == dateFrom.getYear()){
                    if(dateTo.getMonth() >= dateFrom.getMonth()){
                        //==
                        if(dateTo.getMonth() == dateFrom.getMonth()){
                            if(dateTo.getDay() >= dateFrom.getDay()){
                                //==
                                if(dateTo.getDay() == dateFrom.getDay()){
                                    if(inputTimeTo.getHour() >= timeFrom.getHour()){
                                        if(inputTimeTo.getHour() == timeFrom.getHour()){
                                            if(inputTimeTo.getMinute() > timeFrom.getMinute()){
                                                timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
                                            }
                                        } else {
                                            timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
                                        }
                                    } else throw (new Exception("Invalid input hour to"));
                                } else timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute());
                            } else throw (new Exception("Invalid input day to"));
                        } else timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute()); // >
                    } else throw (new Exception("Invalid input month to"));
                } else timeTo = new Time(inputTimeTo.getHour(), inputTimeTo.getMinute()); // >
            } else throw (new Exception("Invalid input year to"));

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
            } else {
                for(BusCategory temp : inputDriver.getDriveCategories()){
                    if(temp.equals(BusCategory.largebus)){
                        driver = inputDriver;
                        break;
                    }
                }
            }
            if(driver == null)
                throw (new Exception("Invalid input driver data (wrong drive category)"));
        } else {
            throw (new Exception("Invalid input driver data"));
        }
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
        if(allTickets.isEmpty()){
            return "BusTrip " + generatedId +
                    ", stationFrom: " + stationFrom.getCity() +
                    ", stationTo: " + stationTo.getCity() +
                    ", dates: " + dateFrom +
                    " --- " + dateTo +
                    ", time: " + timeFrom +
                    " --- " + timeTo +
                    ", n.OfSeats: " + numberOfSeats +
                    ", driver: " + driver.getName() + " " + driver.getSurname();
        }
        else return "BusTrip " + generatedId +
                ", stationFrom: " + stationFrom.getCity() +
                ", stationTo: " + stationTo.getCity() +
                ", dates: " + dateFrom +
                " --- " + dateTo +
                ", time: " + timeFrom +
                " --- " + timeTo +
                ", n.OfSeats: " + numberOfSeats +
                ", driver: " + driver.getName() + " " + driver.getSurname() + ", tickets: " + allTickets;
    }

    public void printShortInfo() {
        if(allTickets.isEmpty()){
             System.out.println("BusTrip " + generatedId +
                    ", stationFrom: " + stationFrom.getCity() +
                    ", stationTo: " + stationTo.getCity() +
                    ", dates: " + dateFrom +
                    " --- " + dateTo +
                    ", time: " + timeFrom +
                    " --- " + timeTo +
                    ", n.OfSeats: " + numberOfSeats +
                    ", driver: " + driver.getName() + " " + driver.getSurname());
        }
        else{
            System.out.println("BusTrip " + generatedId +
                    ", stationFrom: " + stationFrom.getCity() +
                    ", stationTo: " + stationTo.getCity() +
                    ", dates: " + dateFrom +
                    " --- " + dateTo +
                    ", time: " + timeFrom +
                    " --- " + timeTo +
                    ", n.OfSeats: " + numberOfSeats +
                    ", driver: " + driver.getName() + " " + driver.getSurname() + ", tickets: ");
            for(Ticket temp : allTickets){
                System.out.println("Ticket " + temp.getGeneratedId() + ": " + temp.getTicketPurchaseDate() + " "
                        + temp.getTicketPurchaseTime() + ", is the ticket a VIP: " + temp.isVIP());
            }
        }
    }

    public void addTicket(Ticket ticketData) throws Exception {
        //1. if there is space
        //1.2. check if this ticket already exist
        //1.2.1. if yes throw exception
        //1.2.2. if no check VIP
        //1.2.2.1. if VIP add ticket in the front
        //1.2.2.1. if not VIP add ticket in the end
        //2. if there is no space throw exception

        if(numberOfSeats >= allTickets.size()){
            for(Ticket temp : allTickets){
                if(temp.equals(ticketData)){
                    throw (new Exception("This ticket already exists"));
                }
            }
            if(ticketData.isVIP())
                allTickets.addFirst(ticketData);
            else if(!ticketData.isVIP())
                allTickets.addLast(ticketData);
            else throw (new Exception("Invalid isVip"));
        } else throw (new Exception("The ticket list is full - the bus is full"));
    }

    public void changeBusDriver(BusDriver inputDriver) throws Exception {
        setDriver(inputDriver);
    }

}
