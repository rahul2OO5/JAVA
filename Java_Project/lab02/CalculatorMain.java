package lab02;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        
        System.out.print("Enter first operand: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second operand: ");
        double num2 = scanner.nextDouble();
        
        calc.setOperands(num1, num2);
        
        System.out.println("Addition: " + calc.calculateAddition());
        System.out.println("Subtraction: " + calc.calculateSubtraction());
        System.out.println("Multiplication: " + calc.calculateMultiplication());
        System.out.println("Division: " + calc.calculateDivision());
        
        scanner.close();
    }
}