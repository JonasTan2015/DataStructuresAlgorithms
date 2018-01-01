package Contest64;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus on 12/23/2017.["1002","1220","0122","0112","0121"]
 "1200"
 */
public class Q1 {
    public static void main(String[] args){
        Q1 s = new Q1();
        System.out.println("hahaha");
        System.out.println(s.openLock(new String[]{"1002","1220","0122","0112","0121"}, "1200"));
    }


    public int openLock(String[] deadends, String target) {

        int impossible = Integer.MIN_VALUE;
        int possible = Integer.MAX_VALUE;
        int[][][][] dp = new int[10][10][10][10];

        for(int i = 0; i < 10; i ++)
            for(int j = 0; j < 10; j ++)
                for(int k = 0; k < 10; k ++)
                    for(int l = 0; l < 10; l ++)
                        dp[i][j][k][l] = possible;

        int[] tar = toCoordinates(target);
        dp[tar[0]][tar[1]][tar[2]][tar[3]] = 0;

        for(String dead : deadends){
            int[] pos = toCoordinates(dead);
            dp[pos[0]][pos[1]][pos[2]][pos[3]] = impossible;
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(tar);

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int currStep = dp[pos[0]][pos[1]][pos[2]][pos[3]];
            int nextStep = currStep + 1;

            int[][] next = nextSteps(pos);
            for(int i = 0; i < next.length; i ++){
                if(dp[next[i][0]][next[i][1]][next[i][2]][next[i][3]] == impossible) continue;

                if(dp[next[i][0]][next[i][1]][next[i][2]][next[i][3]] > nextStep){
                    dp[next[i][0]][next[i][1]][next[i][2]][next[i][3]] = nextStep;
                    queue.offer(next[i]);
                }
            }
        }

        return dp[0][0][0][0] == possible? -1 : dp[0][0][0][0];
    }


    private int[][] nextSteps(int[] pos){
        int[][] steps = new int[8][4];
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 4; j ++){
                steps[i][j] = pos[j];
            }
        }
        steps[0][0] = next(steps[0][0], 1);
        steps[1][0] = next(steps[1][0], -1);
        steps[2][1] = next(steps[2][1], 1);
        steps[3][1] = next(steps[3][1], -1);
        steps[4][2] = next(steps[4][2], 1);
        steps[5][2] = next(steps[5][2], -1);
        steps[6][3] = next(steps[6][3], 1);
        steps[7][3] = next(steps[7][3], -1);
        return steps;
    }


    private int next(int num, int diff){
        if(num + diff >= 10)
            return 0;

        if(num + diff < 0)
            return 9;

        return num + diff;
    }


    private int[] toCoordinates(String target){
        int[] arr = new int[4];
        for(int i = 0; i < 4; i ++){
            arr[i] = target.charAt(i) - '0';
        }

        return arr;
    }
}
