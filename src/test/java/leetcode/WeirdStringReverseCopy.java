package leetcode;

public class WeirdStringReverseCopy {
    public static void main(String[] args) {
        String str1 = "My name is Raju";
        char[] a = str1.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') {
                b[i] = ' ';
            }
        }
        int j = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != ' ') {
                while (j >= 0 && b[j] == ' ') {
                    j--;
                }
                if (j >= 0) {
                    b[j] = a[i];
                    j--;
                }
            }
        }
        String Str2 = new String(b);
        System.out.println(str1);
        System.out.println(Str2);
    }
}
