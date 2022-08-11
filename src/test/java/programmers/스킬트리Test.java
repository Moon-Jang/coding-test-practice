package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 스킬트리Test {

    @Test
    void solution() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        final int expectedResult = 2;

        assertEquals(expectedResult, new 스킬트리().solution(skill, skill_trees));
    }
}