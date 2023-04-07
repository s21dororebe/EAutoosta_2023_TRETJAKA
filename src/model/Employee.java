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
                else throw (new Exception("Wrong data"));
            }
            else throw (new Exception("Wrong data"));
        }
        else throw (new Exception("Wrong data"));

    }

    public String getContractNumber() {
        return contractNumber;
    }
    public void setContractNumber(String name, String surname) {
        int year = LocalDate.now().getYear();
        contractNumber += Integer.toString(year);
        contractNumber += "_";
        contractNumber += name.charAt(0);
        contractNumber += "_";
        contractNumber += surname.charAt(0);
    }

    public Employee() throws Exception {
        super();
        setContractNumber("Unknown", "Unknown");
        setContractDate(2023, 3, 24);
    }
    public Employee(String name, String surname, String personCode, int yearOfContract, int monthOfContract, int dateOfContract) throws Exception {
        super(name, surname, personCode);
        try {
            setContractNumber(name, surname);
        } catch (Exception e){
            throw (new Exception ("Wrong name and/or surname"));
        }
        setContractNumber(name, surname);
        try {
            setContractDate(yearOfContract, monthOfContract, dateOfContract);
        } catch (Exception e){
            throw (new Exception ("Wrong data (year/month/day)"));
        }
    }
    public Employee(Person personData, int yearOfContract, int monthOfContract, int dateOfContract) throws Exception {
        super(personData.getName(),
                personData.getSurname(),
                personData.getPersonCode());
        try {
            setContractNumber(personData.getName(), personData.getSurname());
        } catch (Exception e){
            throw (new Exception ("Wrong name and/or surname"));
        }
        try {
            setContractDate(yearOfContract, monthOfContract, dateOfContract);
        } catch (Exception e){
            throw (new Exception ("Wrong data (year/month/day)"));
        }
    }

    public String toString() {
        return super.toString() + ", " + contractNumber + ", " + contractDate;
    }
}
