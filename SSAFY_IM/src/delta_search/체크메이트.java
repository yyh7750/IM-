package delta_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체크메이트 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[][] chess = new int[N][N]; // 0 배열 초기화

			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			chess[x1][y1] = 1;
			chess[x2][y2] = 1;

			if (isChecked(N, x1, y1, chess)) {
				sb.append(1).append("\n");
			} //
			else {
				sb.append(0).append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}

	private static boolean isChecked(int N, int x, int y, int[][] chess) {
		int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };

		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				for (int k = 0; k < N; k++) {
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (chess[nx][ny] == 1) {
							return true;
						} //
						else {
							nx += dx[d];
							ny += dy[d];
						}
					}
				}
			}
		}

		return false;
	}
}