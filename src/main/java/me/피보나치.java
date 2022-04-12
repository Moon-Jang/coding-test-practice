package me;

public class 피보나치 {
    public int solution(int n) {
        long startTime = System.currentTimeMillis();
        int[] memo = new int[n + 1];
        int result = fibo(n, memo);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        return result;
    }

    private int fibo(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] == 0) {
            memo[n] = fibo(n-1, memo) + fibo(n - 2, memo);
        }

        return memo[n];
    }
}
