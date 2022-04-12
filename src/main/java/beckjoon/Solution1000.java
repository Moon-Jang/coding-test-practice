package beckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        final int height = Integer.valueOf(firstLine[0]);
        final int width = Integer.valueOf(firstLine[1]);
        int[][] board = new int[height][width];
        boolean[][] visited = new boolean[height][width];
        String line = br.readLine();
        int i = 0;

        while (line != null) {
            char[] data = line.toCharArray();

            for (int j = 0; j <width; j++) {
                board[i][j] = Character.getNumericValue(data[j]);
            }

            line = br.readLine();
            i++;
        }

        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new int[]{0,0});
        int cnt = 0;
        int currentCnt = 0;
        int next = 0;


        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            List<String> directions = Arrays.asList("up", "down", "right");
            int addCnt = 0;
            for (String direction : directions) {
                if (direction.equals("up")) {
                    addCnt += add(current[0] - 1, current[1], board, visited, queue);
                    continue;
                }

                if (direction.equals("down")) {
                    addCnt += add(current[0] + 1, current[1], board, visited, queue);
                    continue;
                }

                if (direction.equals("right")) {
                    addCnt += add(current[0], current[1] + 1, board, visited, queue);
                    continue;
                }
            }

            if (currentCnt == next) {
                cnt++;
                continue;
            }
            
            cnt++;
            //depth += addCnt;
        }

        int result = 1;

        System.out.println(result);
    }

    private static int add(int y, int x, int[][] board, boolean[][] visited, Queue<int[]> queue) {
        final int width = board[0].length - 1;
        final int height = board.length - 1;

        if (x < 0 || x > width || y < 0 || y > height) return 0;
        if (visited[y][x]) return 0;
        if (board[y][x] == 0) return 0;

        visited[y][x] = true;
        queue.offer(new int[]{y,x});

        return 1;
    }
}