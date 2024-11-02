import java.util.Scanner;

public class Main{
    static int N, S;
    static int[] numbers;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        dfs(0, 0);

        // S가 0일 때는 빈 집합을 제외하기 위해 count를 감소
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    public static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        dfs(index + 1, sum);  // 현재 원소를 포함하지 않는 경우
        dfs(index + 1, sum + numbers[index]);  // 현재 원소를 포함하는 경우
    }
}

/* dfs(0, 0)
├── dfs(1, 0)  -> dfs(index+1, sum)
│   ├── dfs(2, 0)
│   │   ├── dfs(3, 0) ->  sum
│   │   └── dfs(3, 3) -> sum + index
│   └── dfs(2, 2)
│       ├── dfs(3, 2)
│       └── dfs(3, 5)
└── dfs(1, 1)  sum + index
    ├── dfs(2, 1)
    │   ├── dfs(3, 1)
    │   └── dfs(3, 4)
    └── dfs(2, 3)
        ├── dfs(3, 3)
        └── dfs(3, 6)
 */