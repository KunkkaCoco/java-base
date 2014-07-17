package algorithm.triangle;

import java.util.Scanner;

public class Triangle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入三角形的行数：");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			for (int x = 0; x < i; x++) {
				System.out.print(" ");
			}
			for (int y = i; y < 2 * n - i - 1; y++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}