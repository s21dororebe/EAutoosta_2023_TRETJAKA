package services;

import model.Cashier;
import model.Employee;
import model.Person;

import java.util.ArrayList;

/*
* @info Cashier class
* b. CRUD darbības ar kasieri jeb Cashier objektiem (neaizmirstam par pārbaudēm) (15 punkti - par katru 3 punkti):
* i. Pievienot jaunu kaseiri;
* ii. Atrast kasieri, ja zināms tā personas kods;
* iii. Rediģēt kasiera datus, ja ir zināms tā personas kods;
* iv. Dzēst kasieri, ja ir zināms tā personas kods;
* v. Atrast visus kasierus.
* */

public class MainServiceB {
    public static void main(String[] args) {
        try {
            System.out.println("Creating:");
            Cashier cashier1 = new Cashier("Augustus", "Hayes", "200591-21456", 2024, 1, 1);
            ArrayList<Cashier> cashierList = new ArrayList<>();
            System.out.println(cashier1);
            cashierList.add(cashier1);
            System.out.println();

            Person person = new Person("Aiden", "Blackwell", "123456-12345");
            Employee employee = new Employee("Emeryn", "Marshall", "112233-36936", 2023, 9, 12);

            Cashier cashier2 = new Cashier(person, 2024, 1, 1);
            Cashier cashier3 = new Cashier(employee);
            Cashier cashier4 = new Cashier("Felix", "Patterson", "232323-11223", 2024, 4, 14);
            Cashier cashier5 = new Cashier("Nevaeh", "Chen", "212121-30330", 2024, 5, 15);
            cashierList.add(cashier2);
            cashierList.add(cashier3);
            cashierList.add(cashier4);
            cashierList.add(cashier5);

            System.out.println("Finding cashier by person code:");
            System.out.println("Person code - 212121-30330");
            for(Cashier temp : cashierList){
                if(temp.getPersonCode().equals("212121-30330")){
                    System.out.println("FOUND, this is " + temp);
                }
            }
            System.out.println();

            System.out.println("Editing cashier data by person code:");
            System.out.println("Person code - 232323-11223");
            for(Cashier temp : cashierList){
                if(temp.getPersonCode().equals("232323-11223")){
                    System.out.println("FOUND, this is " + temp + " ==> let's rename this person, now :");
                    temp.setName("Peter");
                    System.out.println(temp);
                }
            }
            System.out.println();

            System.out.println("Deleting cashier by person code:");
            System.out.println("Cashier list before:");
            for(Cashier temp : cashierList)
                System.out.println(temp);
            System.out.println("Person code - 112233-36936");
            for(Cashier temp : cashierList){
                if(temp.getPersonCode().equals("112233-36936")){
                    System.out.println("FOUND, this is " + temp + " ==> let's delete this person");
                    cashierList.remove(temp);
                    temp = null;
                    break;
                }
            }
            System.out.println("Cashier list now:");
            for(Cashier temp : cashierList)
                System.out.println(temp);
            System.out.println();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
