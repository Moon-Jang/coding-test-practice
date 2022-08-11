package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 금과_은_운반하기Test {

    @Test
    void solution() {
        int a = 90;
        int b = 500;
        int[] g = {70,70,0};
        int[] s = {0,0,500};
        int[] w = {100,100,2};
        int[] t = {4,8,1};
        long expectedResult = 499;

        assertEquals(expectedResult, new 금과_은_운반하기().solution(a,b,g,s,w,t));

    }

    @Test
    void solution2() {
        int a = 10;
        int b = 10;
        int[] g = {100};
        int[] s = {100};
        int[] w = {7};
        int[] t = {10};
        long expectedResult = 50;

        assertEquals(expectedResult, new 금과_은_운반하기().solution(a,b,g,s,w,t));

    }
}