package fileReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        // 파일 읽기
        FileReader reader = new FileReader("C:\\CT\\example.txt");

        StringBuilder textBuilder = new StringBuilder();
        int ch;

        // 파일에서 모든 텍스트를 읽어 StringBuilder에 저장
        while ((ch = reader.read()) != -1) {
            textBuilder.append((char) ch);
        }
        reader.close();

        // 텍스트를 문자열로 변환
        String text = textBuilder.toString();

        // 정규 표현식 패턴 정의
        String patternString = "(?m)^(\\w+\\s*\\([^\\)]*\\))\\s*-\\s*Description:.*?\\s*Common Resolutions: (.*?)(?:\\s*[-|\\s]*Frame Rates: (.*?))\\s*-";

        // Pattern 객체 생성
        Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        // 매칭된 결과를 찾고 출력
        while (matcher.find()) {
            String formatName = matcher.group(1).trim();
            String resolutions = matcher.group(2).trim();
            String frameRates = matcher.group(3) != null ? matcher.group(3).trim() : "";

            // 출력 포맷 설정
            System.out.println(formatName);

            // 첫 번째 해상도 출력
            String firstResolution = resolutions.split(",")[0].trim();
            System.out.println(firstResolution);

            // 첫 번째 fps 추출
            String firstFps = frameRates.split(",")[0].trim();
            System.out.println(firstFps);

            System.out.println();
        }
    }
}
