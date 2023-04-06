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
    public void setWorkingTime(WorkingTime inputWorkingTime) throws Exception {
        workingTime = new WorkingTime(inputWorkingTime.getStartHour(),
                inputWorkingTime.getStartMinute(),
                inputWorkingTime.getEndHour(),
                inputWorkingTime.getEndMinute());
    }
    public void setWorkingTime(int startHour, int endHour) throws Exception {
        workingTime = new WorkingTime(startHour, endHour);
    }
    public void setWorkingTime(int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        workingTime = new WorkingTime(startHour, startMinute, endHour, endMinute);
    }

    public Station() throws Exception {
        generatedId = idCounter;
        idCounter++;
        setTitle("Unknown");
    }
    public Station(String title, City city, WorkingTime workingTime) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTitle(title);
        setCity(city);
        setWorkingTime(workingTime);
    }
    public Station(String title, City city, int startHour, int endHour) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTitle(title);
        setCity(city);
        setWorkingTime(startHour, endHour);
    }
    public Station(String title, City city, int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        generatedId = idCounter;
        idCounter++;

        setTitle(title);
        setCity(city);
        setWorkingTime(startHour, startMinute, endHour, endMinute);
    }

    @Override
    public String toString() {
        if(city == null){
            return "" + generatedId + " " + title + ": Unknown, working time: " + workingTime;
        } else return "" + generatedId + " " + title + ": " + city + ", working time: " + workingTime;
    }
}
