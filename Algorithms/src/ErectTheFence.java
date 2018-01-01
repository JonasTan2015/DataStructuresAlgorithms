/**
 * Created by 310288079 on 8/10/2017.
 *
 * This algorithm is called Graham convex hull algorithm. Here is the scenario.
 * Given a list of 2-dimensional points, find a polygon with smallest perimeter which surrounds all the given points
 *
 * Idea:
 * Step 1: Find the point with the smallest y coordinate. If multiple points share the same y coordinate, choose the one with
 * smallest x coordinate. This point is called starting point/ Point 0
 *
 * Step 2: For the rest of the points, compute the directional vector between that point and starting point.
 *
 * Step 3: For those points with the same directional vector, choose the one furthest away from starting point and rull out the others
 *
 * Step 4: Sort the rest of the points according to directional vector, scan anti-clockwisely from the starting point, the first one to reach
 * should be placed at the front of the array
 *
 * Step 5: Choose 2 more points from the sorted array, put them into stack. Point 1 and Point 2
 *
 * Step 6: Choose the rest of the points sequentially. If pointN is not on the left of vector(stack_point[top], stack_point[top - 1]). keep poping the stack
 * Until it does
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ErectTheFence {
    class Point {
        int x = 0;
        int y = 0;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//    private int orientation(Point p1, Point p2, Point p0) {
//        int val =
//    }

    private float distance(Point p1, Point p2) {
        return (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
    }

    public List<Point> solve(Point[] points){
        ArrayList<Point> res = new ArrayList<Point>();
        if(points == null || points.length == 0)
            return res;

        return res;
    }

    public static void main(String[] args) {

    }

}
