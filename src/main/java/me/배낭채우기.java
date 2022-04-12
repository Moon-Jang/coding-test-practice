package me;

public class 배낭채우기 {
    private int[][] memo;

    public int solution(int i, int w) {
        int[][] item = {{2,3}, {3,4}, {4,5}, {5,6}};
        memo = new int[i + 1][w + 1];

        for (int j = 0; j < i + 1; j++) {
            for(int z = 0; z < w + 1; z++) {
               memo[j][z] = -1;
            }
        }

        return foo(i,w, item);
    }

    private int foo(int i, int max, int[][] item) {
        if (i == 0 || max == 0) return 0;

        if (item[i-1][0] > max) {
            return getMemo(i -1, max, item);
        }

        int v = item[i-1][1];
        int w = item[i-1][0];
        int p1 = getMemo(i -1, max - w, item);

        int left = v + p1;
        int right = getMemo(i -1, max, item);

        return left > right ? left : right;
    }

    private int getMemo(int i, int max, int[][] item) {
        int value = memo[i][max];

        if (value == -1) {
            memo[i][max] = foo(i, max, item);
            return memo[i][max];
        }

        return value;
    }
}
