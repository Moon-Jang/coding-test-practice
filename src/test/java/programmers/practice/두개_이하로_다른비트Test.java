package programmers.practice;

import org.junit.jupiter.api.Test;
import programmers.두개_이하로_다른비트;

import static org.junit.jupiter.api.Assertions.*;

class 두개_이하로_다른비트Test {

    @Test
    void solution() {
        long[] numbers = {2,7};
        long[] expectedResult = {3, 11};

        assertArrayEquals(expectedResult, new 두개_이하로_다른비트().solution(numbers));
    }

}