package com.chandan.designproblems.InsertDeleteGetRandom380;

import java.util.*;

class RandomizedSet {

    Map<Integer, Integer> valueToIndex;
    List<Integer> list;

    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(valueToIndex.containsKey(val)) return false;
        list.add(val);
        valueToIndex.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!valueToIndex.containsKey(val)) return false;
        int ind = valueToIndex.get(val);
        Collections.swap(list, ind, list.size() - 1);
        valueToIndex.put(list.get(ind), ind);
        list.remove(list.size() - 1);
        valueToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int min = 0;
        int max= list.size();
        int ind = (int)(Math.random() * (max - min) + min);
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
