package controller;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import model.User;

public class UsersMember implements UsersMembersInterface {

    // User Map {}
    // {id : id, userId : userId,password : password},

    private String msg; // response로 보내고 싶은 message
    private HashMap<Long, User> users = new HashMap<>();

    // user 고유의 id user가 생길때마다 ++1 해줍니다.
    private static long increaseId = 0L;

    // data 저장
    @Override
    public User storeUser(String userId, String password) {
        User user = new User(); // User 객체를 초기화 합니다.
        // error 사항은 계속 build 할때 key 값이 1로 중복되어서 나옴.
        // 고치기 위해서 build할때 json에서 key값을 받아오는게 좋아보임.
        JSONObject json = JsonFileRead.readFile();
        if (json != null) {
            increaseId = json.size(); // json의 객체 수의 따라 값을 넣어줍니다.
        }
        user.setUser(++increaseId, userId, password); // user data 값을 저장합니다.
        return user;
    }

    // 데이터 한번에 삭제
    @Override
    public void clearUsers() {
        users.clear(); // HashMap의 모든 data를 없애버립니다..
    }

    // 전체 회원 조회
    @Override
    public List<User> findAllUser() {
        return users.values().stream().toList();
    }

    // 특정 회원 찾기
    @Override
    public User findUser(Long id) {
        User findUser = users.get(id);
        return findUser;
    }

    @Override
    public String vaildUser(String userId, String password, JSONObject users) {

        for (int i = 1; i <= users.size(); i++) {
            String parsingId = Integer.toString(i);
            JSONObject user = (JSONObject) users.get(parsingId);
            String vaildUserId = user.get("userId").toString();
            String vaildPassword = user.get("password").toString();
            if (vaildPassword.equals(password) && vaildUserId.equals(userId)) {
                // return을 통해 filtering를 하며 user가 맞는지 검사합니다.
                return msg = "메세지 보내기 성공입니다.";
            } else {
                msg = "아디이와 비밀번호가 맞는지 혹은 있는지 확인하세요";
            }
        }
        return msg;
    }

}
