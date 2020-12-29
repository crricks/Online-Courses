/*********************************************************************************
* (The Location class) Design a class named Location for locating a maximal      *
* value and its location in a two-dimensional array. The class contains public   *
* data fields row, column, and maxValue that store the maximal value and its     *
* indices in a two-dimensional array with row and column as int types and        *
* maxValue as a double type.                                                     *
*                                                                                *
* Write the following method that returns the location of the largest element in *
* a two-dimensional array:                                                       *
*                                                                                *
* public static Location locateLargest(double[][] a)                             *
*                                                                                *
* The return value is an instance of Location. Write a test program that prompts *
* the user to enter a two-dimensional array and displays the location of the     *
* largest element in the array.                                                  *
*********************************************************************************/

import java.util.Scanner;

public class Exercise09_13 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create array
        System.out.println("Enter the number of rows and columns in the array: ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        double[][] array = new double[rows][columns];
        
        System.out.println("Enter the array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.nextDouble();
            }
        }
        
        Location loc = locateLargest(array);
        System.out.println("The location of the largest element is " + loc);
    }
    
    // Locates largest number in array and returns as Location instance
    public static Location locateLargest(double[][] a) {
        
        // Start with temporary max number
        double max = a[0][0];
        int row = 0, column = 0;
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        return new Location(row, column, max);
    }
}
