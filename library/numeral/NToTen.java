package libraries.numeral;

public class NToTen {
    public static int conversionNToTen(StringBuilder num, int n) {
        int result = 0;
        char[] arr = new char[num.length()];
        StringBuilder sb = num.reverse();
        for (int i = 0; i < sb.length(); i++) {
            arr[i] = sb.charAt(i);
        }
        for (char c : arr) {
            result += (int) Math.pow(n, c);
        }
        return result;
    }
}
