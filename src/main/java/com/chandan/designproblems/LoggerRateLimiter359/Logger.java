package com.chandan.designproblems.LoggerRateLimiter359;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    Map<String, Integer> messageToTimestampMap;

    public Logger() {
        messageToTimestampMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(messageToTimestampMap.get(message) == null || timestamp - messageToTimestampMap.get(message) >= 10) {
            messageToTimestampMap.put(message, timestamp);
            return true;
        }
        return false;
    }
}
