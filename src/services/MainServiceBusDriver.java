package services;


import model.BusDriver;
import model.Employee;
import model.Person;
import model.enumerators.BusCategory;

public class MainServiceBusDriver {
    public static void main(String[] args) {
        try {
            Person person = new Person("John", "Louis", "123456-74125");
            Employee employee = new Employee("August", "April", "123456-85236", 2025, 1, 1);


            BusDriver driver1 = new BusDriver("Adaline", "Washington", "469852-13654", 2025, 6, 1, 5);
            BusDriver driver2 = new BusDriver(person, 2023, 5, 1, 2);
            BusDriver driver3 = new BusDriver(employee, 20);

            System.out.println(driver1);
            driver1.addCategory(BusCategory.minibus);
            driver1.addCategory(BusCategory.largebus);
            System.out.println(driver1);
            driver1.removeCategory(BusCategory.largebus);
            System.out.println(driver1);
            System.out.println("---------------------------------------");

            System.out.println(driver2);
            driver2.addCategory(BusCategory.schoolbus);
            System.out.println(driver2);
            driver2.removeCategory(BusCategory.schoolbus);
            System.out.println(driver2);
            System.out.println("---------------------------------------");

            System.out.println(driver3);
            driver3.addCategory(BusCategory.minibus);
            System.out.println(driver3);


        } catch (Exception e){
            System.out.println(e);
        }
    }
}
