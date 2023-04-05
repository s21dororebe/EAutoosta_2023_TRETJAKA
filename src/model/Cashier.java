package model;

public class Cashier extends Employee {
    private final long generatedId;
    private static long idCounter = 0;

    public long getGeneratedId() {
        return generatedId;
    }

    public Cashier() throws Exception {
        generatedId = idCounter;
        idCounter++;
    }
    public Cashier(String name, String surname, String personCode, int yearOfContract, int monthOfContract, int dateOfContract) throws Exception {
        super(name, surname, personCode, yearOfContract, monthOfContract, dateOfContract);
        generatedId = idCounter;
        idCounter++;
    }
    public Cashier(Person personData, int yearOfContract, int monthOfContract, int dateOfContract) throws Exception {
        super(personData, yearOfContract, monthOfContract, dateOfContract);
        generatedId = idCounter;
        idCounter++;
    }
}
