package practice1;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // 입력 받을 것
        Scanner sc = new Scanner(System.in);
        int number = 0;

        try {
            // 정수 입력 받기
            number = sc.nextInt();

            // 입력 값의 범위에 따라 다른 처리
            if (number >= 1000 && number <= 3000) {
                // 범위 내의 숫자에 대한 처리 추가
            } else {
            }

            // 543을 빼고 결과 출력
            int result = number - 543;
            System.out.println(result);

        } catch (InputMismatchException e) {

        } finally {
            // Scanner 닫기
            sc.close();
        }
    }
}