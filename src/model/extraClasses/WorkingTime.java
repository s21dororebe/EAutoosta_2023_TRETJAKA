package model.extraClasses;

public class WorkingTime {
    private int startHour = 0;
    private int endHour = 0;
    private int startMinute = 0;
    private int endMinute = 0;

    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
    public int getStartMinute() {
        return startMinute;
    }
    public int getEndMinute() {
        return endMinute;
    }

    public void setStartHour(int inputStartHour) {
        if(inputStartHour >= 0 && inputStartHour <= 23){
            startHour = inputStartHour;
        }
    }
    public void setEndHour(int inputEndHour) {
        if(inputEndHour >= 0 && inputEndHour <= 23){
            endHour = inputEndHour;
        }
    }
    public void setStartMinute(int inputStartMinute) {
        if(inputStartMinute >= 0 && inputStartMinute <= 59){
            startMinute = inputStartMinute;
        }
    }
    public void setEndMinute(int inputEndMinute) {
        if(inputEndMinute >= 0 && inputEndMinute <= 59){
            endMinute = inputEndMinute;
        }
    }

    public WorkingTime() {
        setStartHour(0);
        setEndHour(0);
        setStartMinute(0);
        setEndMinute(0);
    }
    public WorkingTime(int startHour, int endHour) throws Exception {
        try {
            setStartHour(startHour);
            setEndHour(endHour);
        } catch (Exception e){
            throw (new Exception("Wrong input start and/or end hour/-s"));
        }
        setStartMinute(0);
        setEndMinute(0);
    }
    public WorkingTime(int startHour, int startMinute, int endHour, int endMinute) throws Exception {
        try {
            setStartHour(startHour);
            setStartMinute(startMinute);
            setEndHour(endHour);
            setEndMinute(endMinute);
        } catch (Exception e){
            throw (new Exception("Wrong input data (hour/-s or/and minutes)"));
        }
    }

    @Override
    public String toString() {
        //06:05-16:10
        String result;
        if(startHour < 10){
            result = "0" + startHour + ":";
        } else {
            result = startHour + ":";
        }
        if(startMinute < 10){
            result += "0" + startMinute + " - ";
        } else {
            result += startMinute + " - ";
        }
        if(endHour < 10){
            result += "0" + endHour + ":";
        } else {
            result += endHour + ":";
        }
        if(endMinute < 10){
            result += "0" + endMinute;
        } else {
            result += endMinute;
        }

        return result;
    }
}
