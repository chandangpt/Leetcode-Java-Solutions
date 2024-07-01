package com.chandan.topic.array.ErecttheFence587;

import java.util.*;

class Solution {
    private class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] outerTrees(int[][] trees) {
        if(trees.length <= 1)
            return trees;
        List<Point> points = new ArrayList<>();
        for(int[] point : trees) {
            points.add(new Point(point[0], point[1]));
        }
        List<Point> res = new ArrayList<>();
        Collections.sort(points, (a, b) -> a.y == b.y ? a.x - b.x : a.y - b.y);

        Stack<Point> hull = new Stack<>();
        hull.push(points.get(0));
        hull.push(points.get(1));

        int n = points.size();
        //Lower hull
        for(int i = 2; i < n; i++) {
            Point top = hull.pop();
            while(!hull.isEmpty() && counterClockWise(hull.peek(), top, points.get(i)) < 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points.get(i));
        }

        //Upper hull
        for(int i = n - 2; i >= 0; i--) {
            Point top = hull.pop();
            while(!hull.isEmpty() && counterClockWise(hull.peek(), top, points.get(i)) < 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points.get(i));
        }

        HashSet<ArrayList<Integer> > duplicate = new HashSet();
        for(Point point : hull) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(point.x);
            tmp.add(point.y);
            if(!duplicate.contains(tmp)) {
                duplicate.add(tmp);
                res.add(point);
            }
        }

        int[][] ans = new int[res.size()][2];
        int i = 0;
        for(Point point : res) {
            ans[i][0] = point.x;
            ans[i][1] = point.y;
            i++;
        }
        return ans;
    }

    public int counterClockWise(Point a, Point b, Point c) {
        double crossproduct = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        return (crossproduct < 0) ? -1 : (crossproduct > 0) ? 1 : 0;
    }
}
