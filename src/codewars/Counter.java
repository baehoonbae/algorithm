package codewars;

public class Counter {
    public int countSheeps(Boolean[] arrayOfSheeps) {
        int count=0;
        for (Boolean arrayOfSheep : arrayOfSheeps) {
            if (arrayOfSheep) {
                count++;
            }else{
                continue;
            }
        }
        return count;
    }
}