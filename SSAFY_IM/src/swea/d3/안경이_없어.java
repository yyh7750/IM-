package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안경이_없어 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		loop: for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			String[] arr1 = st.nextToken().split("");
			String[] arr2 = st.nextToken().split("");

			int[] hole1 = new int[arr1.length];
			int[] hole2 = new int[arr2.length];

			if (arr1.length != arr2.length) {
				sb.append("DIFF").append("\n");
			} //
			else {
				for (int i = 0; i < hole1.length; i++) {
					if (arr1[i].equals("B")) {
						hole1[i] = 2;
					} //
					else if (arr1[i].equals("A") || arr1[i].equals("D") || arr1[i].equals("O") || arr1[i].equals("P")
							|| arr1[i].equals("Q") || arr1[i].equals("R")) {
						hole1[i] = 1;
					} //
					else {
						hole1[i] = 0;
					}
				}

				for (int i = 0; i < hole2.length; i++) {
					if (arr2[i].equals("B")) {
						hole2[i] = 2;
					} //
					else if (arr2[i].equals("A") || arr2[i].equals("D") || arr2[i].equals("O") || arr2[i].equals("P")
							|| arr2[i].equals("Q") || arr2[i].equals("R")) {
						hole2[i] = 1;
					} //
					else {
						hole2[i] = 0;
					}
				}

				for (int i = 0; i < arr1.length; i++) {
					if (hole1[i] != hole2[i]) {
						sb.append("DIFF").append("\n");
						continue loop;
					}
				}

				sb.append("SAME").append("\n");
			}
		}

		br.close();
		System.out.println(sb);
	}
}