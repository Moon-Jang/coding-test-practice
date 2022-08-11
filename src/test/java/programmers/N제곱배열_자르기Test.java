package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N제곱배열_자르기Test {

    @Test
    void solution() {
        int n = 3;
        int left = 2;
        int right = 5;
        int[] expectedResult = {3,2,2,3};

        assertArrayEquals(expectedResult, new N제곱배열_자르기().solution(n,left,right));
    }
}