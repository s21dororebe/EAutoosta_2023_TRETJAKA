package model;

import model.extraClasses.Date;

import java.time.LocalDate;

public class Employee extends Person{
    private Date contractDate = new Date(2023, 3, 24);
    private String contractNumber = "";

    public Date getContractDate() {
        return contractDate;
    }
    public void setContractDate(int year, int month, int day) throws Exception {
        if(contractDate.getYear() <= year){
            if(contractDate.getMonth() < month){
                contractDate = new Date(year, month, day);
            } else if (contractDate.getMonth() == month){
                if(contractDate.getDay() <= day){
                    contractDate = new Date(year, month, day);
                }
                else throw (new Exception("Wrong input contract day"));
            }
            else throw (new Exception("Wrong input contract month"));
        }
        else throw (new Exception("Wrong input contract year"));
    }

    public String getContractNumber() {
        return contractNumber;
    }
    public void setContractNumber(String name, String surname) throws Exception {
        if(name != null && surname != null){
            int year = LocalDate.now().getYear();
            contractNumber += Integer.toString(year);
            contractNumber += "_";
            contractNumber += name.charAt(0);
            contractNumber += "_";
            contractNumber += surname.charAt(0);
        } else throw (new Exception("Wrong input name or/and surname"));
    }

    public Employee() throws Exception {
        super();
        setContractNumber("Unknown", "Unknown");
        setContractDate(2023, 3, 24);
    }
    public Employee(String name, String surname, String personCode, int yearOfContract, int monthOfContract, int dateOfContract) throws Exception {
        super(name, surname, personCode);
        setContractNumber(name, surname);
        setContractDate(yearOfContract, monthOfContract, dateOfContract);
    }
    public Employee(Person personData, int yearOfContract, int monthOfContract, int dateOfContract) throws Exception {
        super(personData.getName(), personData.getSurname(), personData.getPersonCode());
        setContractNumber(personData.getName(), personData.getSurname());
        setContractDate(yearOfContract, monthOfContract, dateOfContract);
    }

    public String toString() {
        return super.toString() + ", " + contractNumber + ", " + contractDate;
    }
}
