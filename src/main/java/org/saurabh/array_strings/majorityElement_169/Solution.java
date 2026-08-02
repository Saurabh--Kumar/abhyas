package org.saurabh.array_strings.majorityElement_169;

/*
* 169. Majority Element
Easy
Topics
premium lock icon
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.


Follow-up: Could you solve the problem in linear time and in O(1) space?
* */

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int majorityCandidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++){
            if(count == 0){
                majorityCandidate = nums[i];
            }

            if(majorityCandidate == nums[i]){
                count+=1;
            }
            else{
                count-=1;
            }
        }

        count = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == majorityCandidate){
                count ++;
            }
        }

        int majorityElement = count > nums.length/2 ? majorityCandidate : -1;

        return majorityElement;

    }
}