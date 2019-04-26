import java.util.Scanner;

public class Calc {
  private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number1 = number();
        char operation = mathOperation();
        int number2 = number();

    int result = calculation(number1, number2, operation);
    System.out.println(result);
    }

        private static int number() {
            System.out.println("Введите число:");
            int num;
            if(scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                System.out.println("ошибка, пробуй еще раз");
                scanner.next();
                num = number();
            }
            return num;
            }
            private static char mathOperation() {
                System.out.println("Выбери операцию: + , - , * , /");
                char operation;
                if (scanner.hasNext()) {
                    operation = scanner.next().charAt(0);
                } else {
                    System.out.println("ошибка, пробуй еще раз");
                    scanner.next();
                    operation = mathOperation();
                }
                return operation;
            }

            private static int calculation (int number1, int number2, char operation) {
            int result;
            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
                default:
                    System.out.println("неверная операция. Попробуйте иначе");
                    result = calculation(number1, number2, mathOperation());
            }
            return result;
        }
    }