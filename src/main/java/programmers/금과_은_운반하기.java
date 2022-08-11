package programmers;

public class 금과_은_운반하기 {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long left = 0;
        long right = (long)Math.pow(10, 5) * 4 * (long)Math.pow(10, 9);
        final int cityLength = g.length;

        while (left <= right) {
            final long mid = (left + right) / 2;

            long currentGold = 0;
            long currentSilver = 0;
            long total = 0;

            for (int i = 0; i < cityLength; i++) {
                long deliveryCnt = mid / (t[i] * 2);

                if (mid % (t[i] * 2) > t[i]) deliveryCnt++;

                currentGold += deliveryCnt * w[i] > g[i] ? g[i] : deliveryCnt * w[i];
                currentSilver += deliveryCnt * w[i] > s[i] ? s[i] : deliveryCnt * w[i];
                total += deliveryCnt * w[i] > g[i] + s[i] ? g[i] + s[i] : deliveryCnt * w[i];
            }

            if (currentGold >= a && currentSilver >= b && total >= a + b) {
                right = mid -1;
                continue;
            }

            left = mid + 1;
        }

        return right;
    }
}
