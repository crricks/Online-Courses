/*********************************************************************************
* (Game: connect four) Connect four is a two-player board game in which the      * 
* players alternately drop colored disks into a seven-column, six-row vertically * 
* suspended grid, as shown below.                                                *
* The objective of the game is to connect four same-colored disks in a row, a    * 
* column, or a diagonal before your opponent can do likewise. The program prompts* 
* two players to drop a red or yellow disk alternately. In the preceding figure, * 
* the red disk is shown in a dark color and the yellow in a light color. Whenever* 
* a disk is dropped, the program redisplays the board on the console and         *
* determines the status of the game (win, draw, or continue). Here is a sample   * 
* run:                                                                           *
*                                                                                *         
* Drop a yellow disk at column (0–6): 6                                          *
*  | | | | | | | |                                                               *
*  | | | | | | | |                                                               *
*  | | | |R| | | |                                                               *
*  | | | |Y|R|Y| |                                                               *
*  | | |R|Y|Y|Y|Y|                                                               *
*  |R|Y|R|Y|R|R|R|                                                               *
*  ———————————————                                                               *
*  The yellow player won                                                         *
*********************************************************************************/

import java.util.Scanner;

public class Exercise08_20 {

    public static void main(String[] args) {
        // Create board
        char[][] board = createBoard();
        printBoard(board);
        
        // Keep track of rounds
        int round = 0;
        
        // Start game
        do {
            playRound(board, round);
            printBoard(board);
            round++;
        } while (!won(board));
        
    }
    
    // Creates blank board in 6x7 char array
    public static char[][] createBoard() {
        char[][] board = new char[6][7];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = ' ';
            }
        }
        return board;
    }
    
    // Displays board 
    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print("|" + board[row][column]);
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("———————————————");
    }
    
    // Asks player to drop token depending on 
    public static char[][] playRound(char[][] board, int round) {
        Scanner sc = new Scanner(System.in);
        char player = (round % 2 == 0) ? 'R' : 'Y';
        int col;
        
        do {
            System.out.println("Drop a " + (player == 'R' ? "red" : "yellow")
                                + " disk at column (0-6): ");
            col = sc.nextInt();
        } while (col > 6 && col < 0);
        
        return updateBoard(board, col, player);
    }
    
    // Drops token into column and jumps up row if already filled
    public static char[][] updateBoard(char[][] board, int col, char player) {
        int row = board.length - 1;
        while (board[row][col] != ' ') {
            row--;
        }
        board[row][col] = player;
        return board;
    }
    
    /** Determines if game has been won horizontally, vertically, diagonally,
    or is a draw */
    public static boolean won(char[][] board) {
        return wonHoriz(board) || wonVert(board) || wonDiag(board) || isDraw(board);
    }
    
    // Checks if there are four tokens in a row 
    public static boolean wonHoriz(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            String horiz = "";
            for (int column = 0; column < board[row].length; column++) {
                horiz += board[row][column];
            }
            if (connectFour(horiz)) {
                return true;
            }
        }
        return false;
    }
    
    // Checks if there are four tokens in a column
    public static boolean wonVert(char[][] board) {
        for (int column = 0; column < board[0].length; column++) {
            String vert = ""; 
            for (int row = 0; row < board.length; row++) {
                vert += board[row][column];
            }
            if (connectFour(vert)) {
                return true;
            }
        }
        return false;
    }
    
    // Checks if there are four tokens along a diagonal
    public static boolean wonDiag(char[][] board) {
        // Check right diagonal
        for (int row = 0; row < 3; row++) {
            for (int k = 0; k < 4; k++) {
                String diag = "";
                for (int col = 0; col < 4; col++) {
                    diag += board[row + col][col + k];
                }
                if (connectFour(diag)) {
                    return true;
                }
            }
        }
        
        // Check left diagonal
        for (int row = 0; row < 3; row++) {
            for (int k = 0; k < 4; k++) {
                String diag = "";
                for (int col = 6, i = 0; col > 2; col--, i++) {
                    diag += board[row + i][col - k];
                }
                if (connectFour(diag)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    // Returns true if all entries are filled
    public static boolean isDraw(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column ++) {
                if (board[row][column] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("It's a draw");
        return true;
    }
    
    // Utilized by wonHoriz, wonVert, and wonDiag to see if there's a connect four
    public static boolean connectFour(String line) {
        if (line.contains("YYYY")) {
            System.out.println("The yellow player won!");
            return true;
        } else if (line.contains("RRRR")) {
            System.out.println("The red player won!");
            return true;
        }
        return false;
    }
    
}
