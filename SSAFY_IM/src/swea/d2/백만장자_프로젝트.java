package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만장자_프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			int result = 0;
			int cnt = 0;
			int sum = 0;

			for (int i = N - 1; i >= 0; i--) {
				if (max < arr[i]) {
					result += (max * cnt) - sum;
					max = arr[i];
					cnt = 0;
					sum = 0;
				} //
				else {
					sum += arr[i];
					cnt++;
				}
			}
			
			result += (max * cnt) - sum;
			sb.append(result).append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}