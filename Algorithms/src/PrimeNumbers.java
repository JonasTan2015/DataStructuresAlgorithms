import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 1/20/2018.
 * 列出不大于N的所有Prime, 线性解法
 */
public class PrimeNumbers {

    public static void main(String[] args){
        PrimeNumbers pn = new PrimeNumbers();
        System.out.println(pn.getPrimes(100));
    }


    public List<Integer> getPrimes(int N){
        boolean[] isPrime = new boolean[N + 1];
        for(int i = 2; i <=N; i ++)
            isPrime[i] = true;
        isPrime[0] = false;
        isPrime[1] = false;
        List<Integer> primes = new LinkedList<>();

        for(int i = 2; i <= N; i ++){
            if(isPrime[i])
                primes.add(i);
            for(int j = 0; j < primes.size() && primes.get(j) * i <= N; j ++){
                isPrime[i * primes.get(j)] = false;
                if(i % primes.get(j) == 0)
                    break;
            }
        }

        return primes;
    }
}
