package org.saurabh.array_strings.random_set_380;

import java.util.*;

class RandomizedSet {

    private Map<Integer, Integer> randomMap;
    private List<Integer> randomList;
    private int size;
    private Random rand;

    public RandomizedSet() {
        randomMap = new HashMap<>();
        randomList = new ArrayList<>();
        size = 0;
        rand = new Random();
    }

    public boolean insert(int val) {
        if(randomMap.containsKey(val)){
            return false;
        }
        randomMap.put(val, size);
        randomList.add(val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if(!randomMap.containsKey(val)){
            return false;
        }
        int randomListIndex = randomMap.get(val);
        randomList.set(randomListIndex, randomList.get(size-1));
        randomMap.put(randomList.get(randomListIndex), randomListIndex);
        randomList.remove(size-1);
        randomMap.remove(val);
        size--;
        return true;
    }

    public int getRandom() {
        return randomList.get(rand.nextInt(size));
    }
}