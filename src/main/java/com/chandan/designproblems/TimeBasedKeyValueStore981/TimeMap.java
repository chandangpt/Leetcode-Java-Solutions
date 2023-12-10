package com.chandan.designproblems.TimeBasedKeyValueStore981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    class Record {

        String value;
        int timestamp;

        public Record(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Record>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Record> list = timeMap.getOrDefault(key, new ArrayList<>());
        list.add(new Record(value, timestamp));
        timeMap.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Record> list = timeMap.get(key);
        if(list == null) return "";
        return binarySearch(list, timestamp);
    }

    String binarySearch(List<Record> list, int timestamp) {
        int l = 0;
        int r = list.size();
        while(l < r) {
            int m = (l + r) / 2;
            if(list.get(m).timestamp > timestamp) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l == 0 ? "" : list.get(l - 1).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
