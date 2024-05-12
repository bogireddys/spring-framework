package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomarphicStrings {
    public static void main(String[] args) {
        String string1 = "foo";
        String string2 = "bar";
        Map<Character, Character> map = new HashMap<>();
        boolean flag = true;
        if (!(string1.length() == string2.length())) {
            System.out.println("Strings are not Isomarphic");
            flag = false;
            System.exit(0);
        }

        for (int i = 0; i < string1.length(); i++) {
            if (i == 0) {
                map.put(string1.charAt(i), string2.charAt(i));
                continue;
            }
            if (map.containsKey(string1.charAt(i))) {
                if (string2.charAt(i) == map.get(string1.charAt(i))) {
                } else {
                    flag = false;
                    map.put(string1.charAt(i), string2.charAt(i));

                }
            }
        }
        if (flag) {
            System.out.println("Strings are Isomarphic");
        }
    }
}
