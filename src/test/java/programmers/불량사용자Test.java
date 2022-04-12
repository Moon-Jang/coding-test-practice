package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class 불량사용자Test {

    @Test
    void solution() {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        int expectedResult = 2;

        assertEquals(expectedResult, new 불량사용자().solution(user_id, banned_id));
    }

    @Test
    void solution2() {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        int expectedResult = 3;

        assertEquals(expectedResult, new 불량사용자().solution(user_id, banned_id));
    }

    @Test
    void test() {

    }
}