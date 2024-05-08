package leetcode;

import java.util.HashMap;
import java.util.Map;

public class JavaArrayOccurenceShort {
    public static void main(String[] args) {
        int[] array = {4, 4, 5, 5, 6};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int j : array) {
            if (hashMap.containsKey(j)) {
                hashMap.put(j, hashMap.get(j) + 1);
            } else {
                hashMap.put(j, 1);
            }
        }
        System.out.println("Map keys : " + hashMap.keySet());
        System.out.println("Key Occurrence : " + hashMap.values());
    }
}
