package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    static enum Month{
        JANUARY("January", 31, 1),
        FEBRUARY("February", 28, 2),
        MARCH("March", 31, 3),
        APRIL("April", 30, 4),
        MAY("May", 31, 5),
        JUNE("June", 30, 6),
        JULY("July", 31, 7),
        AUGUST("August", 31, 8),
        SEPTEMBER("September", 30, 9),
        OCTOBER("October", 31, 10),
        NOVEMBER("November", 30, 11),
        DECEMBER("December", 31, 12),
        FEBRUARY_L("February", 29, 2);

        private final String actualName;
        private final int days;
        private final int number;

        private Month(final String actualName, final int days, final int number){
            this.actualName = actualName;
            this.days = days;
            this.number = number;
        }

        public String getActualName(){
            return this.actualName;
        }

        public int getDays(){
            return this.days;
        }


        public static Month fromString(String s) throws IllegalArgumentException {
            s = s.toUpperCase();
            List<String> splitted = new LinkedList<>();
            List<Month> Matches = new LinkedList<>();

            if (s.contains(" ")) {
                for (String i : s.split(" ")) {
                    splitted.add(i);
                }
            }

            for (Month m : Month.values()) {
                if (m != FEBRUARY_L && m.actualName.toUpperCase().contains(s)) {
                    Matches.add(m);
                } else {
                    if (splitted.size() > 1 && "FEBRUARY".contains(splitted.get(0)) && "LEAP".contains(splitted.get(1))){
                        Matches.add(FEBRUARY_L);
                    } 
                }
            }

            if (Matches.size() == 0){
                throw new IllegalArgumentException("no matches");
            } 
            else if (Matches.size() > 1) {
                throw new IllegalArgumentException("too much matches");
            }
            else {
                return Matches.get(0);
            }
        }
        
        
    }


    static class SortByMonthOrder implements Comparator<String> {
        public int compare (String a, String b) {
            if (Month.fromString(a).number > Month.fromString(b).number) {
                return 1;
            }
            else if (Month.fromString(a).number == Month.fromString(b).number) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static class SortByDate implements Comparator<String> {
        public int compare (String a, String b) {
            if (Month.fromString(a).days > Month.fromString(b).days) {
                return 1;
            }
            else if (Month.fromString(a).days == Month.fromString(b).days) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDate();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }
}
