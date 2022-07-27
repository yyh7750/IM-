package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 비밀번호 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			List<Character> list = new ArrayList<Character>();
			String str = st.nextToken();
			for(int i = 0; i < N; i++) {
				list.add(str.charAt(i));
			}
			
			for(int i = list.size() - 1; i > 0; i--) {
				if(list.get(i) == list.get(i-1)) {
					list.remove(i);
					list.remove(i-1);
					i = list.size();
				}
			}
			
			for(char c : list) {
				sb.append(c);
			}
			sb.append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}