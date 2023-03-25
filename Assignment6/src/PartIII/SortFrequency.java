package PartIII;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class SortFrequency {

    public static void sortByFrequency(ArrayList<Integer> ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // count the frequency of each number
        for (Integer i : ar) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        // sort the array by frequency, in ascending order
        ar.sort((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1 - o2;
            } else {
                return map.get(o1) - map.get(o2);
            }
        });
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for (int i=0;i<100;i++) {
                ar.add((int)(Math.random()*10));
        }
        System.out.println(ar.toString());
        sortByFrequency(ar);
        System.out.println(ar.toString());
    }
}
