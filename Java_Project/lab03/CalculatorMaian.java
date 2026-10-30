package lab03;

class Calculator {
    private double operand1;
    private double operand2;

    public Calculator(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public double add() {
        return operand1 + operand2;
    }

    public double subtract() {
        return operand1 - operand2;
    }

    public double multiply() {
        return operand1 * operand2;
    }

    public double divide() {
        return operand1 / operand2;
    }
}

public class CalculatorMaian {
    public static void main(String[] args) {
        Calculator cal1 = new Calculator(15.5, 5.0);
        Calculator cal2 = new Calculator(100.0, 25.0);
        Calculator cal3 = new Calculator(9.0, 3.0);

        System.out.println(cal1.add());
        System.out.println(cal2.subtract());
        System.out.println(cal3.multiply());
        System.out.println(cal1.divide());
    }
}
