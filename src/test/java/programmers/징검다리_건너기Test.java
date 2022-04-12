package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 징검다리_건너기Test {

    @Test
    void solution() {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int expectedResult = 3;

        assertEquals(expectedResult, new 징검다리_건너기().solution(stones, k));
    }

    @Test
    void solution2() {
        int[] stones = {1000, 1000, 1000, 1000, 1000};
        int k = 1;
        int expectedResult = 1000;

        assertEquals(expectedResult, new 징검다리_건너기().solution(stones, k));
    }

    @Test
    void solution3() {
        int[] stones = {1};
        int k = 1;
        int expectedResult = 1;

        assertEquals(expectedResult, new 징검다리_건너기().solution(stones, k));
    }
}