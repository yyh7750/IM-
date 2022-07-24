package delta_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 광부게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 시작점 초기화
				if (map[i][j] == 0) {
					x = i;
					y = j;
				}
			}
		}

		int cnt = 0;
		int cmd = Integer.parseInt(br.readLine());
		for (int i = 0; i < cmd; i++) {
			String command = br.readLine();

			if (command.equals("U")) {
				if (map[x - 1][y] > 0) {
					if (map[x - 1][y]-- <= 0) {
						cnt++;
						x -= 1;
					}
				} //
				else {
					x -= 1;
				}
			} //
			else if (command.equals("D")) {
				if (map[x + 1][y] > 0) {
					if (--map[x + 1][y] <= 0) {
						cnt++;
						x += 1;
					}
				} //
				else {
					x += 1;
				}
			} //
			else if (command.equals("R")) {
				if (map[x][y + 1] > 0) {
					if (--map[x][y + 1] <= 0) {
						cnt++;
						y += 1;
					}
				} //
				else {
					y += 1;
				}
			} //
			else if (command.equals("L")) {
				if (map[x][y - 1] > 0) {
					if (--map[x][y - 1] <= 0) {
						cnt++;
						y -= 1;
					}
				} //
				else {
					y -= 1;
				}
			} //
			else if (command.equals("X")) {
				int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1 };
				int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };

				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (map[nx][ny] > 0) {
							map[nx][ny] = 0;
							cnt++;
						}
					}
				}
			}
		}

		br.close();
		System.out.printf("광부 위치 : (%d, %d)\n", x, y);
		System.out.printf("부순 암석 개수 : %d", cnt);
	}
}