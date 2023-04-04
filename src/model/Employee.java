package model;

import java.util.*;

public class Employee extends Person{
    private Date contractDate;
    private String contractNumber = "";

    public Date getContractDate() {
        return contractDate;
    }
    public void setContractDate(int year, int month, int date) {
        if(year < 2023 || month < 3 || date < 24) {
            contractDate = new Date(year, month, date);
        } else {
            contractDate = new Date(2023, 3, 24);
        }
    }

    public String getContractNumber() {
        return contractNumber;
    }
    public void setContractNumber(String name, String surname, int year) {
        contractNumber += Integer.toString(year);
        contractNumber += "_";
        contractNumber += name.charAt(0);
        contractNumber += "_";
        contractNumber += surname.charAt(0);
    }

    public Employee(int yearOfContract, int month, int date, String name, String surname, int year){
        setContractDate(year, month, date);
        setContractNumber(name, surname, year);
    }

    /*i. contractDate - nepieciešams pārbaudīt, vai līguma datums nav pirms 2023. gada 24.marta (1 punkts);
    * ii. contractNumber - līguma numurs, kuru nepieciešams izveidot pēc sekojoša formāta <līgumaGads>_<darbinieka vārda
pirmais burts>_<darbinieka uzvārda pirmais burts>. Piemēram, 2023_K_Š (1 punkts);*/
}
