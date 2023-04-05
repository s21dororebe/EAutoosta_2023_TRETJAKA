package model;

import model.enumerators.BusCategory;

import java.util.ArrayList;

public class BusDriver extends Employee {
    private final ArrayList<BusCategory> driveCategories = new ArrayList<>();
    private int expYears = 0;

    public ArrayList<BusCategory> getDriveCategories() {
        return driveCategories;
    }

    public int getExpYears() {
        return expYears;
    }
    public void setExpYears(int inputExpYears) {
        if(inputExpYears >= 0){
            expYears = inputExpYears;
        }
    }

    public BusDriver() throws Exception {
    }
    public BusDriver(String name, String surname, String personCode, int yearOfContract, int monthOfContract, int dateOfContract, int inputExpYears) throws Exception {
        super(name, surname, personCode, yearOfContract, monthOfContract, dateOfContract);
        setExpYears(inputExpYears);
    }
    public BusDriver(Person personData, int yearOfContract, int monthOfContract, int dateOfContract, int inputExpYears) throws Exception {
        super(personData, yearOfContract, monthOfContract, dateOfContract);
        setExpYears(inputExpYears);
    }
    public BusDriver(Employee employerData, int inputExpYears) throws Exception {
        super(employerData.getName(), employerData.getSurname(), employerData.getPersonCode(), employerData.getContractDate().getYear(), employerData.getContractDate().getMonth(), employerData.getContractDate().getDay());
        setExpYears(inputExpYears);
    }

    public void addCategory(BusCategory category) throws Exception {
        for(BusCategory temp : driveCategories){
            if(category == temp){
                throw (new Exception("This category already exists"));
            }
        }
        driveCategories.add(category);
    }
    public void removeCategory(BusCategory category) throws Exception {
        boolean indicator = false;
        for (BusCategory temp : driveCategories) {
            if (category == temp) {
                driveCategories.remove(category);
                indicator = true;
                break;
            }
        }
        if(!indicator)
            throw (new Exception("This category does not exist in this array"));
    }

    @Override
    public String toString() {
        if(driveCategories.size() > 0){
            return super.toString() + ", experience: " + expYears + " years, categories: " + driveCategories;
        } else {
            return super.toString() + ", experience: " + expYears + " years";
        }
    }
}
