package delta_search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author SSAFY
 *	배열의 크기와 좌표를 입력받아 상하좌우에 1을 표시하고 출력하는 프로그램을 작성하세요
 *
 */
public class FillCell02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		
		map[r][c]=1;
		
		// 상
		map[r-1][c]=1;
		// 하
		map[r+1][c]=1;
		// 좌
		map[r][c-1]=1;
		// 우
		map[r][c+1]=1;
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

}
