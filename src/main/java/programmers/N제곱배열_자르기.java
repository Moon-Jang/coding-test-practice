package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class N제곱배열_자르기 {
    public int[] solution(int n, long left, long right) {
        List<Long> result = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            final long x = i % n;
            final long y = i / n;

            result.add(Math.max(y, x) + 1);
        }

        return result.stream()
                .mapToInt(Long::intValue)
                .toArray();
    }
}
