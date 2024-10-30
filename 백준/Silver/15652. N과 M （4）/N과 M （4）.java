import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static int[] result;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static Set<String> set = new HashSet<>(); //중복제거를 위한 Set

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];

        backtrack(1, 0);  // 1부터 시작
        System.out.println(sb.toString());
    }

    public static void backtrack(int start, int depth) {
        if (depth == M) {
            // Set에 넣으려면 참조 자체가 아닌 완성된 수열의 내용을 기준으로 중복을 검출해야 하기에 문자열로 변경
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                temp.append(result[i]).append(' ');
            }
            String sequence = temp.toString();
            // 중복 체크 (중복인걸 걸러내는)
            if (!set.contains(sequence)) {
                set.add(sequence); //중복이 아닌것 추가
                sb.append(sequence).append('\n'); //최종 결과
            }
            return;
        }
        //백트레이킹
        for (int i = start; i <= N; i++) {
            result[depth] = i;
            backtrack(i, depth + 1);
        }
    }
}