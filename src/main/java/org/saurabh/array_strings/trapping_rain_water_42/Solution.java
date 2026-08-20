package org.saurabh.array_strings.trapping_rain_water_42;

public class Solution {

    public static int trap(int[] height) {
        int[] maxHeightLeft = new int[height.length];
        int[] maxHeightRight = new int[height.length];

        maxHeightLeft[0] = height[0];
        maxHeightRight[height.length-1] = height[height.length-1];

        for(int i = 1; i < height.length; i++){
            if(height[i] < maxHeightLeft[i-1]){
                maxHeightLeft[i] = maxHeightLeft[i-1];
            } else {
                maxHeightLeft[i] = height[i];
            }
        }

        for(int i = height.length-2; i >=0; i--){
            if(height[i] < maxHeightRight[i+1]){
                maxHeightRight[i] = maxHeightRight[i+1];
            } else {
                maxHeightRight[i] = height[i];
            }
        }

        int trappedWater = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] < Math.min(maxHeightLeft[i], maxHeightRight[i])){
                trappedWater+= Math.min(maxHeightLeft[i], maxHeightRight[i]) - height[i];
            }
        }

        return trappedWater;

    }

}
