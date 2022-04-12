package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 암호해독 {
    public String solution(String text) {
        StringBuilder sb = new StringBuilder(text);
        String reversedText = sb.reverse().toString();
        // 32 , 65 ~ 90 , 97 ~ 122
        List<String> asciiCodes = match(reversedText,"32|6[5-9]{1}|[7-8]{1}[0-9]{1}|9[0789]{1}|1[01]{1}[0-9]{1}|12[012]{1}");
        //32,65,110,112 << String
        return asciiCodes.stream()
                .mapToInt(Integer::valueOf)
                .mapToObj(m -> new Character((char)m))
                .map(m -> m.toString())
                .collect(Collectors.joining());
    }

    private List<String> match(String text, String regExp) {
        Matcher matcher = Pattern.compile(regExp).matcher(text);
        List<String> list = new ArrayList<>();

        while ( matcher.find() ) {
            list.add(matcher.group(0));
        }

        return list;
    }
}

/*
1. 암호해독
ASCII로 인코딩(encoded)된 문자열이 주어지면 이를 디코드해서 문자열을 리턴해주는 알고리즘
디코드 방법
 1) 문자열을 순서를 뒤집는다.
 2) 아스키코드를 문자로 변환한다.
   - 아스키코드 65 ~90은 A-Z,  97 ~112은 a-z, 32는 공백(" " )
예) input = 23511011501782351112179911801562340161171141148
     output = "Truth Always Wins "
 */

