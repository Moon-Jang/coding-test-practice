package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 방문_길이Test {

    @Test
    void solution() {
        String dirs = "ULURRDLLU";
        int answer = 7;

        assertEquals(answer, new 방문_길이().solution(dirs));
    }

    @Test
    void solution2() {
        String dirs = "LRLRL";
        int answer = 1;

        assertEquals(answer, new 방문_길이().solution(dirs));
    }
}