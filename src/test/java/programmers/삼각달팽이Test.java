package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 삼각달팽이Test {

    @Test
    void solution() {
        int n = 4;
        int[] result = {1,2,9,3,10,8,4,5,6,7};

        assertArrayEquals(result, new 삼각달팽이().solution(n));
    }
}