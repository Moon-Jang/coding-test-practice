package programmers;

import java.util.Arrays;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int convertCnt = 0;
        int removeZeroCnt = 0;

        while (!s.equals("1")) {
            int sLength = s.length();
            int zeroCnt = getZeroCnt(s);

            s = convert(sLength, zeroCnt);

            removeZeroCnt += zeroCnt;
            convertCnt++;
        }

        return new int[]{convertCnt, removeZeroCnt};
    }

    private int getZeroCnt(String s) {
        int cnt = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt++;
            }
        }

        return cnt;
    }

    private String convert(int sLength, int zeroCnt) {
        return Integer.toBinaryString(sLength - zeroCnt);
    }
}
