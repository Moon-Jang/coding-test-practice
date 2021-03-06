package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 주차요금계산Test {

    @Test
    void solution() {
        //given
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] expectedResult = {14600, 34400, 5000};
        //when
        int[] result = new 주차요금계산().solution(fees,records);
        //then

        assertArrayEquals(result, expectedResult);
    }
}