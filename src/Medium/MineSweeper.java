package Medium;

public class MineSweeper {

	public static char[][] updateBoard(char[][] board, int[] click) {
		int m = board.length, n = board[0].length;
		int row = click[0], col = click[1];

		// clicked mine
		if (board[row][col] == 'M') {
			board[row][col] = 'X';
			return board;
		}

		if (board[row][col] == 'E') {

			int count = 0;
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i == 0 && j == 0) continue;
					if (row + i < 0 || row + i >= m || col + j < 0 || col + j >= n) continue;
					if (board[row + i][col + j] == 'M') {
						count++;
					}
				}
			}

			// no adjacent mine
			if (count == 0) {
				board[row][col] = 'B';
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (row + i < 0 || row + i >= m || col + j < 0 || col + j >= n) continue;
						click[0] = row + i;
						click[1] = col + j;
						updateBoard(board, click);
					}
				}
				
			} else { // with adjacent mine
				board[row][col] = (char)(count + '0');
				return board;
			}	
		}

		return board;
	}

	public static void main(String[] args) {
		char[][] board = { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' } };
		int[] click = { 3, 0 };

		System.out.println(updateBoard(board, click));
	}

}
