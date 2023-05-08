package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
    public void storeUser(String userId, String password) {
        User user = new User(); // User 객체를 초기화 합니다.
        user.setUser(++increaseId, userId, password); // user data 값을 저장합니다.
        users.put(increaseId, user);
        for (Entry<Long, User> entrySet : users.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue()); // test code
        }
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
    public String vaildUser(String userId, String password) {
        // test login method
        User user1 = new User();
        user1.setUser(1, "yoho1019", "yoho10190@");
        users.put(1L, user1);
        User user2 = new User();
        user2.setUser(2, "yoho1018", "yoho10190@");
        users.put(2L, user2);
        User user3 = new User();
        user3.setUser(3, "yoho1017", "yoho10190@");
        users.put(3L, user3);
        users.forEach((id, value) -> {
            if (value.getUserId().equals(userId) || value.getPassword().equals(password)) {
                // 아이디가 같은지 확인하는 조건문입니다.
                msg = "메세지 보내기 성공입니다.";
            } else {
                msg = "아디이와 비밀번호가 맞는지 확인하세요";
                return;
            }
        });
        return msg;
    }

}
