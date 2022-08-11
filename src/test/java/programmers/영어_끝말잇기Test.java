package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 영어_끝말잇기Test {

    @Test
    void solution() {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] expectedResult = new int[]{3,3};

        assertArrayEquals(expectedResult, new 영어_끝말잇기().solution(n,words));
    }
}