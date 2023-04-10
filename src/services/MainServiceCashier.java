package services;

import model.Cashier;
import model.Employee;
import model.Person;

public class MainServiceCashier {
    public static void main(String[] args) {
        try {
            Person person = new Person("John", "Louis", "123456-74125");
            Employee employee = new Employee("August", "April", "123456-85236", 2025, 1, 1);

            Cashier c1 = new Cashier();
            Cashier c2 = new Cashier("April", "Martins", "654123-98741", 2023, 5, 6);
            Cashier c3 = new Cashier(person, 2024, 12, 1);
            Cashier c4 = new Cashier(employee);

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
