package leetcode;

import java.util.*;

public class SecondHighestNumberInArray {
    public static void main(String[] args) {

        int[] array = {0, 9, 7, 67, 89, 1, 64, 42, 60, 345, 345};

        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>();

        list.addAll(set);

        Collections.sort(list);
        System.out.println("Second highest number is : " + list.get(list.size() - 2));
    }
}
