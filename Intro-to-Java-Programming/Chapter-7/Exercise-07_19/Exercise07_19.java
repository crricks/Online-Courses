/*********************************************************************************
* (Sorted?) Write the following method that returns true if the list is already  *
* sorted in increasing order.                                                    *
*                                                                                *
* public static boolean isSorted(int[] list)                                     *
*                                                                                *
* Write a test program that prompts the user to enter a list and displays        *
* whether the list is sorted or not. Here is a sample run. Note that the first   *
* number in the input indicates the number of the elements in the list. This     *
* number is not part of the list.                                                *
*********************************************************************************/

import java.util.Scanner;

public class Exercise07_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the integers between 1 and 100: ");
        ArrayList<Integer> numbers = new ArrayList<>();
        
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 0) {
                break;
            }
            numbers.add(input);
        }
        

        for (int i = 1; i <= 100; i++) {
            int count = 0;
            for (int number : numbers) {
                if (i == number) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println(i + " occurs " + count + (count >= 2 ? " times" : " time"));
            }
        }
    } 
}
