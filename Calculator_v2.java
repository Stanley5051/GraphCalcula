import java.util.Scanner;

public class Calculator_v2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try (s) {
            System.out.print("Введите выражение\n");
            String input = s.nextLine();
            String[] parts = input.split(" ");

            if (parts.length != 3) {
                throw new Exception("Некорректный формат выражения");
            }
            int a, b;
            try {
                a = Integer.parseInt(parts[0]);
                b = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                throw new Exception("Нужно вводить числа");
            }


            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new Exception("Числа должны быть от 1 до 10 включительно");
            }

            String operator = parts[1];

            int result = calculate(a, b, operator);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("throws Exception // " + e.getMessage());
        }
    }

    public static int calculate(int a, int b, String operator) throws Exception {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new Exception("Деление на ноль невозможно");
                }
                yield a / b;
            }
            default -> throw new Exception("Некорректный оператор");
        };
    }
}