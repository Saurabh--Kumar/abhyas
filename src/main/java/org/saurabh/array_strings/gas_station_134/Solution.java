package org.saurabh.array_strings.gas_station_134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int startIndex = 0; //gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        int currentGas=0;

        for (int i = 0; i< gas.length; i++){ //i=4
            if(currentGas < 0){
                startIndex = i; //3
                currentGas = 0;
            }
            currentGas += gas[i]; //8
            currentGas -= cost[i]; //6
        }

        for (int i = 0; i < startIndex; i++){//i = 2
            currentGas += gas[i]; //5
            currentGas -= cost[i]; //0
        }

        if (currentGas > 0) {
            return startIndex;
        }
        return -1;

    }
}
