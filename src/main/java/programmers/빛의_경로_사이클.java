package programmers;

import java.util.ArrayList;
import java.util.List;

public class 빛의_경로_사이클 {
    public int[] solution(String[] grid) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        final int row = grid.length;
        final int column = grid[0].length();
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        boolean[][][] visited = new boolean[row][column][directions.length];


        for (int i = 0; i < directions.length; i++) {
            final int searchResult = search(0, 0, 0, i, row, column, grid, visited, directions);

            if (searchResult == -1) continue;

            result.add(searchResult);
        }

        return result.stream()
                .sorted((a,b) -> a - b)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int search(int r, int c, int cnt, int currentDirectionIdx, int row, int column, String[] grid, boolean[][][] visited, int[][] directions) {
        int[] current = new int[2];
        int nextDirectionIdx = 0;
        int[] leftRotation = {3, 2, 0, 1};
        int[] rightRotation = {2, 3, 1, 0};

        switch (grid[r].charAt(c)) {
            case 'S':
                current = movePosition(r, c, row, column, directions[currentDirectionIdx]);
                nextDirectionIdx = currentDirectionIdx;
                break;
            case 'L':
                nextDirectionIdx = leftRotation[currentDirectionIdx];
                current = movePosition(r, c, row, column, directions[nextDirectionIdx]);
                break;
            case 'R':
                nextDirectionIdx = rightRotation[currentDirectionIdx];
                current = movePosition(r, c, row, column, directions[nextDirectionIdx]);
                break;
            default:
                throw new IllegalArgumentException("잘못된 문자입니다.");
        }

        if (cnt != 0 && r == 0 && c == 0 && visited[r][c][nextDirectionIdx]) {
            return cnt;
        }

        if (visited[r][c][nextDirectionIdx]) {
            return -1;
        }

        visited[r][c][nextDirectionIdx] = true;

        return search(current[0], current[1], cnt + 1, nextDirectionIdx, row, column, grid, visited, directions);
    }

    private int[] movePosition(int r, int c, int row, int column, int[] direction) {
        int[] result = new int[2];
        int currentRow = r + direction[0];
        int currentColumn = c + direction[1];

        if (currentRow < 0) {
            currentRow = row - 1;
        }

        if (currentColumn < 0) {
            currentColumn = column - 1;
        }

        if (currentRow >= row) {
            currentRow = 0;
        }

        if (currentColumn >= column) {
            currentColumn = 0;
        }

        result[0] = currentRow;
        result[1] = currentColumn;

        return result;
    }
}
