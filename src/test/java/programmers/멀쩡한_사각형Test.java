package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 멀쩡한_사각형Test {

    @Test
    void solution() {
        int W = 8;
        int H = 12;
        int expectedResult = 80;

        assertEquals(expectedResult, new 멀쩡한_사각형().solution(W,H));
    }

    @Test
    void solution2() {
        int W = 3;
        int H = 5;
        int expectedResult = 8;

        assertEquals(expectedResult, new 멀쩡한_사각형().solution(W,H));
    }
}

/*

public long calculate(int width, int height) {
        final int bigNum = width > height ? width : height;
        final int smallNum = width < height ? width : height;
        int gcd = 1; // 최대 공약수

        for (int i = 2; i <= smallNum; i++) {
            if (width % i == 0 && height % i == 0) {
                gcd = i;
            }
        }

        if (gcd != 1) {
            return bigNum / smallNum * gcd;
        }

        return result;
    }
 */