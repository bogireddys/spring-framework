package leetcode;

public class PrintingNumbersFromString {
    public static void main(String[] args) {

        String string = "I am 28 years old and i have 5 years of experience in testing";

        String[] array = string.split(" ");
        StringBuilder resultStr = new StringBuilder();

        for (String s : array) {
            try {
                int result = Integer.parseInt(s);
                resultStr.append(result).append(", ");
            } catch (Exception e) {
                continue;
            }
        }
        resultStr.deleteCharAt(resultStr.length() - 2);
        System.out.println(" Numbers form string : " + resultStr);
    }
}
