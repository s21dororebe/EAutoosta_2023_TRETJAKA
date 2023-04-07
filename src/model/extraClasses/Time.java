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

    public void setHour(int inputHour) {
        if(inputHour >= 0 && inputHour <= 23){
            hour = inputHour;
        }
    }
    public void setMinute(int inputMinute) {
        if(inputMinute >= 0 && inputMinute <= 59){
            minute = inputMinute;
        }
    }

    public Time() {
        setHour(0);
        setMinute(0);
    }
    public Time(int hour) throws Exception {
        try {
            setHour(hour);
        } catch (Exception e){
            throw (new Exception("Wrong input hour"));
        }
        setMinute(0);
    }
    public Time(int hour, int minute) throws Exception {
        try {
            setHour(hour);
            setMinute(minute);
        } catch (Exception e){
            throw (new Exception("Wrong input hour and minute"));
        }
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
