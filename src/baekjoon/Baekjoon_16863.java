package baekjoon;

import java.util.*;

public class Baekjoon_16863 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hscore, ascore;
        int htime, atime;

        String ha;
        int points;
        String minSecs;

        int n;
        n = in.nextInt();

        hscore = htime = 0;
        ascore = atime = 0;
        int prev = 0, time;

        for (int i = 0; i < n; i++) {
            ha = in.next();
            points = in.nextInt();
            minSecs = in.next();
            time = convertToSecs(minSecs);
            if (hscore > ascore)
                htime += (time - prev);
            else if (ascore > hscore)
                atime += (time - prev);

            if (ha.equals("H"))
                hscore += points;
            else
                ascore += points;
            prev = time;
        }

        time = 32 * 60; // end of game time
        if (hscore > ascore)
            htime += (time - prev);
        else if (ascore > hscore)
            atime += (time - prev);

        if (hscore > ascore)
            System.out.print("H ");
        else if (ascore > hscore)
            System.out.print("A ");
        else
            System.out.print("BAD ");
        System.out.println(convertToMinSecs(htime) + " " + convertToMinSecs(atime));
    }

    public static int convertToSecs(String time) {
        int colon = time.indexOf(":");
        int mins = Integer.parseInt(time.substring(0, colon));
        int secs = Integer.parseInt(time.substring(colon + 1));
        return 60 * mins + secs;
    }

    public static String convertToMinSecs(int secs) {
        int mins = secs / 60;
        secs %= 60;
        if (secs > 9)
            return mins + ":" + secs;
        else
            return mins + ":0" + secs;
    }
}


