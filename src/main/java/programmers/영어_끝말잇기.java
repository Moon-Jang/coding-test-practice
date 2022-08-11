package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();

        // 첫번째 차례
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String before = words[i - 1];
            String current = words[i];

            // 이전에 말한 단어들의 포함 될 경우
            if (usedWords.contains(current)) {
                return getResult(i ,n);
            }

            // 끝말이 이어지지 않을 경우
            if (before.charAt(before.length() -1) != current.charAt(0)) {
                return getResult(i, n);
            }

            usedWords.add(current);
        }

        return new int[]{0, 0};
    }

    private int[] getResult(int i, int n) {
        int failPerson = i % n + 1;
        int sequence = i / n + 1;
        return new int[]{failPerson, sequence};
    }
}
