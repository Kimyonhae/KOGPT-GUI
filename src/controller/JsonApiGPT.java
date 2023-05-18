package controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.text.ParseException;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonApiGPT {

    public static String errorMessage;
    public static StringBuilder testJSonObj;

    // env 파일에서 값을 가져옵니다.
    private static String searchToken() {
        try {
            File envFile = new File("env.txt");
            BufferedReader reader = new BufferedReader(new FileReader(envFile));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("토큰값을 얻었습니다!");
                return line;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // return 값은 이제 token 값 아니면 null 입니다.
    }

    public static JSONObject apiKoGPT(String jsonData) {
        try {
            String token_Key = JsonApiGPT.searchToken();
            URL url = new URL("https://api.kakaobrain.com/v1/inference/kogpt/generation"); // url 객체를생성합니다.

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection(); // 주소를 연결합니다.
            connection.setRequestMethod("POST"); // POST 방식을 나타냅니다.

            // 헤더 값 설정
            connection.setRequestProperty("Authorization", "KakaoAK " + token_Key);
            connection.setRequestProperty("Content-Type", "application/json");

            // 요청 데이터 설정
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonData);
            outputStream.flush();
            outputStream.close();

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                // 응답 내용 읽기
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                System.out.println(response.toString());
                // 응답의 내용을 JSONObject로 변환 합니다.
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(response.toString());
                return json;
            } else {
                System.out.println("API 호출 실패. 응답 코드: " + responseCode);
            }
            // 연결 종료
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("api 통신에서 문제가 있습니다.");
            e.printStackTrace();
        }
        return null;

    }
}

// test
// JSONParser parser = new JSONParser();
// JSONObject json = null;
// try {
// Reader reader = new FileReader("./src/database/chat.json");
// JSONObject jsonObject = (JSONObject) parser.parse(reader);
// json = jsonObject;
// reader.close();
// } catch (IOException e) {
// e.printStackTrace();
// } catch (org.json.simple.parser.ParseException e) {
// System.out.println("현재 User Json file에 data가 없습니다!");
// e.printStackTrace();
// }
// return json;