import java.util.*;

class Solution {
        boolean solution(String s){
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == '(') {
                    stack.push('(');
                }
                else if (s.charAt(i) == ')') {
                    if(stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
}
}
/*import java.util.*;
class Solution {
    boolean solution(String s) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }

            if (open < close ) {
                return false;
            }
        }
        if (open == close) {
        return true;
        }
        return false;
    }
} */
/*
입력된 문자열에서 여는 괄호와 닫는 괄호의 개수를 세어 나가보기
-> 여는 괄호 랑 닫는 괄호가 수가 같지 않다 
    : false
-> 여는 괄호 랑 닫는 괄호가 수가 같다 
    : true
    */