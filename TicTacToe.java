package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.clear();
            currentPlayer = player1;
            while (true) {
                board.print();
                System.out.println("Current Player: " + currentPlayer.getMarker());
                System.out.print("row (0-2): ");
                int row = scanner.nextInt();
                System.out.print("column (0-2): ");
                int col = scanner.nextInt();
                if (board.isCellEmpty(row, col)) {
                    board.place(row, col, currentPlayer.getMarker());
                    if (hasWinner()) {
                        board.print();
                        System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                        break;
                    }
                    if (board.isFull()) {
                        board.print();
                        System.out.println("It's a draw!");
                        break;
                    }
                    switchCurrentPlayer();
                } else {
                    System.out.println("Cell is not empty. Try again.");
                }
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board.cells[i][0] == currentPlayer.getMarker() &&
                    board.cells[i][1] == currentPlayer.getMarker() &&
                    board.cells[i][2] == currentPlayer.getMarker()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board.cells[0][i] == currentPlayer.getMarker() &&
                    board.cells[1][i] == currentPlayer.getMarker() &&
                    board.cells[2][i] == currentPlayer.getMarker()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (board.cells[0][0] == currentPlayer.getMarker() &&
                board.cells[1][1] == currentPlayer.getMarker() &&
                board.cells[2][2] == currentPlayer.getMarker()) {
            return true;
        }
        if (board.cells[0][2] == currentPlayer.getMarker() &&
                board.cells[1][1] == currentPlayer.getMarker() &&
                board.cells[2][0] == currentPlayer.getMarker()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
