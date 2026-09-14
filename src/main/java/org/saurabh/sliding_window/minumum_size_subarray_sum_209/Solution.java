package org.saurabh.sliding_window.minumum_size_subarray_sum_209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int total = 0;

        for(; j<nums.length; j++) {
            if(total < target){
                total += nums[j];
            }
            while(total>=target && i <=j){
                minLength = Math.min(j-i+1, minLength);
                total-= nums[i];
                i++;
            }
        }
        if(minLength <= nums.length) {
            return minLength;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
