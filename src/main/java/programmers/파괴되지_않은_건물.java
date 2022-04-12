package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] subBoard = new int[board.length + 1][board[0].length + 1];

        Arrays.stream(skill)
            .map(s -> SkillFactory.create(s[0], s[1], s[2], s[3], s[4], s[5]))
            .forEach(s -> s.use(subBoard));

        accumulateBoard(subBoard);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += subBoard[i][j];
            }
        }

        return (int) Arrays.stream(board)
                .flatMapToInt(el -> Arrays.stream(el))
                .filter(p -> p > 0)
                .count();
    }

    private void accumulateBoard(int[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 1; j < board.length; j++) {
                board[j][i] += board[j-1][i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] += board[i][j - 1];
            }
        }
    }
    static class SkillFactory {
        public static Skill create(int type, int r1, int c1, int r2, int c2, int degree) {
            if(type == 1) {
                return new Attack(r1,c1,r2,c2,degree);
            }

            if(type == 2) {
                return new Heal(r1,c1,r2,c2,degree);
            }

            return null;
        }
    }

    abstract static class Skill {
        protected final int r1;
        protected final int c1;
        protected final int r2;
        protected final int c2;
        protected final int degree;

        public Skill(int r1, int c1, int r2, int c2, int degree) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.degree = degree;
        }

        public abstract void use(int[][] board);

        @Override
        public String toString() {
            return "Skill{" +
                    "r1=" + r1 +
                    ", c1=" + c1 +
                    ", r2=" + r2 +
                    ", c2=" + c2 +
                    ", degree=" + degree +
                    '}';
        }
    }

    static class Attack extends Skill {
        public Attack(int r1, int c1, int r2, int c2, int degree) {
            super(r1, c1, r2, c2, degree);
        }

        @Override
        public void use(int[][] board) {
            board[r1][c1] -= degree;
            board[r2 + 1][c1] += degree;
            board[r1][c2 + 1] += degree;
            board[r2 + 1][c2 + 1] -= degree;
        }
    }

    static class Heal extends Skill {
        public Heal(int r1, int c1, int r2, int c2, int degree) {
            super(r1, c1, r2, c2, degree);
        }

        @Override
        public void use(int[][] board) {
            board[r1][c1] += degree;
            board[r2 + 1][c1] -= degree;
            board[r1][c2 + 1] -= degree;
            board[r2 + 1][c2 + 1] += degree;
        }
    }
}
