package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 배달Test {

    @Test
    void solution() {
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        int expectedResult = 4;

        assertEquals(expectedResult, new 배달().solution(N, road, K));
    }
}