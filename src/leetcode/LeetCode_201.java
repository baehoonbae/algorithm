package leetcode;

public class LeetCode_201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right &= (right - 1);
        }
        return right;
    }
}

