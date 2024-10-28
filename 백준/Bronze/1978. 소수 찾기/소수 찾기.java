import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        // 소수의 개수를 담을 변수
        int res = 0;
        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt();

            // a가 1이면 소수가 아니기때문에 아무것도 담지 않음
            if (a==1){
                res += 0;
                continue;
            }

            // 약수인지 확인
            int x = 0;
            for (int j = 2; j < a; j++) {
                if (a%j == 0) {
                    x++;
                }
            }

            // x가 0이면 소수이기 때문에 res ++함
            if (x == 0){
                res++;
            }

        }
        System.out.println(res);
    }
}