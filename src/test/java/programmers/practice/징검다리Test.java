package programmers.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 징검다리Test {

    @Test
    void solution() {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        int expectedResult = 4;

        assertEquals(expectedResult, new 징검다리().solution(distance, rocks, n));

    }

    @Test
    void solution2() {
        int distance = 16;
        int[] rocks = {4, 8, 11};
        int n = 2;
        int expectedResult = 8;

        assertEquals(expectedResult, new 징검다리().solution(distance, rocks, n));

    }

    @Test
    void solution3() {
        int distance = 16;
        int[] rocks = {5,7};
        int n = 1;
        int expectedResult = 7;

        assertEquals(expectedResult, new 징검다리().solution(distance, rocks, n));

    }
    //16, [4, 8, 11], 2
}