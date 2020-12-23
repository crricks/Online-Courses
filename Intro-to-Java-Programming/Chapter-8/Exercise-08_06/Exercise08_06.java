/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clairericks
 */
import java.util.Scanner;

public class Exercise08_06 {
    
    public static void main(String[] args) {
        // Create matrix1 and matrix2
        System.out.println("Enter matrix1: ");
        double[][] m1 = getMatrix();
        System.out.println("Enter matrix2: ");
        double[][] m2 = getMatrix();
        
        double[][] m3 = multiplyMatrix(m1, m2);
        print(m1, m2, m3);
    }
    
    // Returns 3x3 matrix from user input
    public static double[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        
        double[][] m = new double[3][3];
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[row].length; column++) {
                m[row][column] = sc.nextDouble();
            }
        }
        return m;
    }
    
    // Multiplies two matrices and returns product
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] c = new double[3][3];
        for (int row = 0; row < c.length; row++) {
            for (int column = 0; column < c[row].length; column++) {
                c[row][column] = a[row][0] * b[0][column]
                                + a[row][1] * b[1][column]
                                + a[row][2] * b[2][column];
            }
        }
        return c;
    }
    
    // Displays matrices
    public static void print(double[][] a, double[][] b, double[][] c) {
        for (int row = 0; row < c.length; row++) {
            printRow(a, row);
            System.out.print((row == 1) ? " *  " : "    ");
            printRow(b, row);
            System.out.print((row == 1) ? " =  " : "    ");
            printRow(c, row);
            System.out.println("");
        }
    }
    
    // Prints specified row of matrix
    public static void printRow(double[][] m, int row) {
        for (int column = 0; column < m.length; column++) {
            System.out.printf("%.1f ", m[row][column]);
        }
    }
}
