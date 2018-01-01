public class Maze1 {
    public boolean canReach(int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0)
            return true;
        return searchMaze(maze, new int[maze.length][maze[0].length], start, destination);
    }

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    private boolean searchMaze(int[][] maze, int[][] dp, int[] start, int[] destination){
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;

        if(dp[start[0]][start[1]] != 0)
            return dp[start[0]][start[1]] == 1;

        maze[start[0]][start[1]] = -1;
        boolean res = false;
        for(int i = 0; i < 4; i ++){
            int x = start[0];
            int y = start[1];
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length
                    && maze[x][y] != 1){
                x += dx[i];
                y += dy[i];
            }

            x -= dx[i];
            y -= dy[i];

            if(maze[x][y] != -1 && searchMaze(maze, dp, new int[]{x, y}, destination)){
                res = true;
                break;
            }
        }

        dp[start[0]][start[1]] = res? 1: -1;
        return res;
    }
}
