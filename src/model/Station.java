package model;

import model.enumerators.City;
import model.extraClasses.WorkingTime;

public class Station {
    private City city;
    private String title;
    private WorkingTime workingTime = new WorkingTime();
    private final long generatedId;
    private static long idCounter = 0;

    public City getCity() {
        return city;
    }
    public String getTitle() {
        return title;
    }

    public void setCity(City inputCity) {
        if(inputCity != null){
            city = inputCity;
        }
    }
    public void setTitle(String inputTitle) {
        if(inputTitle.length() > 0 && inputTitle.length() < 30){
            title = inputTitle;
        }
    }

    public WorkingTime getWorkingTime() {
        return workingTime;
    }
    public void setWorkingTimeByWorkingTimeObject(WorkingTime inputWorkingTime) throws Exception {
        workingTime = new WorkingTime(inputWorkingTime.getStartHour(),
                inputWorkingTime.getStartMinute(),
                inputWorkingTime.getEndHour(),
                inputWorkingTime.getEndMinute());
    }
    public void setWorkingTimeByHours(int startHour, int endHour) throws Exception {
        workingTime = new WorkingTime(startHour, endHour);
    }
    public void setWorkingTimeByHoursAndMinutes(int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        workingTime = new WorkingTime(startHour, startMinute, endHour, endMinute);
    }

    public Station() {
        generatedId = idCounter;
        idCounter++;
        setTitle("Unknown");
    }
    public Station(String title, City city, WorkingTime workingTime) throws Exception {
        generatedId = idCounter;
        idCounter++;
        try {
            setTitle(title);
            setCity(city);
            setWorkingTimeByWorkingTimeObject(workingTime);
        } catch (Exception e){
            throw (new Exception("Wrong input data (title/city/working hours)"));
        }
    }
    public Station(String title, City city, int startHour, int endHour) throws Exception {
        generatedId = idCounter;
        idCounter++;
        try {
            setTitle(title);
            setCity(city);
            setWorkingTimeByHours(startHour, endHour);
        } catch (Exception e){
            throw (new Exception("Wrong input data (title/city/working hours)"));
        }
    }
    public Station(String title, City city, int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        generatedId = idCounter;
        idCounter++;
        try {
            setTitle(title);
            setCity(city);
            setWorkingTimeByHoursAndMinutes(startHour, startMinute, endHour, endMinute);
        } catch (Exception e){
            throw (new Exception("Wrong input data (title/city/working hours)"));
        }
    }

    @Override
    public String toString() {
        if(city == null){
            return "" + generatedId + " " + title + ": Unknown, working time: " + workingTime;
        } else return "" + generatedId + " " + title + ": " + city + ", working time: " + workingTime;
    }
}
