public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N == 0)
            return 0;
        if(i >= m || i < 0 || j >=n || j < 0)
            return 0;

        // dp[a][b][c] means that in exactly c steps, how many routes are there to reach grid[a][b]
        int[][][] dp = new int[m][n][N + 1];
        dp[i][j][0] = 1;

        int total = 0;


        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for(int step = 0; step < N; step ++){
            for(int row = 0; row < m; row ++){
                for(int col = 0; col < n; col ++){
                    if(dp[row][col][step] > 0){
                        for(int k = 0; k < dx.length; k++){
                            int x = row + dx[k];
                            int y = col + dy[k];
                            if(x < 0 || x >= m || y < 0 || y >= n)
                                total += 1;
                            else
                                dp[x][y][step + 1] += dp[row][col][step];
                        }
                    }
                }
            }
        }

        for(int step = 0; step < N + 1; step ++){
            for(int row = 0; row < m; row ++ ){
                for(int col = 0; col < n; col ++){
                    System.out.print(dp[row][col][step]);
                    System.out.print(", ");
                }
                System.out.println();
            }
            System.out.println("*********************");
        }

        System.out.println(total);
        return total;
    }

    public static void main(String[] args){
        OutOfBoundaryPaths s = new OutOfBoundaryPaths();
        s.findPaths(1, 3, 3, 0, 1);
    }
}