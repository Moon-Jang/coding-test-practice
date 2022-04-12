package beckjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1000Test {

    @Test
    public void test1() throws Exception {
        //given
        String inputExample = "4 6\n" +
                "101111\n" +
                "101010\n" +
                "101011\n" +
                "111011"; // 예제 입력
        String expectedResult = "1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputExample.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);

        //when
        Solution1000.main(new String[]{});

        //then
        String result = outputStream.toString();
        assertEquals(expectedResult, result);
    }

    @Test
    public void test2() throws Exception {
        //given
        String inputExample = "4 6\n" +
                "110110\n" +
                "110110\n" +
                "111111\n" +
                "111101";
        String expectedResult = "1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputExample.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);

        //when
        Solution1000.main(new String[]{});

        //then
        String result = outputStream.toString();
        assertEquals(expectedResult, result);
    }
}