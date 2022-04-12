package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N으로_표현Test {

    @Test
    void solution() {
        int n = 5;
        int number = 12;
        int expectedResult = 4;

        assertEquals(expectedResult, new N으로_표현().solution(n,number));
    }
}