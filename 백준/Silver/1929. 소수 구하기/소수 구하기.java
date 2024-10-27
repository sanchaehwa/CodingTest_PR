//M과 N의 값을 입력 == Scanner Function
//소수를 판단하고 --> M 이상 N 이하의 소수를 출력 == 에라토스테네스의 체 알고리즘 
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    //M과 N 값을 입력받음
          Scanner sc = new Scanner(System.in);
          int M = sc.nextInt();
          int N = sc.nextInt();
          //에라토스테네스 체 알고리즘 원리 (1) : 배열을 생성
          boolean[] isNumbers = new boolean[N + 1];
          for (int i = 2; i <= N; i++) {
          //true 로 초기화 == 모든 수가 소수일 가능성을 염두해두고 시작함. 
              isNumbers[i] = true;
          }
         //에라토스테네스 체 알고리즘
         for (int i = 2; i * i <=N; i++){
             if(isNumbers[i]){
             //배수는 false
                 for(int j = i * i; j <= N; j+= i){
                     isNumbers[j] = false;
                 }
             }
         }
         for (int i = M; i<= N; i++){
             if(isNumbers[i]){
                 System.out.println(i);
             }
         }
         sc.close();
        }
    }
