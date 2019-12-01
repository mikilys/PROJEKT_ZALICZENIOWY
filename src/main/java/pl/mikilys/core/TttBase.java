package pl.mikilys.core;

public class TttBase {

    private char[][] board, boardNew;
    public char currentPlayerMark;

    public TttBase() {

        board = new char[3][3];
        boardNew = new char[3][3];
        currentPlayerMark = 'x';

        initializeBoard();

    };

    public char getCurrentPlayerMark() {

        return currentPlayerMark;

    }

    public void initializeBoard() {

        //making rows
        for (int i=0; i<3; i++) {
            //making columns
            for (int j=0; j<3; j++) {
                board[i][j] = '-';
            }
        }

    };

    public void printBoard() {

        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }

    }

    //temporary helpful board
    public void printBoardNew() {

        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(boardNew[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }

    }

    public boolean isBoardFull() {

        boolean isFull = true;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;

    }

    //Base TTT!
    public boolean checkForWin() {

        boolean winner = false;

        if (!checkRowsForWin()==true) {
            if (!checkColumnsForWin()==true) {
                if (checkDiagonalsForWin()==true) {
                    winner = checkDiagonalsForWin();
                }
            } else {
                winner = checkColumnsForWin();
            }
        } else {
            winner = checkRowsForWin();
        }

        return winner;

    }

    private boolean checkRowsForWin() {

        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;

    }

    private boolean checkColumnsForWin() {

        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;

    }

    private boolean checkDiagonalsForWin() {

        if (checkRowCol(board[0][0], board[1][1], board[2][2]) == true || checkRowCol(board[0][2], board[1][1], board[2][0]) == true) {
            return true;
        }
        return false;

    }

    private boolean checkRowCol(char c1, char c2, char c3) {

        return ((c1 != '-') && (c1 == c2) && (c2 == c3));

    }

    public void changePlayer() {

        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        } else {
            currentPlayerMark = 'x';
        }

    }

    public boolean placeMark(int row, int col) {

        //not over board
        if ((row>=0) && (row<3)) {
            if ((col>=0) && (col<3)) {
                if (board [row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
        return false;

    }

    //Let's the fun begin!
    public char finalCounter() {

        char mark = '-';
        int x = 0;
        int o = 0;

        arrayCopy();
        checkRowsForChange();
        checkColumnsForChange();
        checkDiagonalsForChange();

        if (isBoardFull() == true) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (boardNew[i][j] == 'x') {
                        x++;
                    } else {
                        o++;
                    }
                }
            }
            if (x > o) {
                mark = 'x';
            } else {
                mark = 'o';
            }
        }

        return mark;

    }

    public char[][] checkRowsForChange() {

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[2][i]) {
                boardNew[1][i] = board[0][i];
            }
        }
        return boardNew;

    }

    private char[][] checkColumnsForChange() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][2]) {
                boardNew[i][1] = board[i][0];
            }
        }
        return boardNew;

    }

    private char[][] checkDiagonalsForChange() {

        if (checkRowColForMatch(board[0][0], board[1][1], board[2][2]) == true) {
            boardNew[1][1] = board[0][0];
        } else if (checkRowColForMatch(board[0][2], board[1][1], board[2][0]) == true) {
            boardNew[1][1] = board[0][2];
        }
        return boardNew;

    }

    public void arrayCopy() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardNew[i][j] = board[i][j];
            }
        }

    }

    private boolean checkRowColForMatch(char c1, char c2, char c3) {

        return ((c1 != '-') && (c1 == c2) && (c2 == c3));

    }

}
