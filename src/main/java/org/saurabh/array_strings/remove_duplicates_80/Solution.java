package org.saurabh.array_strings.remove_duplicates_80;

class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        //[1,1,1,2,2,3]

        int k = 1;
        int currentNumber = nums[0]; //1
        int currentNumCount = 1;

        for(int current=1; current < nums.length; current++){
            if(! (nums[current] == currentNumber && currentNumCount >= 2)){
                if(nums[current] != currentNumber) {
                    currentNumCount = 1;
                } else{
                    currentNumCount++;
                }
                currentNumber = nums[current];
                int tmp = nums[k];
                nums[k] = nums[current];
                nums[current] = tmp;
                k++; //2

            }
        }

        return k;
    }
}
