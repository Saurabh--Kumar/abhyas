package org.saurabh.array_strings.candy_135;

class Solution {
    public int candy(int[] ratings) {

        int[] output = new int[ratings.length];
        int currentCandy = 1;
        output[0] = 1;

        for (int i = 1; i< ratings.length; i++){
            if(ratings[i] > ratings[i-1]) {
                currentCandy ++;
            } else {
                currentCandy = 1;
            }
            output[i] = currentCandy;
        }

        int total = output[ratings.length-1];

        for(int i = ratings.length-2 ; i>= 0; i--){
            if(ratings[i] > ratings[i+1] && output[i]<=output[i+1]){
                output[i] = output[i+1]+1;
            }
            total += output[i];
        }
        return total;
    }
}
