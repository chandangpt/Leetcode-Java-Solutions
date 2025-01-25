package com.chandan.neetcode150.binarysearch.TimeBasedKeyValueStore981;

public class TimeMap {
    Map<String, List<Pair<String, Integer>> > map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Pair<String, Integer>> list = map.get(key);
        int low = 0, high = list.size() - 1;
        String ans = "";
        while(low <= high) {
            int mid = low + (high - low + 1) / 2;
            if(timestamp < list.get(mid).getValue())
                high = mid - 1;
            else {
                ans = list.get(mid).getKey();
                low = mid + 1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
