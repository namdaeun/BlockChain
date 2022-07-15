package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Util {

    public static String getHash(String input) { // 어떠한 입력값이 주어졌을 때 그에 맞는 해시 값을 저장
        StringBuffer result = new StringBuffer(); // 하나의 문자열을 만들 수 있는 객체
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");   // SHA-256 해시 알고리즘 적용
            md.update(input.getBytes());
            byte bytes[] = md.digest();
            for(int i = 0; i < bytes.length; i++) {
                result.append(
                        Integer.toString((bytes[i]& 0xff) + 0x100, 16).substring(1) // 다시 문자열 형태로 바꿔줌
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();    // 해시 결과 값 반환

    }

}