package delta_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거미줄치기 {

	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution();
	}

	private static void solution() {
		int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1 };
		int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };
		int sx = 0;
		int sy = 0;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = 0;
				if(map[i][j] == 0) {
					temp++;
				}

				for (int d = 0; d < 8; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					int cnt = 0;

					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						for (int k = 0; k < N; k++) {
							if (cnt >= 2) {
								break;
							}
							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if (map[nx][ny] == 1) {
									cnt++;
								} //
								else {
									cnt = 0;
									temp++;
								}
							}
							nx += dx[d];
							ny += dy[d];
						}
					}
				}
				if (max < temp) {
					max = temp;
					sx = i; // 시작점x
					sy = j;	// 시작점y
				}
			}
		}
		System.out.println(max + " " + sx + " " + sy);
	}
}