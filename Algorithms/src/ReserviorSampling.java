import java.util.Random;

/**
 * Created by 310288079 on 7/28/2017.
 */
public class ReserviorSampling {
    public void selectKItemsOutOfN(int k , int n){
        int[] reservior = new int[k];
        for(int i = 0; i < k; i ++){
            reservior[i] = i + 1;
        }

        Random rand = new Random();
        for(int i = k + 1; i <= n; i ++){
            int randomNumber = rand.nextInt(i);
            if(randomNumber < k){
                reservior[randomNumber] = i;
            }
        }
        for(int i = 0; i < reservior.length; i ++){
            System.out.print(reservior[i] + ", ");
        }
    }


    public static void main(String[] args){
        ReserviorSampling rs = new ReserviorSampling();
        rs.selectKItemsOutOfN(99, 200);
    }
}
