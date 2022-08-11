package programmers;

import java.util.*;
import java.util.stream.IntStream;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int[] distances = IntStream.range(0, N)
                .map(i -> 500001)
                .toArray();
        Queue<Edge> queue = new LinkedList<>();

        queue.offer(new Edge(0,0));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (distances[current.getPosition()] < current.getDistance()) continue;

            for (int[] r : road) {
                if (current.getPosition() != r[0] - 1 && current.getPosition() != r[1] - 1) continue;

                final int next = current.getPosition() == r[0] - 1 ? r[1] - 1 : r[0] - 1;
                final int distance = r[2];

                queue.offer(new Edge(next, current.getDistance() + distance));
            }

            distances[current.getPosition()] = current.getDistance();
        }


        return (int) Arrays.stream(distances)
                .filter(distance -> distance <= K)
                .count();
    }


    class Edge {
        private final int position;
        private final int distance;

        public Edge(int position, int distance) {
            this.position = position;
            this.distance = distance;
        }

        public int getPosition() {
            return position;
        }

        public int getDistance() {
            return distance;
        }
    }
}
