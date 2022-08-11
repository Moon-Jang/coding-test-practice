package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];

            if (checkAround(place) == true) {
                answer[i] = 1;
                continue;
            }

            answer[i] = 0;
        }

        return answer;
    }

    private boolean checkAround(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!check(i, j, place)) return false;
                }
            }
        }

        return true;
    }

    private boolean check(int y, int x, String[] place) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                final int nextY = position[0] + directions[i][0];
                final int nextX = position[1] + directions[i][1];
                final int distance = Math.abs(nextY - y) + Math.abs(nextX - x);

                if (nextY < 0 || nextX < 0 || nextY >= 5 || nextX >= 5 || (nextY == y && nextX == x) || distance > 2) {
                    continue;
                }

                if (place[nextY].charAt(nextX) == 'P' && distance <= 2) {
                    return false;
                }

                if (place[nextY].charAt(nextX) == 'O' && distance < 2) {
                    queue.offer(new int[]{nextY, nextX});
                }
            }
        }

        return true;
    }
}
