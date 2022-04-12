package programmers;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        Arrays.stream(skill)
                .map(s -> SkillFactory.create(s[0], s[1], s[2], s[3], s[4], s[5]))
                .forEach(s -> s.use(board));

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) answer++;
            }
        }
        return answer;
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
    }

    static class Attack extends Skill {
        public Attack(int r1, int c1, int r2, int c2, int degree) {
            super(r1, c1, r2, c2, degree);
        }

        @Override
        public void use(int[][] board) {
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    board[i][j] -= degree;
                }
            }
        }
    }

    static class Heal extends Skill {
        public Heal(int r1, int c1, int r2, int c2, int degree) {
            super(r1, c1, r2, c2, degree);
        }

        @Override
        public void use(int[][] board) {
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    board[i][j] += degree;
                }
            }
        }
    }
}
