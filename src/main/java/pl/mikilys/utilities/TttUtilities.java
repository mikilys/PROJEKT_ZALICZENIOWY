package pl.mikilys.utilities;

public class TttUtilities {

    //if you dont'n win, then we play til end
    public static boolean isBoardFull(int[][] board) {

        boolean isFull = true;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i][j] == -1) {
                    isFull = false;
                }
            }
        }
        return isFull;

    }

    //board in 'zero'
    public static void initializeBoard(int[][] board) {

        //making rows
        for (int i=0; i<3; i++) {
            //making columns
            for (int j=0; j<3; j++) {
                board[i][j] = -1;
            }
        }

    };

    //checking winner
    public static int checkForWin(int[][] board) {

        int player = -1;
        if (TttUtilities.checkRowsForWin(board) > 0) {
            if (TttUtilities.checkColumnsForWin(board) > 0) {
                if (TttUtilities.checkDiagonalsForWin(board) > 0) {
                    player = TttUtilities.checkDiagonalsForWin(board);
                }
            } else {
                player = TttUtilities.checkColumnsForWin(board);
            }
        } else {
            player = TttUtilities.checkRowsForWin(board);
        }

        return player;

    }

    //three in row
    public static int checkRowsForWin(int[][] board) {

        int player = -1;
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                player = board[0][i];
            }
        }
        return player;

    }

    //three in column
    public static int checkColumnsForWin(int[][] board) {

        int player = -1;
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                player = board[i][0];
            }
        }
        return player;

    }

    //three in corss
    public static int checkDiagonalsForWin(int[][] board) {

        int player = -1;
        if (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0])) {
            player = board[1][1];
        }
        return player;

    }

    //checking three in a line for classical tic tac toe winner
    private static boolean checkRowCol(int c1, int c2, int c3) {

        return ((c1 != '-') && (c1 == c2) && (c2 == c3));

    }

    //checking the rows for a change in three in line
    private static int[][] checkRowsForChange(int[][] board, int[][] boardNew) {

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[2][i]) {
                boardNew[1][i] = board[0][i];
            }
        }
        return boardNew;

    }

    //checking the columns for a change in three in line
    private static int[][] checkColumnsForChange(int[][] board, int[][] boardNew) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][2]) {
                boardNew[i][1] = board[i][0];
            }
        }
        return boardNew;

    }

    //checking the cross for a change in three in line
    private static int[][] checkDiagonalsForChange(int[][] board, int[][] boardNew) {

        if (board[0][0] == board[2][2]) {
            boardNew[1][1] = board[0][0];
        } else if (board[0][2] == board[2][0]) {
            boardNew[1][1] = board[0][2];
        }
        return boardNew;

    }

    //making copy of array for changing the marks
    private static int[][] arrayCopy(int[][] board) {

        int[][] boardNew = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardNew[i][j] = board[i][j];
            }
        }
        return boardNew;

    }

    //counter after filling the board but with no winner
    public static int finalWinner(int[][] board) {

        int player = -1;
        int x = 0;
        int o = 0;

        int[][] boardNew = arrayCopy(board);

        checkRowsForChange(board, boardNew);
        checkColumnsForChange(board, boardNew);
        checkDiagonalsForChange(board, boardNew);

        if (isBoardFull(board)) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (boardNew[i][j] == 1) {
                        x++;
                    } else {
                        o++;
                    }
                }
            }
            if (x > o) {
                player = 1;
            } else {
                player = 0;
            }
        }

        return player;

    }

}
