package programmers;

import java.util.*;

public class 양궁 {
    public int[] solution(int n, int[] info) {
        boolean[] visited = new boolean[info.length];
        List<int[]> list = new ArrayList<>();
        DFS(n, -1, info, visited, 0, 0, list);

        if (list.size() < 1) return new int[]{-1};

        return choice(list);
    }

    public int DFS(int n, int i, int[] info, boolean[] visited, int max, int current, List<int[]> list) {
        if (n < 1 || info.length <= i) {
            final int targetScore = getTargetScore(info, visited);
            final int sub = current - targetScore;

            if (sub > max) {
                list.clear();
                list.add(generateResult(n, info, visited));
            }

            if (sub == max) {
                list.add(generateResult(n, info, visited));
            }

            return sub > max ? sub : 0;
        }

        for (int j = i + 1; j < info.length; j++) {
            if (visited[j]) continue;
            if (n <= info[j] && info.length - 1 != j) continue;

            visited[j] = true;
            int result = DFS(n - info[j] - 1, j, info, visited, max, current + (10 - j), list);
            visited[j] = false;

            if (result > max) {
                max = result;
            }
        }

        return max;
    }

    private int[] choice(List<int[]> list) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int[] el : list) {
            map.put(getValue(el), el);
        }

        final int max = map.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new RuntimeException());

        return map.get(max);
    }

    private int getValue(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result += i;
            }
        }

        return result;
    }

    private int[] generateResult(int n, int[] info, boolean[] visited) {
        int[] result = new int[info.length];

        for (int i = 0; i < info.length; i++) {
            if (i == info.length - 1 && n < 0) {
                result[i] = info[i] + n + 1;
                break;
            }

            if (visited[i]) {
                result[i] = info[i] + 1;
            }
        }

        return result;
    }

    private static int getTargetScore(int[] info, boolean[] visited) {
        int result = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] > 0 && visited[i] == false) {
                result += 10 - i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        boolean[] visited = {true, true, true, true, true, true, false, false, false, false, true};

        System.out.println(양궁.getTargetScore(info, visited));
    }
}
