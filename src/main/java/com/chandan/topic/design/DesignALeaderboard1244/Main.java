package com.chandan.topic.design.DesignALeaderboard1244;

public class Main {
    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard ();
        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(1));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
    }
}
