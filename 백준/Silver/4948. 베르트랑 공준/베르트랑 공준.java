import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //List
        List<Integer> inputs = new ArrayList<>();


        while (true) {
            int N = sc.nextInt();
            //0일때는 예외처리
            if (N == 0) break;
            inputs.add(N);
        }

        //한줄에 하나의 데이터만 처리하게 (1을 입력하면 1보다 크고 2보다 작거나 같은 소수의 개수를 출력하게, 다른 수를 입력하면 그 수에 맞는)
        int maxN = inputs.stream().max(Integer::compare).orElse(0);
        boolean[] isPrime = new boolean[2 * maxN + 1];
        //소수
        for (int i = 2; i <= 2 * maxN; i++) {
            isPrime[i] = true;
        }
        //소수가아닌수
        for (int i = 2; i * i <= 2 * maxN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 2 * maxN; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        for (int N : inputs) {
            int count = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}