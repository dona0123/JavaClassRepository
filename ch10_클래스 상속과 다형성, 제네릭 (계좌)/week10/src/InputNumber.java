import java.util.InputMismatchException;
import java.util.Scanner;

public class InputNumber {

    // 숫자 문자로 구성된 하나의 문자열을 입력받아 이를 정수로 변환하는 함수
    public static int getInteger() {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("Enter a number: ");
                result = scanner.nextInt();
                isValidInput = true; // 정수가 입력되면 반복 종료
            } catch (InputMismatchException e) {
                scanner.nextLine(); // 입력 버퍼 비우기
                System.out.println("Not a valid integer. Please enter again.");
            }
        }

        scanner.close();
        return result;
    }

    public static void main(String[] args) {
        int n;

        n = getInteger();

        System.out.println("Convert to a number >> " + n);
    }
}
