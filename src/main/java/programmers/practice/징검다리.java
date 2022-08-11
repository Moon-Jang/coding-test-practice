package programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 징검다리 {

    public int solution(int distance, int[] rocks, int n) {
        int left = 0;
        int right = distance;
        Arrays.sort(rocks);

        int[] rockDistances = new int[rocks.length + 1];

        rockDistances[0] = rocks[0] - 0;
        rockDistances[rockDistances.length - 1] = distance - rocks[rocks.length - 1];

        for (int i = 1; i < rockDistances.length - 1; i++) rockDistances[i] = rocks[i] - rocks[i - 1];

        while (left <= right) {
            final int mid = (left + right) / 2;
            int removeCnt = 0;
            long current = 0;

            for (int i = 0; i < rockDistances.length; i++) {
                current += rockDistances[i];

                if (current < mid) {
                    removeCnt++;
                    continue;
                }

                current = 0;
            }

            if (removeCnt > n) {
                right = mid - 1;
                continue;
            }

            left = mid + 1;
        }

        return right;
    }
}
