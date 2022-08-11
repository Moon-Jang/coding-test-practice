package programmers;

public class 쿼드압축_후_개수_세기 {

    public int[] solution(int[][] arr) {
        return press(0,0, arr.length, arr);
    }

    public int[] press(int startRow, int startColumn, int rowSize, int[][] arr) {
        int zeroCnt = 0;
        int oneCnt = 0;

        if (rowSize == 2) {
            for (int i = startRow; i < startRow + 2; i++) {
                for (int j = startColumn; j < startColumn + 2; j++) {
                    if (arr[i][j] == 0) {
                        zeroCnt++;
                    } else {
                        oneCnt++;
                    }
                }
            }

            return generateResult(zeroCnt, oneCnt);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int row = startRow + ((rowSize / 2) * i);
                int column = startColumn + ((rowSize / 2) * j);
                int[] result = press(row, column, rowSize / 2, arr);
                zeroCnt += result[0];
                oneCnt += result[1];
            }
        }

        return generateResult(zeroCnt, oneCnt);
    }

    public int[] generateResult(final int zeroCnt, final int oneCnt) {
        if (zeroCnt == 0) {
            return new int[]{0, 1};
        }

        if (oneCnt == 0) {
            return new int[]{1, 0};
        }

        return new int[]{zeroCnt, oneCnt};
    }

}
