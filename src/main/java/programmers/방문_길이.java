package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 방문_길이 {
    public int solution(String dirs) {
        Set<Edge> registeredEdges = new HashSet<>();
        Map<Character, int[]> directions = new HashMap<>();
        directions.put('R', new int[]{1,0});
        directions.put('L', new int[]{-1,0});
        directions.put('U', new int[]{0,1});
        directions.put('D', new int[]{0,-1});

        int[] currentPosition = new int[]{0,0};

        for (char d : dirs.toCharArray()) {
            final int x1 = currentPosition[0];
            final int y1 = currentPosition[1];
            final boolean moveResult = move(currentPosition, directions.get(d));

            if (!moveResult) continue;

            final int x2 = currentPosition[0];
            final int y2 = currentPosition[1];

            registeredEdges.add(new Edge(x1,y1, x2, y2));
        }

        return registeredEdges.size();
    }

    private boolean move(int[] currentPosition, int[] direction) {
        int nextX = currentPosition[0] +  direction[0];
        int nextY = currentPosition[1] +  direction[1];

        if (nextX > 5 || nextX < -5) {
            return  false;
        }

        if (nextY > 5 || nextY < -5) {
            return  false;
        }

        currentPosition[0] = nextX;
        currentPosition[1] = nextY;

        return true;
    }

    class Edge {
        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;

        public Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public int getX1() {
            return x1;
        }

        public int getY1() {
            return y1;
        }

        public int getX2() {
            return x2;
        }

        public int getY2() {
            return y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;

            Edge edge = (Edge) o;

            if ((getX1() == edge.getX1() && getY1() == edge.getY1())
                && (getX2() == edge.getX2() && getY2() == edge.getY2())) {
                return true;
            }

            if ((getX1() == edge.getX2() && getY1() == edge.getY2())
                    && (getX2() == edge.getX1() && getY2() == edge.getY1())) {
                return true;
            }

            return false;
        }

        @Override
        public int hashCode() {
            int result = 31;
            result *= 31 + (getX1() + getY1());
            result *= 31 + (getX2() + getY2());
            return result;
        }
    }
}
