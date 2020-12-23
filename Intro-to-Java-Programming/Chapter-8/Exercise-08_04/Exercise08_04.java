/*********************************************************************************
* (Compute the weekly hours for each employee) Suppose the weekly hours for all  *
* employees are stored in a two-dimensional array. Each row records an employee’s*
* seven-day work hours with seven columns. For example, the following            *
* array stores the work hours for eight employees. Write a program that displays *
* employees and their total hours in decreasing order of the total hours.        *
*********************************************************************************/

import java.util.Scanner;

public class Exercise08_04 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees.");
        int employees = sc.nextInt();
        
        int[][] employeeHours = new int[employees][7];
        
        // Enter employee hours
        for (int row = 0; row < employeeHours.length; row++) {
            System.out.println("Enter hours for employee number: " + row);
            for (int column = 0; column < employeeHours[row].length; column++) {
                System.out.println("For day " + (column + 1));
                employeeHours[row][column] = sc.nextInt();
            }
        }
        
        int[][] totalHours = computeTotalHours(employeeHours);
        sort(totalHours);
        display(totalHours);
    }
    
    // Returns 7x2 matrix of employee number and total hours worked for the week
    public static int[][] computeTotalHours(int[][] employeeHours) {
        int[][] totalHours = new int[employeeHours.length][2];
        for (int row = 0; row < employeeHours.length; row++) {
            int total = 0;
            for (int column = 0; column < employeeHours[row].length; column++) {
                total += employeeHours[row][column];
            }
            totalHours[row][0] = row;
            totalHours[row][1] = total;
        }
        return totalHours;
    }
    
    // Sorts 7x2 matrix in decreasing order of column 1
    public static void sort(int[][] totalHours) {
        boolean sorted;
        do {
            sorted = true;
            int tempHour = 0;
            int tempRow = 0;
            for (int i = 0; i < totalHours.length - 1; i++) {
                if (totalHours[i + 1][1] > totalHours[i][1]) {
                    tempHour = totalHours[i][1];
                    tempRow = totalHours[i][0];
                    
                    totalHours[i][1] = totalHours[i + 1][1];
                    totalHours[i][0] = totalHours[i + 1][0];
                    
                    totalHours[i + 1][1] = tempHour;
                    totalHours[i + 1][0] = tempRow;
                    sorted = false;
                }
            }
        } while (!sorted);
    }
    
    // Prints employee number and total hours worked
    public static void display(int[][] totalHours) {
        for (int i = 0; i < totalHours.length; i++) {
            System.out.println("Employee number " + totalHours[i][0] + " has worked "
                    + totalHours[i][1] + " hours.");
        }
    }
}
