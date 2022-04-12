package me;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 배열_음수양수_최소값Test {

    @Test
    void solution() {
        int[] arr = {3,2,-2,5,-3};
        int expectedResult = 3;

        assertEquals(expectedResult, new 배열_음수양수_최소값().solution(arr));
    }

    @Test
    void solution1() {
        int[] arr = {3,1,-2,5,4};
        int expectedResult = -1;

        assertEquals(expectedResult, new 배열_음수양수_최소값().solution(arr));
    }
}