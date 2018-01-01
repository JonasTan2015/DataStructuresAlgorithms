/**
 * Created by 310288079 on 8/26/2017.
 */
public class PathSum5 {

        public int pathSum(int[] nums) {

            boolean[] leaves = new boolean[15];
            for(int i = 0; i < 15; i ++){
                leaves[i] = true;
            }

            int[] sum = new int[15];

            for(int num : nums){
                int position = pos(num);
                System.out.println(num + ", " + position);
                int val = num % 10;
                int par = parent(position);
                System.out.println("parent"+ " " + par);

                if(par >= 0){
                    leaves[par] = false;
                    sum[position] += sum[par];
                }
                sum[position] += val;
            }

            int res = 0;
            for(int i = 0; i < 15; i ++){
                if(leaves[i]){
                    res += sum[i];
                }
            }
            return res;

        }

        private int pos(int num){
            int level = num / 100;
            System.out.print("level" + level);
            int place = num % 100 / 10;

            return (int)Math.pow(2, level - 1) - 1 + place - 1;
        }

        private int parent(int pos){
            return (pos - 1) / 2;
        }

        public static void main(String[] args){
            PathSum5 ps = new PathSum5();
            System.out.println("**************");
            System.out.println(ps.pathSum(new int[] {113}));
        }

}
