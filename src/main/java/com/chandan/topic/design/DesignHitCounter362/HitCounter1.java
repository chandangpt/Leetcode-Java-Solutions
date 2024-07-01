package com.chandan.topic.design.DesignHitCounter362;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter1 {
    // could use a queue service like SQS to scale up
    private Queue<Integer> cache = new LinkedList<>();

    // to scale up and ensure durability , this need to store in db
    // or use redis
    private int count = 0;
    public void hit(int timestamp) {
        cache.add(timestamp);

        // this guy doesn't guarantee atomic in a multithreading environment
        // we can add lock but this would produce higher latency
        count++;
    }

    public int getHits(int timestamp) {
        while (cache.size() > 0 && timestamp - cache.peek() >= 300)
        {
            cache.remove();
            count--;
        }
        return count;
    }
}
