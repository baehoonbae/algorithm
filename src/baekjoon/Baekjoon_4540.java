package baekjoon;

import java.util.Scanner;

public class Baekjoon_4540 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int T = 0; T < t; T++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            String[] s2 = new String[s1.length + 1];
            for (int i = 0; i < b; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                sc.nextLine();
                s2[y] = s1[x - 1];
                s1[x - 1] = null;
            }
            for (int i = 1; i < s2.length; i++) {
                if (s2[i] == null) {
                    for (int j = 0; j < s1.length; j++) {
                        if (s1[j] != null) {
                            s2[i] = s1[j];
                            s1[j] = null;
                            break;
                        }
                    }
                }
            }

            for (int i = 1; i < s2.length - 1; i++) {
                System.out.print(s2[i]);
                System.out.print(" ");
            }
            System.out.println(s2[s2.length - 1]);
        }
    }
}
