/**********************************************************************************
* (Game: bean machine) The bean machine, also known as a quincunx or the Galton   * 
* box, is a device for statistics experiments named after English scientist Sir   *
* Francis Galton. It consists of an upright board with evenly spaced nails (or    * 
* pegs) in a triangular form, as shown in Figure 7.13. Balls are dropped from the * 
* opening of the board. Every time a ball hits a nail, it has a 50% chance of     *
* falling to the left or to the right. The piles of balls are accumulated in the  * 
* slots at the bottom of the board. Write a program that simulates the bean       *
* machine. Your program should prompt the user to enter the number of the balls   *
* and the number of the slots in the machine. Simulate the falling of each ball   * 
* by printing its path. For example, the path for the ball in Figure 7.13b is     * 
* LLRRLLR and the path for the ball in Figure 7.13c is RLRRLRR. Display the final * 
* buildup of the balls in the slots in a histogram.                               *
**********************************************************************************/

import java.util.Scanner;

public class Exercise07_21 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of balls to drop: ");
        int balls = sc.nextInt();
        System.out.println("Enter the number of slots in the bean machine: ");
        int slotNum = sc.nextInt() - 1;
        
        int[] slots = new int[slotNum];
        for (int i = 0; i < balls; i++) {
            pathway(slotNum, slots);
        }
        System.out.println("");
        printSlots(balls, slots);
    }
    
    public static void pathway(int slotNum, int[] slots) {
        int path = slotNum;
        String journey = "";
        for (int i = 0; i < slotNum; i++) {
            if (Math.random() > .5) {
                journey += "R";
            } else {
                path--;
                journey += "L"; 
            }
        }
        System.out.println(journey);
        slots[path]++;
    }
    
    public static void printSlots(int balls, int[] slots) {
        for (int i = balls; i > 0; i--) {
            String level = "";
            for (int j = 0; j < slots.length; j++) {
                if (slots[j] >= i) {
                    level += "O";
                    slots[j]--;
                } else {
                    level += " ";
                }
            }
            if (level.contains("O")) {
                System.out.println(level);
            }
        }
    }
}
