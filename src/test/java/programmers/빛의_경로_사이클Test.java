package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 빛의_경로_사이클Test {

    @Test
    void solution() {
        String[] grid = {"SL", "LR"};
        int[] result = {16};

        assertArrayEquals(result, new 빛의_경로_사이클().solution(grid));
    }

    @Test
    void solution2() {
        String[] grid = {"R", "R"};
        int[] result = {4,4};

        assertArrayEquals(result, new 빛의_경로_사이클().solution(grid));
    }
}