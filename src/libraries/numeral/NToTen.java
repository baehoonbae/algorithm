package libraries.numeral;

public class NToTen {
    public static int conversionNToTen(StringBuilder num, int n) {
        int result = 0;
        StringBuilder sb = num.reverse();
        for (int i = 0; i < sb.length(); i++) {
            result += (int) (Math.pow(n, i)) * (sb.charAt(i) - '0');
        }
        return result;
    }
}
