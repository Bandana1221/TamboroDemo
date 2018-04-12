package com.tamborodemo.questiontwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tictactoetest {

	static int n;

	public static void main(String[] args) throws Exception {

		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Grid size...");
			n = s.nextInt();
			if (n < 3) {
				throw new Exception("INVALID GRID SIZE");
			}
			int[][] board = new int[n][n];
			int player = 1;

			player = putPlayerIntoPosition(board, player);

			if (checkWinner(board, player)) {
				System.out.println("PLAYER X WON...");
			} else if (checkWinner(board, -player)) {
				System.out.println("PLAYER Y WON...");
			} else {
				System.out.println("NOBODY WON...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param board
	 * @param player
	 * @return
	 */
	private static boolean checkWinner(int[][] board, int player) {

		// Logic for rows
		for (int j = 0; j <= n - 1; j++) {
			for (int k = 0; k <= n - 1; k++) {
				int y = 0;
				for (int z = 0; z < n; z++) {
					y = y + board[j][k++];
				}
				if (y == player * n) {
					return true;
				}
			}
		}

		// Logic for columns
		for (int j = 0; j <= n - 1; j++) {
			for (int k = 0; k <= n - 1; k++) {
				int y = 0;
				for (int z = 0; z < n; z++) {
					y = y + board[k++][j];
				}
				if (y == player * n) {
					return true;
				}
			}
		}

		// Logic for diagonals
		for (int j = 0; j <= n - 1; j++) {
			for (int k = 0; k <= n - 1; k++) {
				int y = 0;
				for (int z = 0; z < n; z++) {
					y = y + board[k][k];
					k++;
				}
				if (y == player * n) {
					return true;
				}
			}
		}

		// Logic for diagonals
		for (int j = 0; j <= n - 1; j++) {
			for (int k = n - 1; k >= 0; k--) {
				int y = 0;
				int p = 0;
				int q = n - 1;
				for (int z = 0; z < n; z++) {
					y = y + board[p][q];
					if (p <= n - 1) {
						p++;
					}
					if (q >= 0) {
						q--;
					}
				}
				if (y == player * n) {
					return true;
				}
			}
		}

		return false;

		/*if (board[0][0] + board[1][0] + board[2][0] == player * 3
				|| board[0][1] + board[1][1] + board[2][1] == player * 3
				|| board[0][2] + board[1][2] + board[2][2] == player * 3
				|| board[0][0] + board[0][1] + board[0][2] == player * 3
				|| board[1][0] + board[1][1] + board[1][2] == player * 3
				|| board[2][0] + board[2][1] + board[2][2] == player * 3
				|| board[0][0] + board[1][1] + board[2][2] == player * 3
				|| board[0][2] + board[1][1] + board[2][0] == player * 3) {
			return true;
		} else {
			return false;
		}*/

	}

	/**
	 * @param board
	 * @param player
	 * @return
	 * @throws IOException
	 */
	private static int putPlayerIntoPosition(int[][] board, int player)
			throws IOException {
		int x = 0;
		int y = 0;
		int counter = 0;
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			if (counter % 2 == 0) {
				System.out.println("PLAYER X TURN.....");
			} else {
				System.out.println("PLAYER Y TURN.....");
			}
			System.out.println("Enter x and y coordinates to set position");
			x = Integer.parseInt(br.readLine());
			y = Integer.parseInt(br.readLine());
			System.out.println("POSITION....." + x + y + "\n");

			if (x < 0 || x > n - 1) {
				System.out.println("Invalid coordinate for x...");
			} else if (y < 0 || y > n - 1) {
				System.out.println("Invalid coordinate of y...");
			} else if (board[x][y] != 0) {
				System.out.println("Position occupied....");
			} else {
				counter++;
				if (counter % 2 == 0) {
					board[x][y] = -player;
					printboard(board);
				} else {
					board[x][y] = player;
					printboard(board);
				}

				if (counter >= 5) {
					if (checkWinner(board, player)) {
						System.out.println("PLAYER X WON...");
						System.exit(0);
					} else if (checkWinner(board, -player)) {
						System.out.println("PLAYER Y WON...");
						System.exit(0);
					}
				}

				if (counter == n * n) {
					return board[x][y];
				}
			}
		} while (board[x][y] != 0);
		return board[x][y];
	}

	private static void printboard(int[][] board) {
		for (int i = 0; i < n; i++) {
			System.out.print("| ");
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("___________________________");
		}
	}
}
