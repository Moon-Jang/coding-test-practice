package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 암호해독Test {

    @Test
    void solution() {
        String text = "23511011501782351112179911801562340161171141148";
        String result = new 암호해독().solution(text);
        String expectedResult = "Truth Always Wins ";

        assertEquals(result, expectedResult);
    }
}