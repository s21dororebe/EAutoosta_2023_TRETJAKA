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

    public void setCity(City inputCity) throws Exception {
        if(inputCity != null){
            city = inputCity;
        } else throw (new Exception("Invalid input city"));
    }
    public void setTitle(String inputTitle) throws Exception {
        if(inputTitle.length() > 0 && inputTitle.length() < 30){
            title = inputTitle;
        } else throw (new Exception("Invalid input title"));
    }

    public WorkingTime getWorkingTime() {
        return workingTime;
    }
    public void setWorkingTimeByWorkingTimeObject(WorkingTime inputWorkingTime) throws Exception {
        if(inputWorkingTime != null){
            if(inputWorkingTime.getStartHour() < inputWorkingTime.getEndHour()){
                workingTime = new WorkingTime(inputWorkingTime.getStartHour(),
                        inputWorkingTime.getStartMinute(),
                        inputWorkingTime.getEndHour(),
                        inputWorkingTime.getEndMinute());
            } else throw (new Exception("Invalid input hours"));
        } else throw (new Exception("Invalid input working time"));
    }
    public void setWorkingTimeByHours(int startHour, int endHour) throws Exception {
        setWorkingTimeByWorkingTimeObject(new WorkingTime(startHour, endHour));
    }
    public void setWorkingTimeByHoursAndMinutes(int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        setWorkingTimeByWorkingTimeObject(new WorkingTime(startHour, startMinute, endHour, endMinute));
    }

    public Station() throws Exception {
        generatedId = idCounter;
        idCounter++;
        setTitle("Unknown");
        setWorkingTimeByWorkingTimeObject(new WorkingTime(0, 0, 23, 59));
    }
    public Station(String title, City city, WorkingTime workingTime) throws Exception {
        generatedId = idCounter;
        idCounter++;
        setTitle(title);
        setCity(city);
        setWorkingTimeByWorkingTimeObject(workingTime);
    }
    public Station(String title, City city, int startHour, int endHour) throws Exception {
        generatedId = idCounter;
        idCounter++;
        setTitle(title);
        setCity(city);
        setWorkingTimeByHours(startHour, endHour);
    }
    public Station(String title, City city, int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        generatedId = idCounter;
        idCounter++;
        setTitle(title);
        setCity(city);
        setWorkingTimeByHoursAndMinutes(startHour, startMinute, endHour, endMinute);
    }

    @Override
    public String toString() {
        if(city == null){
            return "" + generatedId + " " + title + ": Unknown, working time: " + workingTime;
        } else return "" + generatedId + " " + title + ": " + city + ", working time: " + workingTime;
    }
}
