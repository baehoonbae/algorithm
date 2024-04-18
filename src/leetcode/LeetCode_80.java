package leetcode;

// 80. Remove Duplicates from Sorted Array II

public class LeetCode_80 {
    public int removeDuplicates(int[] nums) {
        int k = 1, a = 0, b = 1;
        while (b < nums.length) {
            int count = 0;
            if (nums[b] != nums[a] && nums[a + 1] != nums[a]) {
                a++;
                nums[a] = nums[b];
                k++;
            } else if(nums[b] != nums[a] && nums[a + 1] == nums[a]){
                nums[a + 1] = nums[a];
                nums[a + 2] = nums[b];
                a += 2;
                k++;
            }
            b++;
        }
        return k;
    }
}

