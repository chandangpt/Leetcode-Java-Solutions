package com.chandan.topic.design.DesignanOrderedStream1656;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {

    private String[] arr;
    private int ptr;

    public OrderedStream(int n) {
        arr = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        arr[idKey - 1] = value;
        ArrayList<String> ans = new ArrayList<>();
        for(int i = ptr; i < arr.length; i++) {
            if(arr[i] != null) {
                ans.add(arr[i]);
                ptr++;
            } else {
                break;
            }
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
