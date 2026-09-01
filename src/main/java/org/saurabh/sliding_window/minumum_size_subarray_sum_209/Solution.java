package org.saurabh.sliding_window.minumum_size_subarray_sum_209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int total = 0;

        while(true){
            while(j < nums.length && total < target){
                total+= nums[j];
                j++;
            }

            while(i < nums.length && total >= target){
                minLength = Math.min(minLength, j-i);
                total -= nums[i];
                i++;
            }

            if(j == nums.length){
                break;
            }
        }
        if(minLength <= nums.length) {
            return minLength;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
