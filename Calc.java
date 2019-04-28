import java.util.Scanner;

public class Calc {

    enum Operation {
        none,
        plus,
        minus,
        delete,
        exit,
        mult
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {
            int number1 = number();
            Operation operation = mathOperation();

            if (operation == Operation.exit) {
                continue;
            }

            int number2 = number();

            int result = calculation(number1, number2, operation);
            System.out.println("Результат: " + result);
            System.out.println("\n");
        }
    }
    
    private static int number() {

        System.out.println("Введите число:");

        int num;

        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("ошибка, пробуй еще раз");
            scanner.next();
            num = number();
        }

        return num;
    }

    private static Operation mapperFromChar(char symbol) {
        switch (symbol) {
            case '+':
                return Operation.plus;

            case '-':
                return Operation.minus;

            case '*':
                return Operation.mult;

            case '/':
                return Operation.delete;

            case 'q':
                return Operation.exit;

            default:
                return Operation.none;
        }
    }

    private static Operation mathOperation() {

        System.out.println("Выбери операцию: + , - , * , /");

        if (scanner.hasNext() == false) {
            System.out.println("ошибка, пробуй еще раз");
            return mathOperation();
        }

        char symbol = scanner.next().charAt(0);

        Operation opearationVariable = mapperFromChar(symbol);

        if (opearationVariable == Operation.none) {
            System.out.println("ошибка, пробуй еще раз");
            return mathOperation();
        }

        return opearationVariable;
    }


    private static int calculation (int number1, int number2, Operation operation) {

        int result;
        switch (operation) {
            case plus:
                result = number1 + number2;
                break;
            case minus:
                result = number1 - number2;
                break;
            case mult:
                result = number1 * number2;
                break;
            case delete:
                result = number1 / number2;
                break;
            case none:
            default:
                System.out.println("неверная операция. Попробуйте иначе");
                result = calculation(number1, number2, mathOperation());
        }
        return result;
     }
    }