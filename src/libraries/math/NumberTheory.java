package libraries.math;

public class NumberTheory {

    // 두 수의 최소공배수(유클리드 호제법)
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 두 수의 최대공약수
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    // 여러 수의 최소공배수
    public static int findLCM(int[] numbers) {
        int lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            lcm = findLCM(lcm, numbers[i]);
        }
        return lcm;
    }

    // 여러 수의 최대공약수
    public static int findGCD(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = findGCD(result, numbers[i]);
        }
        return result;
    }

}
