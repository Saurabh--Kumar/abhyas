package org.saurabh.two_pointers.container_water_11;

public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxVolume = 0;
        while(start<end){
            int volume = Math.min(height[start], height[end]) * (end - start);
            maxVolume = Math.max(maxVolume, volume);
            if(height[start] < height[end]){
                start++;
            } else {
                end--;
            }
        }

        return maxVolume;
    }
}
