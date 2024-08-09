import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // 파일 읽기
        FileReader reader = new FileReader("C:\\CT\\example.txt");

        int ch;

        // 텍스트 파일에서 한 글자씩 글자를 읽고 하나의 char 를 리턴
        // 읽을 글자가 없다면, -1을 리턴함
        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

    }
}