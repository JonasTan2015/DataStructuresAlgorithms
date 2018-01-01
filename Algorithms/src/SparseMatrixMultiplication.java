/**
 * Created by 310288079 on 7/3/2017.
 * Matrix is presented in this way List( ( x1, y1, val1), (x2, y2, val2) )
 * Compute the outcome of sparse matrix multiplication
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {
    public int[][] solve(int[][] A, int[][] B){
        HashMap<Integer, HashMap<Integer, Integer>> Amap = new HashMap<Integer, HashMap<Integer, Integer>>();
        HashMap<Integer, HashMap<Integer, Integer>> Bmap = new HashMap<Integer, HashMap<Integer, Integer>>();
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] != 0 ){
                    if(!Amap.containsKey(i)){
                        Amap.put(i, new HashMap<Integer, Integer>());
                    }
                    Amap.get(i).put(j, A[i][j]);
                }

            }
        }

        for(int i = 0; i < B.length; i ++){
            for(int j = 0; j < B[0].length; j ++){
                if(B[i][j] != 0){
                    if(!Bmap.containsKey(i)){
                        Bmap.put(i, new HashMap<Integer, Integer>());
                    }
                    Bmap.get(i).put(j, B[i][j]);
                }
            }
        }

        int[][] C = new int[A.length][B[0].length];
        for(Map.Entry<Integer, HashMap<Integer, Integer>> entry : Amap.entrySet()){
            int x = entry.getKey();
            for(Map.Entry<Integer, Integer> inner : entry.getValue().entrySet()){
                int y = inner.getKey();
                int val = inner.getValue();

                if(Bmap.get(y) == null)
                    continue;
                for(Map.Entry<Integer, Integer> b : Bmap.get(y).entrySet()){
                    int by = b.getKey();
                    int bval = b.getValue();
                    C[x][by] += val * bval;
                }
            }
        }

        for(int i = 0; i < C.length; i ++){
            for(int j = 0; j < C[0].length; j ++){
                System.out.print(C[i][j] + ", ");
            }
            System.out.println();
        }
        return C;
    }



    public static void main(String[] args){
        int[][] A = new int[3][3];

        A[0][0] = 1;
        A[1][1] = 2;
        A[2][0] = 3;
        A[2][2] = 4;

        int[][] B = new int[3][3];
        B[0][1] = 1;
        B[1][0] = 2;
        B[2][1] = 1;
        B[2][2] = 3;

        SparseMatrixMultiplication solution = new SparseMatrixMultiplication();
        solution.solve(A, B);

    }
}
