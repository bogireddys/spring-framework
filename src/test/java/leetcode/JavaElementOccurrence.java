package leetcode;

import java.util.*;

public class JavaElementOccurrence {
    public static void main(String[] args) {
        int[] array = {34, 45, 90, 0, 34, 4, 4, 5, 5, 6, 20};

        Map<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        for (int j : array) {
            if (map.containsKey(j)) {
                continue;
            }
            for (Integer integer : array) {
                if (j == integer) {
                    temp = temp + 1;
                }
            }
            map.put(j, temp);
            temp = 0;
        }

        System.out.println("Map keys : " + map.keySet());
        Set<Integer> treeSet = new TreeSet<>(map.keySet());
        System.out.println("Tree Set : " + treeSet);
        System.out.println("Key Occurrence : " + map.values());


    }
}
