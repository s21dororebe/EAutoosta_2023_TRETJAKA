package model.extraClasses;

import java.time.LocalDate;

public class Date {
    private int year = 0;
    private int month = 0;
    private int day = 0;

    public int getYear() {
        return year;
    }
    public void setYear(int inputYear) throws Exception {
        if(inputYear > 1900 && inputYear <= LocalDate.now().getYear()){
            year = inputYear;
        } else {
            throw (new Exception("Invalid input year"));
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int inputMonth) throws Exception {
        if(inputMonth > 0 && inputMonth <= 12){
            month = inputMonth;
        } else {
            throw (new Exception("Invalid input month"));
        }
    }

    public int getDay() {
        return day;
    }
    public void setDay(int inputDay) throws Exception {
        if(month == 2){
            if(inputDay > 0 && inputDay <= 28){
                day = inputDay;
            }
        } else if(inputDay > 0 && inputDay <= 31){
            day = inputDay;
        } else {
            throw (new Exception("Invalid input day"));
        }
    }

    public Date() throws Exception {
        setYear(1900);
        setMonth(1);
        setDay(1);
    }

    public Date(int year, int month, int day) throws Exception {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    @Override
    public String toString() {
        String formattedDate;
        if(day < 10)
            formattedDate = "0" + day + "/";
        else
            formattedDate = day + "/";
        if(month < 10)
            formattedDate += "0" + month + "/";
        else
            formattedDate += month + "/";
        formattedDate += year;
        return formattedDate;
    }
}
