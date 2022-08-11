package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 이진_변환_반복하기Test {

    @Test
    void solution() {
        String s = "110010101001";
        int[] expectedResult = {3,8};

        assertArrayEquals(expectedResult, new 이진_변환_반복하기().solution(s));
    }
}