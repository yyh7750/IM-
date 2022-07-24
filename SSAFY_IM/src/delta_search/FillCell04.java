package delta_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author SSAFY 배열의 크기와 좌표를 입력받아 상하좌우에 지정된 길이만큼 1을 delta 방식으로 표시하고 출력하는 프로그램을
 *         작성하세요
 *
 *
 */
public class FillCell04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int cnt = sc.nextInt();

		map[r][c] = 1;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 1; i <= cnt; i++) {

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;

				// 지도 경계체크
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					map[nr][nc] = 1;
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}

	}

}
