/*
 * 给你一个矩阵。 1 的位置代表房子，0的位置代表空地。
 * 现在需要建造1间post office。使得所有房子到这个office 距离之和最小。 返回这个距离
 * Post office 只能建在空地。人可以穿过其他房屋到达post office
 *
 * 思路：我们可以对矩阵里面每一个的空地都算一次到所有房子的距离值和。但是这样会超时
 * 优化思路：先算出所有房子的重心。
 */

import java.util.*;

public class BuildPostOffice {

    private int[] getCenter(List<int[]> houses){
        List<Integer> xarray = new ArrayList<>();
        List<Integer> yarray = new ArrayList<>();
        for(int i = 0; i < houses.size(); i ++){
            xarray.add(houses.get(i)[0]);
            yarray.add(houses.get(i)[1]);
        }

        Collections.sort(xarray);
        Collections.sort(yarray);

        if(xarray.size() == 0 || yarray.size() == 0)
            return new int[]{-1, -1};
        else
            return new int[]{xarray.get(xarray.size() / 2), yarray.get(yarray.size() / 2)};
    }

    private int getTotalDistance(List<int[]> houses, int[] officePosition){
        int totalDistance = 0;
        for(int[] house : houses){
            totalDistance += Math.abs(house[0] - officePosition[0]) + Math.abs(house[1] - officePosition[1]);
        }
        return totalDistance;
    }


    public int getMinimumDistance(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return -1;

        // put all the houses positions into a list {@code houses}
        List<int[]> houses = new ArrayList<>();
        for(int x = 0; x < matrix.length; x ++){
            for(int y = 0; y < matrix[0].length; y ++){
                if(matrix[x][y] == 1){
                    houses.add(new int[]{x, y});
                }
            }
        }

        // get the center of the houses
        int[] center = getCenter(houses);
        System.out.println(center[0] + ", " + center[1]);
        if(center[0] == -1 || center[1] == -1)
            return -1;

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(center);
        int totalDistance = Integer.MAX_VALUE;
        int layer = 0;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean found = false;
            for(int i = 0; i < size; i ++){
                int[] position = queue.poll();
                visited[position[0]][position[1]] = true;
                if(matrix[position[0]][position[1]] == 0){
                    found = true;
                    totalDistance = Math.min(totalDistance, getTotalDistance(houses, new int[]{position[0], position[1]}));
                }
            }

            layer ++;
            int lowerx = Math.max(0, center[0] - layer);
            int upperx = Math.min(matrix.length - 1, center[0] + layer);
            int lefty = Math.max(0, center[1] - layer);
            int righty = Math.min(matrix[0].length - 1, center[1] + layer);

            // if in this layer we found an empty space, then we do not need to search for next layer
            if(found)
                break;

            // if not found in this layer. Extend to the next layer
            // add lower and upper row
            for(int nexty = lefty; nexty <= righty; nexty ++){
                if(!visited[lowerx][nexty])
                    queue.offer(new int[]{lowerx, nexty});
                if(!visited[upperx][nexty])
                    queue.offer(new int[]{upperx, nexty});
            }

            //add left and right column
            for(int nextx = lowerx + 1; nextx <= upperx - 1; nextx ++){
                if(!visited[nextx][lefty])
                    queue.offer(new int[]{nextx, lefty});
                if(!visited[nextx][righty])
                    queue.offer(new int[]{nextx, righty});
            }
        }

        return totalDistance;
    }


    public static void main(String[] args){
        int[][] matrix = {
                {0, 1, 0, 0},
                {1, 0, 1, 1},
                {0, 1, 0, 0}
        };
        BuildPostOffice bpo = new BuildPostOffice();
        int ans = bpo.getMinimumDistance(matrix);
        System.out.println(ans);
    }
}
