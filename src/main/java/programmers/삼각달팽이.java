package programmers;

public class 삼각달팽이 {
    public int[] solution(int n) {
        int[][] triangle = new int[n][];
        int totalCnt = 0;

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i+1];
            totalCnt += i+1;
        }

        String direction = "down";
        int[] position = new int[]{0, 0};

        for (int i = 1; i <= totalCnt; i++) {
            move(direction, i, triangle, position);
            direction = getNextDirection(direction, triangle, position);
        }

        return flatArray(triangle, totalCnt);
    }

    private void move(String direction, int number, int[][] triangle, int[] position) {
        final int row = position[0];
        final int column = position[1];

        switch (direction) {
            case "down":
                triangle[row][column] = number;
                position[0] = row + 1;
                break;
            case "up":
                triangle[row][column] = number;
                position[0] = row - 1;
                position[1] = column - 1;
                break;
            case "right":
                triangle[row][column] = number;
                position[1] = column + 1;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private String getNextDirection(String direction, int[][] triangle, int[] position) {
        final int row = position[0];
        final int column = position[1];

        switch (direction) {
            case "down":
                if (row + 1 >= triangle.length || triangle[row + 1][column] != 0) {
                    return "right";
                }
                break;
            case "up":
                if (row - 1 < 0 || triangle[row - 1][column - 1] != 0) {
                    return "down";
                }
                break;
            case "right":
                if (column + 1 >= triangle[row].length || triangle[row][column + 1] != 0) {
                    return "up";
                }
                break;
            default:
                throw new IllegalArgumentException();
        }

        return direction;
    }

    private int[] flatArray(int[][] triangle, int totalCnt) {
        int[] result = new int[totalCnt];
        int i = 0;

        for (int[] row : triangle) {
            for (int data : row) {
                result[i++] = data;
            }
        }

        return result;
    }
}
