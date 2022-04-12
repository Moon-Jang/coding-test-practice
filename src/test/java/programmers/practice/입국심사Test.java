package programmers.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 입국심사Test {

    @Test
    void solution() {
        int n = 6;
        int[] times = {7, 10};

        assertEquals(28, new 입국심사().solution(n,times));
    }

    @Test
    void solution2() {
        int n = 10;
        int[] times = {6, 8, 10};

        assertEquals(30, new 입국심사().solution(n,times));
    }
}