import java.util.Scanner;

public class Exercise07_18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        System.out.println("Enter 10 doubles");
        
        for (int i = 0; i < 10; i++) {
            numbers[i] = Double.valueOf(sc.nextLine());
        }
        
        bubbleSort(numbers);
        
        for (double number : numbers) {
            System.out.print(number + " ");
        }
       
    }
    
    public static void bubbleSort(double[] numbers) {
        boolean search;
        do {
            search = false;
            double temp = 0;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] < numbers[i]) {
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1]; 
                    numbers[i + 1] = temp;
                    search = true;
                }
            } 
        } while (search);

    }
    
}
