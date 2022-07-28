package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재미있는_오셀로게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];

			// 오셀로 초기값 설정
			map[N / 2][N / 2] = 2;
			map[N / 2 - 1][N / 2 - 1] = 2;
			map[N / 2 - 1][N / 2] = 1;
			map[N / 2][N / 2 - 1] = 1;

			for (int t = 0; t < M; t++) {
				st = new StringTokenizer(br.readLine());

				// 좌표값 입력받기
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int dol = Integer.parseInt(st.nextToken());
				map[x][y] = dol;

				// 팔방탐색
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (isChecked(nx, ny, N)) {
						// 탐색하는 곳이 다른 색 돌일 경우만 체크
						if (map[nx][ny] != 0 && map[nx][ny] != dol) {
							// 되돌아오면서 색을 바꾸기 위한 변수
							int cnt = 0;

							// 다른 색 돌이라면 같은 색 돌이 나올때까지 반복
							while (true) {
								nx += dx[d];
								ny += dy[d];

								if (isChecked(nx, ny, N)) {
									cnt++;
									if (map[nx][ny] == dol) {
										// 같은 색 돌이 나오면 되돌아가면서 같은색으로 바꾼다.
										for (int i = 0; i < cnt; i++) {
											nx -= dx[d];
											ny -= dy[d];
											if(isChecked(nx, ny, N)) {
												map[nx][ny] = dol;
											}
										}
										break;
									}
								} //
								else break;
							}
						}
					}
				}
			}

			int bDol = 0;
			int wDol = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						bDol++;
					} //
					else if (map[i][j] == 2) {
						wDol++;
					}
				}
			}

			br.close();
			sb.append(bDol).append(" ").append(wDol).append("\n");
			System.out.println(sb);
		}
	}

	private static boolean isChecked(int x, int y, int N) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}

		return false;
	}
}