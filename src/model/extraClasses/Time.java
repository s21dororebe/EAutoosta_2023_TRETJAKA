package model.extraClasses;

public class Time {
    private int hour = 0;
    private int minute = 0;

    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }

    public void setHour(int inputHour) throws Exception {
        if(inputHour >= 0 && inputHour <= 23){
            hour = inputHour;
        } else {
            throw (new Exception("Invalid input hour"));
        }
    }
    public void setMinute(int inputMinute) throws Exception {
        if(inputMinute >= 0 && inputMinute <= 59){
            minute = inputMinute;
        } else {
            throw (new Exception("Invalid input minute"));
        }
    }

    public Time() throws Exception {
        setHour(0);
        setMinute(0);
    }
    public Time(int hour) throws Exception {
        setHour(hour);
        setMinute(0);
    }
    public Time(int hour, int minute) throws Exception {
        setHour(hour);
        setMinute(minute);
    }

    @Override
    public String toString() {
        //06:05
        String result;
        if(hour < 10){
            result = "0" + hour + ":";
        } else {
            result = hour + ":";
        }
        if(minute < 10){
            result += "0" + minute;
        } else {
            result += minute;
        }
        return result;
    }
}
