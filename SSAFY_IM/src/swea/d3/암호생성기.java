package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			int cnt = 1;
			while (true) {
				if(cnt == 6) {
					cnt = 1;
				}
				
				int temp = q.poll() - cnt++;
				if (temp <= 0) {
					temp = 0;
					q.offer(temp);
					break;
				}

				q.offer(temp);
			}

			while (!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}
}