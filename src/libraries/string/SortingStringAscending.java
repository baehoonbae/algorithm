package libraries;

public class SortingStringAscending {
    public String anyString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sb.append((char)('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }
}
