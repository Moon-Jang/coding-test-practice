package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N으로_표현 {
    public int solution(int N, int number) {
        int answer = 0;
        int[][] memo = new int[8][];

        if (number == N) return 1;

        memo[0][0] = N;

        for (int i = 1; i < 8; i++) {
            int[][] set = foo(i+1);
            for (int j = 0; j < set.length; j++) {
                int[] a = memo[set[j][0]];
                int[] b = memo[set[j][1]];

                for (int z = 0; z < a.length; z++) {
                    for (int x = 0; x < b.length; x++) {
                        memo[i][(z+1) * x] = a[z] * b[x];
                    }
                }
                System.out.println();
            }
        }

        return -1;
    }

    private int[][] foo(int n) {
        int[][] result = new int[n-1][];
        for(int i = 1; i < n; i++) {
            final int left = i;
            final int right = n - i;

            result[i-1] = new int[]{left, right};
        }

        return result;
    }
}
