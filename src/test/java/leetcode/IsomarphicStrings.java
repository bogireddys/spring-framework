package leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IsomarphicStrings {
    public static void main(String[] args) {
        String string1 = "paper";
        String string2 = "title";
        Map<Character, Character> map = new HashMap<>();
        boolean flag = true;
        if (!(string1.length() == string2.length())) {
            System.out.println("Strings are not Isomarphic");
            System.exit(0);
        }

        for (int i = 1; i < string1.length(); i++) {
            map.put(string1.charAt(0), string2.charAt(0));

            if (map.containsKey(string1.charAt(i))) {
                if (string2.charAt(i) == map.get(string1.charAt(i))) {
                } else {
                    flag = false;
                    map.put(string1.charAt(i), string2.charAt(i));
                }
            } else {
                map.put(string1.charAt(i), string2.charAt(i));
            }
        }
        int count = 0;
        Collection<Character> list = map.values();
        for (char char1 : list) {
            int k = 0;
            char tempChar = char1;
            for (char char2 : list) {
                if (tempChar == char2) {
                    k = k + 1;
                    count = k;
                }
            }
            if (k > 1) {
                break;
            }
        }
        if (count > 1) {
            flag = false;
            System.out.println("Strings are  not Isomarphic");
        }

        if (flag) {
            System.out.println("Strings are Isomarphic");
        }
    }
}
