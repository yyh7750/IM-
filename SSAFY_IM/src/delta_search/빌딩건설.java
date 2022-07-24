package delta_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌딩건설 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[][] arr = new String[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = st.nextToken();
				}
			}

			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				loop: for (int j = 0; j < N; j++) {
					int rowCnt = 0;
					int colCnt = 0;
					for (int d = 0; d < 8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if (arr[nx][ny].equals("G")) {
								continue loop;
							}
						}
					}
					for (int l = 0; l < N; l++) {
						if (arr[i][l].equals("B")) {
							rowCnt++;
						}
						if (arr[l][j].equals("B")) {
							colCnt++;
						}
					}
					
					sum = rowCnt + colCnt - 1;
				}

				max = Math.max(max, sum);
			}
			
			System.out.println(max);
		}
	}
}