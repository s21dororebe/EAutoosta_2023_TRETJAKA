package services;

import model.Station;
import model.enumerators.City;
import model.extraClasses.WorkingTime;

public class MainServiceStation {
    public static void main(String[] args) {
        try {
            WorkingTime wt1 = new WorkingTime(12, 0, 13, 0);
            Station st1 = new Station();
            Station st2 = new Station("Flowers station", City.Jelgava, wt1);
            Station st3 = new Station("Rainbow station", City.Daugavpils, 12, 15);
            Station st4 = new Station("Cats station", City.Ventspils, 10, 0, 21, 0);

            System.out.println(st1);
            System.out.println(st2);
            System.out.println(st3);
            System.out.println(st4);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
