package service;

import org.json.simple.JSONObject;

import controller.JsonFileRead;
import controller.UsersMember;
import model.User;

public class UserService {
    UsersMember member = new UsersMember();
    static String response;

    // login 비지니스 로직
    public String login(String userId, String password) {
        // json data 가져오기
        JSONObject json = JsonFileRead.readFile();
        if (json == null) {
            // json file에 data가 아무것도 없다면..
            return response = "회원 data가 아무것도 없습니다.";
        }
        // 유효성 검사
        response = member.vaildUser(userId, password, json);

        return response;
    }

    // register 로직
    public String register(String userId, String password) {
        JSONObject json = JsonFileRead.readFile();
        if (userId.isEmpty() || password.isEmpty()) {
            return response = "ID 또는 password가 비어있습니다";
        }

        if (userId.length() < 3 || password.length() < 5) {
            return response = "userId는 최소 3개의 문자 | password는 최소 5개의 문자 입니다.";
        }
        if (userId.equals(password)) {
            return response = "userId 와 password는 같으면 안됩니다.";
        }
        User user = member.storeUser(userId, password);
        JsonFileRead.writeFile(json, user);
        return response = "회원등록이 완료되었습니다.";
    }
}
