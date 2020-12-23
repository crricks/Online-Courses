/*********************************************************************************
* (Game: nine heads and tails) Nine coins are placed in a 3-by-3 matrix with some* 
* face up and some face down. You can represent the state of the coins using a   * 
* 3-by-3 matrix with values 0 (heads) and 1 (tails). Here are some examples:     *
*    0 0 0    1 0 1   1 1 0   1 0 1   1 0 0                                      *
*    0 1 0    0 0 1   1 0 0   1 1 0   1 1 1                                      *
*    0 0 0    1 0 0   1 0 0   1 0 0   1 1 0                                      *
* Each state can also be represented using a binary number. For example, the     * 
* preceding matrices correspond to the numbers                                   *
*   000010000 101001100 110100001 101110100 100111110                            *
* There are a total of 512 possibilities, so you can use decimal numbers 0, 1, 2,* 
* 3, . . . , and 511 to represent all states of the matrix. Write a program that * 
* prompts the user to enter a number between 0 and 511 and displays the          *
* corresponding matrix with the characters H and T. Here is a sample run:        *
* The user entered 7, which corresponds to 000000111. Since 0 stands for H and 1 *
* for T, the output is correct.                                                  *
*********************************************************************************/

import java.util.Scanner;

public class Exercise08_11 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 511: ");
        int num = sc.nextInt();
        int[] binary = getBinary(num);
        char[][] coin = convertToCoin(binary);
        print(coin);
    }
    
    // Converts decimal to binary
    public static int[] getBinary(int num) {
        int[] binary = new int[9];
        for (int i = binary.length - 1; i >= 0; i--) {
            int remainder = num % 2;
            num = num / 2;
            binary[i] = remainder;
        }
        return binary;
    }
    
    // Fills 3x3 matrix with either heads or tails depending on binary number
    public static char[][] convertToCoin(int[] binary) {
        char[][] coin = new char[3][3];
        int count = 0;
        for (int row = 0; row < coin.length; row++) {
            for (int column = 0; column < coin[row].length; column++) {
                coin[row][column] = (binary[count] == 0) ? 'H' : 'T';
                count++;
            }
        }
        return coin;
    }
    
    // Displays head/tails matrix
    public static void print(char[][] coin) {
        for (int row = 0; row < coin.length; row++) {
            for (int column = 0; column < coin[row].length; column++) {
                System.out.print(coin[row][column] + " ");
            }
            System.out.println("");
        }
    }
}
