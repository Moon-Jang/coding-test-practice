package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 파괴되지_않은_건물Test {

    @Test
    void solution() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] skill = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
        int expectedResult = 6;
        int result = new 파괴되지_않은_건물().solution(board, skill);

        assertEquals(result, expectedResult);
    }

    @Test
    void solution2() {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        int expectedResult = 6;
        int result = new 파괴되지_않은_건물().solution(board, skill);

        assertEquals(result, expectedResult);
    }
}