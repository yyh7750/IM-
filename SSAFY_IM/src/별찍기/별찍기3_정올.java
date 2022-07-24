package 별찍기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기3_정올 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = N / 2;

		for (int i = 0; i <= n; i++) {
			for (int j = n; j > n - i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = n; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i * 2 - 1; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}