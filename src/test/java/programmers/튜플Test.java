package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 튜플Test {

    @Test
    void solution() {
        String s = "{{2,1},{2},{2,1,3,4},{2,1,3}}";
        int[] expectedResult = {2, 1, 3, 4};
        int[] result = new 튜플().solution(s);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void solution2() {
        String s = "{{20,111},{111}}";
        int[] expectedResult = {111, 20};
        int[] result = new 튜플().solution(s);

        assertArrayEquals(expectedResult, result);
    }
}