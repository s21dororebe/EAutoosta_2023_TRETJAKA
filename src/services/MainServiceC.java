package services;

import model.BusDriver;
import model.Employee;
import model.Person;
import model.enumerators.BusCategory;

import java.util.ArrayList;

/*
 * @info BusDriver class
 * Darbības ar autobusa vadītāju jeb BusDriver objektiem (12 punkti - par katru 3 punkti):
 * i. Pievienot jaunu autobusa vadītāju;
 * ii. Atrast visus autobusa vadītajus, kas atbilst noteiktai kategorijai;
 * iii. Papildināt autobusa vadītaja kategorijas sarakstu, ja ir zināms autobusa vadītāja personas kods;
 * iv. Atrast visus autobusa vadītājus;
 * */

public class MainServiceC {
    public static void main(String[] args) {
        try {
            Person person = new Person("John", "Washington", "123564-25698");
            Employee e2 = new Employee("March", "Summer", "123456-78963", 2025, 4, 9);
            Employee e3 = new Employee(person, 2023, 3, 28);

            System.out.println("Creating:");
            BusDriver busDriver1 = new BusDriver(e2, 5);
            System.out.println(busDriver1);

            ArrayList<BusDriver> busDriverList = new ArrayList<>();
            BusDriver busDriver2 = new BusDriver(e3, 10);

            BusDriver busDriver3 = new BusDriver("Ethan", "Reynolds", "670312-98123", 2024, 1, 1, 10);
            busDriver3.addCategory(BusCategory.minibus);

            BusDriver busDriver4 = new BusDriver("Ava", "Patel", "920509-65238", 2024, 1, 1, 9);
            busDriver4.addCategory(BusCategory.minibus);
            busDriver4.addCategory(BusCategory.largebus);

            BusDriver busDriver5 = new BusDriver("Isaac", "Ramirez", "820714-32067", 2024, 1, 1, 8);
            busDriver5.addCategory(BusCategory.minibus);
            busDriver5.addCategory(BusCategory.schoolbus);

            BusDriver busDriver6 = new BusDriver("Emily", "Kim", "550223-42108", 2024, 1, 1, 7);
            busDriver6.addCategory(BusCategory.schoolbus);


            busDriverList.add(busDriver1);
            busDriverList.add(busDriver2);
            busDriverList.add(busDriver3);
            busDriverList.add(busDriver4);
            busDriverList.add(busDriver5);
            busDriverList.add(busDriver6);

            System.out.println();

            System.out.println("Finding driver by drive category:");
            System.out.println("Drive category: School bus");
            for(BusDriver temp : busDriverList){
                try {
                    temp.addCategory(BusCategory.schoolbus);
                } catch (Exception e){
                    System.out.println(temp);
                }
            }
            System.out.println();

            System.out.println("Add category to driver by person code:");
            System.out.println("Person code: 550223-42108");
            for(BusDriver temp : busDriverList){
                if(temp.getPersonCode().equals("550223-42108")){
                    System.out.println("FOUND, this is " + temp + " ==> let's add category");
                    temp.addCategory(BusCategory.largebus);
                    System.out.println(temp);
                    break;
                }
            }
            System.out.println();

            System.out.println("All drivers:");
            for(BusDriver temp : busDriverList){
                System.out.println(temp);
            }
            System.out.println();


        } catch (Exception e){
            System.out.println(e);
        }
    }
}
