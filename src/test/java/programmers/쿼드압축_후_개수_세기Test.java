package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 쿼드압축_후_개수_세기Test {

    @Test
    void solution() {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[] expectedResult = {4,9};

        assertArrayEquals(expectedResult, new 쿼드압축_후_개수_세기().solution(arr));
    }
}