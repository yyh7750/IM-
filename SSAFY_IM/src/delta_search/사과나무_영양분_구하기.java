package delta_search;

import java.util.Scanner;

public class 사과나무_영양분_구하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		solution(map);
	}
	
	private static void solution(int[][] map) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				int sum = 0;
				for(int d = 0; d < 4; d++) {
					int nr = dr[d] + i;
					int nc = dc[d] + j;
					
					if(nr < map.length && nr >= 0 && nc < map.length && nc >= 0) {
						sum += map[nr][nc];
					}
				}
				max = Math.max(sum + map[i][j], max);
			}
		}
		
		System.out.println(max);
	}
}