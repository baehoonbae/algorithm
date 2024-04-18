package libraries.numeral;

public class TenToN {
    public static StringBuilder conversionToN(int number, int n) {
        StringBuilder sb = new StringBuilder();
        int current = number;
        while (current > 0) {
            // current % n이 10보다 큰 경우, 대문자 알파벳으로 나오기 때문에 적절히 변환해야함.
            // 0~9 까지는 숫자 그대로 나온다.
            if (current % n < 10) {
                sb.append(current % n);
            } else {
                sb.append((char) (current % n - 10 + 'A'));
            }
            current /= n;
        }
        return sb.reverse();
    }
}

