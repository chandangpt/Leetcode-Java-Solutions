package com.chandan.neetcode150.stack.CarFleet853;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] timeToReachTarget = new double[target];
        for(int i = 0; i < position.length; i++)
            timeToReachTarget[position[i]] = (double)(target - position[i]) / speed[i];
        int numFleets = 0;
        double curMaxTimeToReachTarget = 0.0;
        for(int i = target - 1; i >= 0; i--) {
            double curPosTimeToTarget = timeToReachTarget[i];
            if(curPosTimeToTarget > curMaxTimeToReachTarget) {
                curMaxTimeToReachTarget = curPosTimeToTarget;
                numFleets++;
            }
        }
        return numFleets;
    }
}


