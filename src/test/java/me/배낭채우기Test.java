package me;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 배낭채우기Test {

    @Test
    void solution() {
        int i = 2;
        int w = 5;

        assertEquals(7, new 배낭채우기().solution(i,w));
    }

    @Test
    void solution2() {
        int i = 2;
        int w = 3;

        assertEquals(4, new 배낭채우기().solution(i,w));
    }

    @Test
    void solution3() {
        int i = 4;
        int w = 2;

        assertEquals(3, new 배낭채우기().solution(i,w));
    }
}