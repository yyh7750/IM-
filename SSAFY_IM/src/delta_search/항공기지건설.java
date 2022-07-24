package delta_search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 항공기지건설 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/delta_search/항공기지건설_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열크기
			int K = sc.nextInt(); // 고도차
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			solution(map, N, K);
		}

		sc.close();
	}

	private static void solution(int[][] map, int N, int K) {

		int result = 0;

		// 시작점 순회
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = 0;

				// 끝점 순회
				// 시작점 (i, j), 끝점 (r, c)
				for (int r = i; r < N; r++) {
					for (int c = j; c < N; c++) {

						// 선택된 영역의 고도차 값들의 최대, 최솟값을 구한다.
						int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

						for (int a = i; a <= r; a++) {
							for (int b = j; b <= c; b++) {
								max = Math.max(max, map[a][b]);
								min = Math.min(min, map[a][b]);
							}
						}
						// 항공기지를 건설할 수 있다면 면적 구하기
						if (max - min <= K) {
							temp = Math.max(temp, (c - j + 1) * (r - i + 1));
						}
					}
				}

				result = Math.max(result, temp);
			}
		}

		System.out.println(result);
	}
}