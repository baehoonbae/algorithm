package programmers;

import java.util.*;

public class Programmers_17677 {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int gyo = 0;
        int hap = 0;
        for (int i = 0; i < str1.length() - 1; i++) {
            String s1 = str1.substring(i, i + 2);
            if (s1.charAt(0) < 97 || s1.charAt(0) > 122 || s1.charAt(1) < 97 || s1.charAt(1) > 122) continue;
            list1.add(s1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String s2 = str2.substring(i, i + 2);
            if (s2.charAt(0) < 97 || s2.charAt(0) > 122 || s2.charAt(1) < 97 || s2.charAt(1) > 122) continue;
            list2.add(s2);
        }
        hap = list1.size() + list2.size();

        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))) {
                gyo++;
            }
        }

        hap -= gyo;
        if(gyo==0&&hap==0) return 65536;
        return (int) (((double) gyo / hap) * 65536);
    }
}