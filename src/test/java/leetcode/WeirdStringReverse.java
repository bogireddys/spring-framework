package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WeirdStringReverse {

    public static List<Integer> list = new ArrayList<>();
    static String input = "My name is Raju";
    static String combinedString = input.replace(" ", "");
    static StringBuilder reversed = new StringBuilder();
    static String finalString = "";

    public static void main(String[] args) {

        String[] array = input.split(" ");
        for (String string : array) {
            list.add(string.length());
        }
        for (int i = combinedString.length() - 1; i >= 0; i--) {
            reversed.append(combinedString.charAt(i));
        }
        for (int i = 0; i < list.size(); i++) {
            finalString = finalString + stringBuilder(i);
        }

        System.out.println(finalString);
    }

    public static String stringBuilder(int entry) {
        int initialElement;
        if (entry == 0) {
            initialElement = 0;
        } else {
            initialElement = count(entry - 1);
        }
        int finalElement = count(entry);
        System.out.println("Printing inside string Builder : " + reversed.substring(initialElement, finalElement));
        return reversed.substring(initialElement, finalElement).concat(" ");
    }

    public static int count(int entryValue) {
        int count = 0;
        for (int i = 0; i <= entryValue; i++) {
            count = count + list.get(i);
        }
        System.out.println("Printing count : " + count);
        return count;
    }
}
