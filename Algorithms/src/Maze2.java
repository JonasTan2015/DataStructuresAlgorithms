public class Maze2 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0)
            return 0;

        int[][] dp = new int[maze.length][maze[0].length];
        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[0].length; j ++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[start[0]][start[1]] = 0;
        searchMaze(maze, dp, start, destination);
        return dp[destination[0]][destination[1]] == Integer.MAX_VALUE ?
                -1 : dp[destination[0]][destination[1]];
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    private void searchMaze(int[][] maze, int[][] dp, int[] start, int[] destination){
        if(start[0] == destination[0] && start[1] == destination[1])
            return;

        for(int i = 0; i < 4; i ++){
            int x = start[0];
            int y = start[1];
            int nextStep = 0;
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length
                    && maze[x][y] != 1){
                x += dx[i];
                y += dy[i];
                nextStep ++;
            }

            x -= dx[i];
            y -= dy[i];
            nextStep --;

            if(dp[x][y] > dp[start[0]][start[1]] + nextStep){
                dp[x][y] = dp[start[0]][start[1]] + nextStep;
                searchMaze(maze, dp, new int[]{x, y}, destination);
            }
        }
    }
}
