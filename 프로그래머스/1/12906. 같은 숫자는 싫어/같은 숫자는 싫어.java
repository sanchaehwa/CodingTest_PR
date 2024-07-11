import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
       // int[] answer = {};
        
      //  System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty() || stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
      //  System.out.println(Arrays.toString(answer));
        return answer;
    }
}