/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hadoop
 */
public class MaxPointsOnALine {

    class Point {

        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {

        if (points.length <= 0) {
            return 0;
        }
        int maxCount = 1;
        Map<Double, Integer> slopeMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {

            slopeMap.clear();
            slopeMap.put(Double.MIN_VALUE, 1);
            int dup = 0;
            for (int j = i + 1; j < points.length; j++) {

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }

                double slope = computeSlope(points[i], points[j]);
                System.out.println(i + " " + j + " " + slope);
                if (slopeMap.containsKey(slope)) {
                    slopeMap.put(slope, slopeMap.get(slope) + 1);
                } else {
                    slopeMap.put(slope, 2);
                }
            }
            for (int v : slopeMap.values()) {
                if (v + dup > maxCount) {
                    maxCount = v + dup;
                }
            }
        }

        return maxCount;
    }

    private double computeSlope(Point a, Point b) {
        double ax = (double) a.x;
        double bx = (double) b.x;
        double ay = (double) a.y;
        double by = (double) b.y;
        return bx != ax ? 0.0 + (by - ay) / (bx - ax) : Double.MAX_VALUE;
    }

}
