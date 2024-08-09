```
FileReader reader = new FileReader("C:\\CT\\example.txt");
StringBuilder textBuilder = new StringBuilder();
int ch;

// 파일에서 모든 텍스트를 읽어 StringBuilder에 저장
while ((ch = reader.read()) != -1) {
textBuilder.append((char) ch);
}
reader.close();


FileReader를 사용하여 파일 "C:\\CT\\example.txt"를 읽음
StringBuilder를 사용하여 파일의 내용을 문자열로 변환
파일의 모든 문자를 읽어 StringBuilder에 추가한 후 파일을 

```


```
String patternString = "(?m)^(\\w+\\s*\\([^\\)]*\\))\\s*-\\s*Description:.*?\\s*Common Resolutions: (.*?)(?:\\s*[-|\\s]*Frame Rates: (.*?))\\s*-";

(?m): 멀티라인 모드를 활성화하여 ^와 $가 줄의 시작과 끝을 의미
^(\\w+\\s*\\([^\\)]*\\)): 줄의 시작에서 포맷 이름과 괄호 내 설명을 캡처
\\s*-\\s*Description:: Description: 앞의 하이픈과 공백을 처리
.*?: Description:과 Common Resolutions: 사이의 모든 문자를 캡처
\\s*Common Resolutions: (.*?): Common Resolutions: 이후의 해상도를 캡처
(?:\\s*[-|\\s]*Frame Rates: (.*?)): 선택적으로 Frame Rates: 이후의 프레임 레이트를 캡처

```

```
Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
Matcher matcher = pattern.matcher(text);

Pattern.compile(patternString, Pattern.DOTALL): 정규 표현식 패턴을 컴파일
Pattern.DOTALL 플래그는 .이 줄 바꿈 문자(\n)를 포함한 모든 문자를 매칭
Matcher matcher = pattern.matcher(text): 입력 텍스트에 대해 패턴 매처를 생성
```

```
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

matcher.find(): 정규 표현식과 일치하는 다음 부분을 찾음
matcher.group(1): 포맷 이름과 설명(괄호 포함)
matcher.group(2): 해상도 목록
matcher.group(3): 프레임 레이트 목록을 가져옵니다. null인 경우 빈 문자열로 처리
formatName.trim(): 포맷 이름의 앞뒤 공백을 제거
resolutions.split(",")[0].trim(): 해상도 목록에서 첫 번째 해상도를 추출
frameRates.split(",")[0].trim(): 프레임 레이트 목록에서 첫 번째 프레임 레이트를 추출

결과를 출력

```