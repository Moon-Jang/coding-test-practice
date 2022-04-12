package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 온전한_이진트리Test {

    @Test
    void solution() {
        String text = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        String result = new 온전한_이진트리().solution(text);
        String expectedResult = "(A(B(D(E(G))))(C(F)))";

        assertEquals(result, expectedResult);
    }

    @Test
    void solution2() {
        String text = "(A,B) (C,D) (B,D)";
        String result = new 온전한_이진트리().solution(text);
        String expectedResult = "E1";

        assertEquals(result, expectedResult);
    }

    @Test
    void solution3() {
        String text = "(A,B) (B,D) (A,C) (A,E)";
        String result = new 온전한_이진트리().solution(text);
        String expectedResult = "E2";

        assertEquals(result, expectedResult);
    }

    @Test
    void solution4() {
        String text = "(A,C) (B,C)";
        String result = new 온전한_이진트리().solution(text);
        String expectedResult = "E3";

        assertEquals(result, expectedResult);
    }

    @Test
    void solution7() {
        String text = "(A,B) (B,D) (D,C) (C,A)";
        String result = new 온전한_이진트리().solution(text);
        String expectedResult = "E4";

        assertEquals(result, expectedResult);
    }

    @Test
    void solution5() {
        String text = "(B,C) (B,D) (D,X) (X,Z) (D,F)";
        String result = new 온전한_이진트리().solution(text);
        String expectedResult = "(B(C)(D(F)(X(Z))))";

        assertEquals(expectedResult, result);
    }



}