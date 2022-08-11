package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        List<Character> manual = skill.chars()
                .mapToObj(el -> (char) el)
                .collect(Collectors.toList());

        return (int) Arrays.stream(skill_trees)
                .filter(el -> isAvailable(manual, el))
                .count();
    }

    private boolean isAvailable(List<Character> manual, String skill) {
        int currentIdx = 0;

        for (char c : skill.toCharArray()) {
            if (!manual.contains(c)) continue;

            if (manual.get(currentIdx++) != c) {
                return false;
            }
        }

        return true;
    }
}
