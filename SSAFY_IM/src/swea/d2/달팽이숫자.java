package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이숫자 {

	private static int N;
	private static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			solution(0, 0);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}

	private static void solution(int c, int r) {
		// 진행방향 : 우-하-좌-상
		int[] dc = { 0, 1, 0, -1 };
		int[] dr = { 1, 0, -1, 0 };

		int num = 1;
		arr[c][r] = num++;

		int turn = 0;
		while (num <= N * N) {
			int nc = c + dc[turn % 4];
			int nr = r + dr[turn % 4];

			if (nc >= 0 && nc < N && nr >= 0 && nr < N && arr[nc][nr] == 0) {
				arr[nc][nr] = num++;
				c = nc;
				r = nr;
			} //
			else {
				++turn;
				continue;
			}
		}
	}
}