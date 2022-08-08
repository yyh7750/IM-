package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			List<String> list = new ArrayList<String>();

			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}

			int cmd = Integer.parseInt(br.readLine());
			StringTokenizer cmdSt = new StringTokenizer(br.readLine(), "I ");

			for (int i = 0; i < cmd; i++) {
				int x = Integer.parseInt(cmdSt.nextToken());
				int y = Integer.parseInt(cmdSt.nextToken());

				for (int j = 0; j < y; j++) {
					list.add(x + j, cmdSt.nextToken());
				}
			}

			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}