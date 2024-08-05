package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;
    private static final int LOOPS = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        
        List<Integer> a = new ArrayList<>(); 
        for (int i = 1000 ; i < 2000 ; i++) {
            a.add(i);
        } 

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> b = new LinkedList<>();
        b.addAll(a);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        Integer tmp = a.get(a.size() - 1);
        a.set(a.size()-1, a.get(0));
        a.set(0, tmp);

        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for(Integer i : a){
            System.out.print(" " + i);
        }

        System.out.println("");

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeA = System.nanoTime();
        for(int i = 0; i < ELEMS ; i++){
            a.add(0, i);
        }      
        timeA = System.nanoTime() - timeA;   

        long timeB = System.nanoTime();
        for(int i = 0; i < ELEMS ; i++){
            b.add(0, i);
        }      
        timeB = System.nanoTime() - timeB; 

        System.out.println(" adding " + ELEMS + " elements to the beginning of an arraylist took " + timeA + " ns");

        System.out.println(" adding " + ELEMS + " elements to the beginning of a linked list took " + timeB + " ns");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */


        int middle = a.size()/2;

        timeA = System.nanoTime();
        for (int i = 0; i < LOOPS; i++) {
            a.get(middle);
        }
        timeA = System.nanoTime() - timeA;

        middle = b.size()/2;

        timeB = System.nanoTime();
        for (int i = 0; i < LOOPS; i++) {
            b.get(middle);
        }
        timeB = System.nanoTime() - timeB;

        System.out.println(" reading the middle element of an arraylist took " + timeA + " ns");

        System.out.println(" reading the middle element of a linkedlist took " + timeB + " ns");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> m = new HashMap<>();
        m.put("Arfica", 1_110_635_000L);
        m.put("Americas", 972_005_000L);
        m.put("Antartica", 0L);
        m.put("Asia", 4_298_723_000L);
        m.put("Europe", 742_452_000L);
        m.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */

        long population = 0;
        for (final long el : m.values()) {
            population += el;
        }

        System.out.println(" the population of the world is " + population);

    }
}
