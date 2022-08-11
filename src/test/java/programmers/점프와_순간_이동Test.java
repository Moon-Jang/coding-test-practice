package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 점프와_순간_이동Test {

	@Test
	void solution() {
		int N = 5000;
		int expectedResult = 5;

		assertEquals(expectedResult, new 점프와_순간_이동().solution(N));
	}
}