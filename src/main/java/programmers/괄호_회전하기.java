package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s)) answer++;
            s = rotate(s);
        }

        return answer;
    }

    private String rotate(String s) {
        return s.substring(1) + s.charAt(0);
    }

    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> leftBrackets = Set.of('[', '{', '(');

        for (char c : s.toCharArray()) {
            if (leftBrackets.contains(c)) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) return false;

            char top = stack.peek();

            switch (c) {
                case ']':
                    if (top != '[') return false;
                    break;
                case '}':
                    if (top != '{') return false;
                    break;
                case ')':
                    if (top != '(') return false;
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            stack.pop();
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
