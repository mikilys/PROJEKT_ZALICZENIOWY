package pl.mikilys.core;

import java.util.Scanner;

public class RunTheGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TTT game = new TTT();
        game.initializeBoard();
        System.out.println("Core game in console!");


        do {
            System.out.println("The board!");
            game.printBoard();
            int row;
            int col;

            do {

                System.out.println("Player " + game.getCurrentPlayerMark() + ", on which empty space '-' you want to put the mark?");
                System.out.print("Enter row: ");
                row = sc.nextInt()-1;
                System.out.print("Enter column: ");
                col = sc.nextInt()-1;

            }

            while (!game.placeMark(row, col));
            game.changePlayer();
        }

        while (!game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && !game.checkForWin()) {
            System.out.println("Nobody wins...");
        } else {
            System.out.println("And the board looks like: ");
            game.printBoard();
            game.changePlayer();;
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " wins!");
        }
    }
}
