package me;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class 두배열_최소값Test {

    @Test
    void solution1() {
        int[] A = {1,3,2,1};
        int[] B = {4,2,5,3,2};
        int expectedResult = 2;

        assertEquals(expectedResult, new 두배열_최소값().solution(A,B));
    }

    @Test
    void solution2() {
        int[] A = {2,1};
        int[] B = {3};
        int expectedResult = -1;


        assertEquals(expectedResult, new 두배열_최소값().solution(A,B));
    }

    @Test
    void  test() {
        String date = "2022-02-31";
        assertFalse(Pattern.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}", date));
    }
}