package leetcode;

public class StringReverseIndividualChar {
    public static void main(String[] args) {
        String phrase = "Bogireddy Gnanendra Reddy";
        String[] array = phrase.split(" ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" ");
            String temp = array[i];
            for (int j = array[i].length() - 1; j >= 0; j--) {
                System.out.print(temp.charAt(j));
            }
        }

    }
}
