package com.technikum.slt;

public class Board {

        private char[][] cells;
        private static final int SIZE = 3;

        public Board() {
            cells = new char[SIZE][SIZE];
            clear();
        }

        public void clear() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    cells[i][j] = ' ';
                }
            }
        }

        public boolean isCellEmpty(int x, int y) {
            return cells[x][y] == ' ';
        }

        public boolean place(int x, int y, char marker) {
            if (isCellEmpty(x, y)) {
                cells[x][y] = marker;
                return true;
            }
            return false;
        }

        public boolean isFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (cells[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }

        public void print() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print("|" + cells[i][j]);
                }
                System.out.println("|");
            }
        }

        public boolean checkWin(char marker) {
            // Check rows and columns simultaneously
            for (int i = 0; i < SIZE; i++) {
                if ((cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) ||
                        (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker)) {
                    return true;
                }
            }
            // Check diagonals
            return (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) ||
                    (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker);
        }

        public int getRowSize() {
            return cells.length;
        }

        public int getColSize() {
            return cells[0].length;
        }
    }

