package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("C:/Users/yyh77/git/algorithmmap/AlgorithmMap/src/_20220804/괄호짝짓기.txt")));
		StringBuilder sb = new StringBuilder();

		char[] open = { '[', '{', '(', '<' };
		char[] close = { ']', '}', ')', '>' };

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			char[] bracket = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 4; j++) {
					if (bracket[i] == open[j]) {
						stack.push(bracket[i]);
						break;
					} //
					else if (bracket[i] == close[j]) {
						if (stack.peek() == open[j]) {
							stack.pop();
						} //
						else {
							stack.push(bracket[i]);
						}
					}
				}
			}
			
			if(stack.isEmpty()) {
				sb.append(1).append("\n");
			} //
			else {
				sb.append(0).append("\n");
			}
		}
		
		br.close();
		System.out.println(sb);
	}
}