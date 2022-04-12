package me;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 정수삼각형Test {

    @Test
    void solution() {
        //int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        new 정수삼각형().solution(triangle);
    }
}