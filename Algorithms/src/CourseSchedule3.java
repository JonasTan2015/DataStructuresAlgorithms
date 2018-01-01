import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by 310288079 on 7/28/2017.
 */
public class CourseSchedule3 {

    private static final int start = 0;
    private static final int end = 1;

    public int solve (int[][] schedules){
        ArrayList<Pair> list = new ArrayList<Pair>();
        for(int i = 0; i < schedules.length; i ++){
            list.add(new Pair(schedules[i][0], 1));
            list.add(new Pair(schedules[i][1], -1));
        }

        Collections.sort(list, (a, b) ->{
            if(a.time != b.time) return a.time - b.time;
            else return a.diff - b.diff;
        });

        int count = 0;
        int currentcourse = 0;

        for(Pair p : list){
            if(currentcourse == 0){
                count ++;
            }

            if(p.diff > 0){
                currentcourse ++;
            }else
                currentcourse --;

        }
        return count;
    }

    class Pair {
        int time = 0;
        int diff = 0;
        Pair(int time, int diff) {
            this.time = time;
            this.diff = diff;
        }
    }


    public static void main(String[] args){
        int[][] schedules = new int[][]{{1000, 2000}, {100, 1500}, {300, 400}};
        CourseSchedule3 cs = new CourseSchedule3();
        System.out.println("answer is: " + cs.solve(schedules));

    }
}
