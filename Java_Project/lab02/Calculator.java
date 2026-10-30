package lab02;

public class Calculator {
    private double operand1;
    private double operand2;
    
    public void setOperands(double op1, double op2) {
        this.operand1 = op1;
        this.operand2 = op2;
    }
    
    public double calculateAddition() {
        return operand1 + operand2;
    }
    
    public double calculateSubtraction() {
        return operand1 - operand2;
    }
    
    public double calculateMultiplication() {
        return operand1 * operand2;
    }
    
    public double calculateDivision() {
        if (operand2 == 0) {
            System.out.println("Error: Division by zero.");
            return 0;
        }
        return operand1 / operand2;
    }
}