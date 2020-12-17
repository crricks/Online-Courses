
/*********************************************************************************
* (Merge two sorted lists) Write the following method that merges two sorted     *
* lists into a new sorted list.                                                  *
*                                                                                *
* public static int[] merge(int[] list1, int[] list2)                            *
*                                                                                *
* Implement the method in a way that takes at most list1.length + list2.         *
* length comparisons. Write a test program that prompts the user to enter two    *
* sorted lists and displays the merged list. Here is a sample run. Note that the *
* first number in the input indicates the number of the elements in the list.    *
* This numberis not part of the list.                                            *
*********************************************************************************/
import java.util.Scanner;

public class Exercise07_31 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter list1:");
        int[] list1 = new int[sc.nextInt()];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = sc.nextInt();
        }
        
        System.out.println("Enter list2:");
        int[] list2 = new int[sc.nextInt()];
        for (int i = 0; i < list2.length; i++) {
            list2[i] = sc.nextInt();
        }
        
        merge(list1, list2);
    }
    
    public static void merge(int[] list1, int[] list2) {
        int[] merged = new int[list1.length + list2.length];

        for (int i = 0; i < list1.length; i++) {
            merged[i] = list1[i];
        }
        
        for (int j = 0; j < list2.length; j++) {
            merged[j + list1.length] = list2[j];
        }
        
        java.util.Arrays.sort(merged);
        
        System.out.print("The merged list is: ");
        for (int k = 0; k < merged.length; k++) {
            System.out.print(merged[k] + " ");
        }
    }
}
