package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 양궁Test {

    @Test
    void solution() {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] expectedResult  = {0,2,2,0,1,0,0,0,0,0,0};

        int[] result = new 양궁().solution(n,info);

        assertArrayEquals(result, expectedResult);
    }

    @Test
    void solution2() {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        int[] expectedResult  = {1,1,2,0,1,2,2,0,0,0,0};

        int[] result = new 양궁().solution(n,info);

        assertArrayEquals(result, expectedResult);
    }

    @Test
    void solution3() {
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] expectedResult  = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2};

        int[] result = new 양궁().solution(n,info);

        assertArrayEquals(result, expectedResult);
    }
}