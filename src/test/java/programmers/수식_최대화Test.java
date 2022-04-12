package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class 수식_최대화Test {

    @Test
    void solution() {
        String expression = "100-200*300-500+20";
        long result = 60420;
        assertEquals(result, new 수식_최대화().solution(expression));
    }

    @Test
    void test() {
        String expression = "100-200*300-500*20";
        long result = 60420;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(result, new 수식_최대화().solution(expression));
    }


}