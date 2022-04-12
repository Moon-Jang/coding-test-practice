package me;

import java.util.ArrayList;
import java.util.List;

public class 정수삼각형 {
    private int[][] memo;

    public int solution(int[][] triangle) {
        initMemo(triangle);
        final int lastFloor = triangle.length - 1;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < triangle[lastFloor].length; i++) {
            memo[lastFloor][i] = calculate(lastFloor, i, triangle);
            result.add(memo[lastFloor][i]);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    public int calculate(int i, int j, int[][] triangle) {
        if (i == 0) return triangle[0][0];
        int left = 0;
        int right = 0;

        // left
        if (j - 1 >= 0) {
            if (memo[i - 1][j - 1] != -1) {
                left = triangle[i][j] + memo[i - 1][j - 1];
            } else {
                memo[i - 1][j - 1] = calculate(i - 1, j - 1, triangle);
                left = triangle[i][j] + memo[i - 1][j - 1];
            }
        }

        // right
        if (j < triangle[i].length - 1) {
            if (memo[i - 1][j] != -1) {
                right = triangle[i][j] + memo[i - 1][j];
            } else {
                memo[i - 1][j] = calculate(i - 1, j, triangle);
                right = triangle[i][j] + memo[i - 1][j];
            }

        }

        return left > right ? left : right;
    }

    private void initMemo(int[][] triangle) {
        memo = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            memo[i] = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                memo[i][j] = -1;
            }
        }
    }
}
