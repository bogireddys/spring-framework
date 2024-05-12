package leetcode;

public class StringReverseWords {
    public static void main(String[] args) {

        String phrase = "Bogireddy Gnanendra Reddy";
        String[] array = phrase.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
