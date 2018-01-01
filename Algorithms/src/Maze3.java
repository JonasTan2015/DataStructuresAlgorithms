import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze3 {

    // shortest distance
    int min = Integer.MAX_VALUE;

    // shortest path route
    String minS = null;
    int n, m;
    int[] hole;
    int[][] maze;
    int[][] map;
    int[][] dirs = {{0,1},{-1,0},{1,0},{0,-1}};
    char[] headings = {'r', 'u', 'd', 'l'};



    public String findShortestWay(int[][] maze, int[] hole, int[] ball) {
        this.hole = hole;
        this.maze = maze;
        this.n = maze.length;
        this.m = maze[0].length;
        this.map = new int[n][m];
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < m; j ++)
                map[i][j] = Integer.MAX_VALUE;

        map[ball[0]][ball[1]] = 0;

        move(ball[0], ball[1], 0, "", -1);
        return minS == null? "impossible" : minS;
    }


    private void move(int x, int y, int cnt, String path, int dir){
        if(map[x][y] < cnt || min < cnt)
            return;

        for(int i = 0; i < 4; i ++){

            int nextx = x;
            int nexty = y;
            int nextcnt = cnt;
            while(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m
                    && maze[nextx][nexty] != 1 &&
                    (nextx != hole[0] || nexty != hole[1])){
                nextx += dirs[i][0];
                nexty += dirs[i][1];
                nextcnt ++;
            }

            if(nextx == hole[0] && nexty == hole[1]){
                if(nextcnt < min){
                    min = nextcnt;
                    minS = path + headings[i];
                    map[nextx][nexty] = nextcnt;
                }else if(nextcnt == min && (minS.compareTo(path + headings[i]) > 0 || minS == null)){
                    minS = path + headings[i];
                }
            }else{
                nextx -= dirs[i][0];
                nexty -= dirs[i][1];
                nextcnt --;
                if(map[nextx][nexty] > nextcnt)
                    map[nextx][nexty] = nextcnt;
                move(nextx, nexty, nextcnt, path + headings[i], i);
            }
        }
    }


    public static void main(String[] args){
        Maze3 m = new Maze3();
        int[][] maze = {
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };

        System.out.println(m.findShortestWay(maze, new int[]{0,1}, new int[]{4,3}));
    }
}
