package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        final int min = Arrays.stream(stones)
                .min()
                .getAsInt();
        final int max = Arrays.stream(stones)
                .max()
                .getAsInt();

        if (min == max) return max;

        return search(min, max, k, stones);
    }
    private int search(int left, int right, int k, int[] stones) {
        final int mid = (left + right) / 2;

        if (left >= right) return right - 1;

        if (isCross(mid, k, stones)) {
            return search(mid + 1, right, k, stones);
        }

        return search(left, mid, k, stones);
    }

    private boolean isCross(int cnt, int k, int[] stones) {
        int blockCnt = 0;

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - cnt > -1) {
                blockCnt = 0;
                continue;
            }

            blockCnt++;

            if (blockCnt >= k) return false;
        }

        return true;
    }
}
