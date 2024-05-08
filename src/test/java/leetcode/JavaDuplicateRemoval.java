package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaDuplicateRemoval {
    public static void main(String[] args) {
        int[] array = {5, 2, 6, 8, 6, 7, 5, 2, 8, 0};
        List<Integer> list = new ArrayList<>();
        for (int j : array) {
            if (list.contains(j)) {
                System.out.println(j + " : is a duplicate element ");
            } else {
                list.add(j);
            }
        }
        Collections.sort(list);
        for (int element : list) {
            System.out.println("List elements are : " + element);
        }


    }
}
