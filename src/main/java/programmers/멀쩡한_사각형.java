package programmers;

public class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        final long totalSquare =  w * h;
        final long unavailableSquare = calculate(w, h);

        return totalSquare - unavailableSquare;
    }

    private long calculate(long width, long height) {
        if (width == height) {
            return width;
        }

        long gcd = getGCD(width, height); // 최대 공약수

        return  width + height-  gcd;
    }

    private long getGCD(long width, long height) {
        long temp;

        while (height != 0) {
            temp = width % height;
            width = height;
            height = temp;
        }

        return width; // 최대 공약수
    }

    public static void main(String[] args) {
        long a = 3;
        long b = 5;

        System.out.println(a * b / 2);
    }
}
