package lab02;
import java.util.Scanner;

public class NumberAnalyzer {
    
    public static boolean checkPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    public static boolean checkPalindrome(int number) {
        int original = number;
        int reverse = 0;
        while (number > 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        return original == reverse;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        
        if (checkPrime(num)) {
            System.out.println(num + " is a Prime number.");
        } else {
            System.out.println(num + " is Not Prime.");
        }
        
        if (checkPalindrome(num)) {
            System.out.println(num + " is a Palindrome.");
        } else {
            System.out.println(num + " is Not a Palindrome.");
        }
        
        scanner.close();
    }
}