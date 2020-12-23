/*********************************************************************************
* (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take     *
* turns marking an available cell in a 3 * 3 grid with their respective tokens   *
* (either X or O). When one player has placed three tokens in a horizontal,      *
* vertical, or diagonal row on the grid, the game is over and that player has    *
* won. A draw (no winner) occurs when all the cells on the grid have been filled *
* with tokens and neither player has achieved a win. Create a program for        *
* playing tic-tac-toe. The program prompts two players to enter an X token       *
* and O token alternately. Whenever a token is entered, the program redisplays   *
* the board on the console and determines the status of the game (win, draw, or  *
* continue).                                                                     *
*********************************************************************************/

import java.util.Scanner;

public class Exercise08_09 {
    
    public static void main(String[] args) {
        int round = 0;
        boolean won;
        
        // Create empty board
        String[][] board = {{" ", " ", " "}, {" ", " ", " "},{" ", " ", " "}};
        
        // Repeat while game is not won
        do {
            playRound(board, round);
            display(board);
            round++;
            won = won(board);
        } while (!won);
    }
    
    // Gets input from user - determines if X's or O's term depending on round number
    public static void playRound(String[][] board, int round) {
        Scanner sc = new Scanner(System.in);
        
        String player = (round % 2 == 0) ? "X" : "O";
        System.out.println("Enter a row (0, 1, or 2) for Player " + player + ":");
        int row = sc.nextInt();
        System.out.println("Enter a column (0, 1, or 2) for Player " + player + ":");
        int column = sc.nextInt();
        
        if (isValid(board, row, column)) {
            board[row][column] = player;
        } else {
            System.out.println("Please enter a valid entry");
        }
    }
    
    // Returns true if cell is empty and entry is in the 3x3 array
    public static boolean isValid(String[][] board, int row, int column) {
        if (row < 3 && row >= 0 && column < 3 && column >= 0) {
            if (board[row][column] == " ") {
                return true;
            }
        }
        return false;
    }
    
    // Displays board 
    public static void display(String[][] board) {
        System.out.println("——————-——————");
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print("| " + board[row][column] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("——————-——————");
    }
    
    // Determines whether game has been won or is a draw
    public static boolean won(String[][] board) {
        return wonRow(board) || wonCol(board) || wonDiag(board) || draw(board);
    }
    
    // Returns true if there are three X's or O's in a row
    public static boolean wonRow(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            String line = "";            
            for (int column = 0; column < board.length; column++) {
                line += board[row][column];
            }
            // Check is row consists of all X's or O's
            if (check(line)) {
                return true;
            }
        }
        return false;
    }
    
    // Returns true if there are three X's or O's in a column
    public static boolean wonCol(String[][] board) {
        for (int column = 0; column < board[0].length; column++) {
            String line = "";
            for (int row = 0; row < board.length; row++) {
                line += board[row][column];
            }
            // Check if col consists of all X's or O's
            if (check(line)) {
                return true;
            }
        }
        return false;
    }
    
    // Returns true if there are three X's or O's along either diagonal
    public static boolean wonDiag(String[][] board) {
        String line = board[0][0] + board[1][1] + board[2][2];
        if (check(line)) {
            return true;
        }
        line = board[0][2] + board[1][1] + board[2][0];
        if (check(line)) {
            return true;
        }
        return false;
    }
    
    // Returns true if all places on the board have been filled and neither has won
    public static boolean draw(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == " ") {
                    return false;
                }
            }
        }
        System.out.println("It's a draw.")
        return true;
    }
    
    // Utilized by wonRow, wonCol, and wonDiag to see if the line matches all O's or X's
    public static boolean check(String line) {
        if (line == "OOO") {
            System.out.println("O player won");
            return true;
        } else if (line == "XXX") {
            System.out.println("X player won");
            return true;
        }
        return false;
    } 
}
