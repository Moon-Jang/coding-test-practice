package me;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 피보나치Test {

    @Test
    void solution() {
        int n = 40;
        int expectedResult = 2;

        assertEquals(expectedResult, new 피보나치().solution(n));
    }
}