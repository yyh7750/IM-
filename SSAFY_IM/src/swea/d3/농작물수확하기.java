package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] arr = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = arr[j] - '0';
				}
			}
			
			int sum = 0;
			int cnt = 0;
			for (int i = N / 2; i >= 0; i--) {
				for (int j = i; j < N - i; j++) {
					sum += map[cnt][j];
				}
				cnt++;
			}
			for (int i = 1; i <= N / 2; i++) {
				for (int j = i; j < N - i; j++) {
					sum += map[cnt][j];
				}
				cnt++;
			}

			sb.append(sum).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}