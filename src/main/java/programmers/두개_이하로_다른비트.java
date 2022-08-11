package programmers;

public class 두개_이하로_다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        final long maxNumber = (long) Math.pow(10, 15);

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            // 짝수
            if (n % 2 == 0) {
                answer[i] = n + 1;
                continue;
            }

            // 홀수
            for (long bit = 1; bit < maxNumber; bit <<= 1) {
                if ((bit & n) != bit) {
                    answer[i] += n + (bit >> 1);
                    break;
                }
            }
        }

        return answer;
    }
}
