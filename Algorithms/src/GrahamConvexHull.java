///**
// * Created by 310288079 on 8/18/2017.
// * use cross product to tell whether 2 vectors are anti-clockwise
// */
//
//import java.util.*;
//public class GrahamConvexHull {
//    private int getDistance(Point p1, Point p2) {
//        return (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
//    }
//
//    //use cross product of 3 points to tell whether it is anti-clockwise
//    private int orientation(Point p1, Point p2, Point p3){
//        int val = (p2.y - p1.y) * (p3.x - p2.x) -
//                (p2.x - p1.x) * (p3.y - p2.y);
//
//        if(val == 0) return 0;
//        else if(val > 0) return 2;
//    }
//
//    public List<Point> algorithm (Point[] points){
//
//    }
//
//    public static void main(String[] args){
//        GrahamConvexHull grahamConvexHull = new GrahamConvexHull();
//        Point[] points = new Point[]{new Point(1,2), new Point(3,4), new Point(5,6)};
//        grahamConvexHull.algorithm(points);
//    }
//}
//
//
//
//
//class Point {
//    int x = 0;
//    int y = 0;
//    Point(int x, int y ){
//        this.x = x;
//        this.y = y;
//    }
//}
