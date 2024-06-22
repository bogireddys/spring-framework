package leetcode;

public class StringReverseIndividualChar {
    public static void main(String[] args) {
        String phrase = "Bogireddy Gnanendra Reddy";
        String[] array = phrase.split(" ");
        for (String string : array) {
            System.out.print(" ");
            for (int j = string.length() - 1; j >= 0; j--) {
                System.out.print(string.charAt(j));
            }
        }
    }
}
