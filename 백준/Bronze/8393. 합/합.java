import java.util.Scanner;
// 사용자로부터 n값을 입력을 받는다 
public class Main{
    public static void main(String[] args){
        //Scanner
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //System.out.println("n값을 입력하세요");
        int sum = 0;
        for (int i=1; i<=n; i++)
            sum += i;
        System.out.println(sum);
    }
}