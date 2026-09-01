package org.saurabh.two_pointers.sum_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        int i = 0;
        int j,k;

        while (i< nums.length){
            j = i+1;
            k = nums.length -1;
            while(j<k){
                if(nums[j] + nums[k] == -1*nums[i]){
                    output.add(List.of(nums[i], nums[j], nums[k]));
                    while(j+1 < nums.length && nums[j+1] == nums[j]){
                        j++;
                    }

                    while(k-1 > j && nums[k-1] == nums[k]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(nums[j] + nums[k] > -1*nums[i]){
                    k--;
                } else{
                    j++;
                }
            }
            while(i+1 < nums.length && nums[i+1] == nums[i]){
                i++;
            }
            i++;

        }
        return output;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.threeSum(new int[]{-2,0,1,1,2});
    }
}
