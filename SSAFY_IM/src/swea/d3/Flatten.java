package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());

			int[] arr = new int[100];
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[arr.length - 1]--;
			}
			
			Arrays.sort(arr);
			sb.append(arr[arr.length - 1] - arr[0]).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}
}