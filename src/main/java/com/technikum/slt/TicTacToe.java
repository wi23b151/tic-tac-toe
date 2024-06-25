package com.technikum.slt;

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

        public void start() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                board.print();
                System.out.println("Current Player: " + currentPlayer.getMarker());

                int row = -1;
                while (row < 0 || row >= board.getRowSize() ) {
                    System.out.print("Enter row (0-2): ");
                    row = scanner.nextInt();
                }
                int col = -1;
                while (col < 0 || col >= board.getColSize() )
                {
                    System.out.print("Enter column (0-2): ");
                     col = scanner.nextInt();
                }

                if (board.place(row, col, currentPlayer.getMarker())) {
                    if (board.checkWin(currentPlayer.getMarker())) {
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
                    System.out.println("Invalid move. Try again.");
                }
            }
            scanner.close();
        }

        private void switchCurrentPlayer() {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        public static void main(String[] args) {
            TicTacToe game = new TicTacToe();
            game.start();
        }
    }

