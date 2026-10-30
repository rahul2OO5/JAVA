package lab02;
import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements (N): ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        int sum = 0;
        int evenCount = 0;
        int oddCount = 0;
        int smallest = numbers[0];
        int largest = numbers[0];
        
        for (int num : numbers) {
            sum += num;
            
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            
            if (num < smallest) smallest = num;
            if (num > largest) largest = num;
        }
        
        double average = (double) sum / size;
        
        System.out.println("\nArray Statistics:");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Even elements: " + evenCount);
        System.out.println("Odd elements: " + oddCount);
        System.out.println("Smallest element: " + smallest);
        System.out.println("Largest element: " + largest);
        
        scanner.close();
    }
}