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
        if(2023 <= year){
            //==
            if(2023 == year){
                if(3 < month){
                    contractDate = new Date(year, month, day);
                } else if (3 == month){
                    if(24 <= day){
                        contractDate = new Date(year, month, day);
                    }
                    else throw (new Exception("Wrong input contract day"));
                } else throw (new Exception("Wrong input contract month"));
            } else contractDate = new Date(year, month, day); //>
        }
        else throw (new Exception("Wrong input contract year"));
    }

    public String getContractNumber() {
        return contractNumber;
    }
    public void setContractNumber(String name, String surname) throws Exception {
        if(name != null && surname != null){
            contractNumber += Integer.toString(contractDate.getYear());
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
        setContractDate(yearOfContract, monthOfContract, dateOfContract);
        setContractNumber(name, surname);
    }
    public Employee(Person personData, int yearOfContract, int monthOfContract, int dateOfContract) throws Exception {
        super(personData.getName(), personData.getSurname(), personData.getPersonCode());
        setContractDate(yearOfContract, monthOfContract, dateOfContract);
        setContractNumber(personData.getName(), personData.getSurname());
    }

    public String toString() {
        return super.toString() + ", " + contractNumber + ", " + contractDate;
    }
}
