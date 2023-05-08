package controller;

import java.util.List;

import model.User;

public interface UsersMembersInterface {
    // 잔체 유저 조회
    public List<User> findAllUser();

    // 개인의 user 조회
    public User findUser(Long id);

    // 전체 유저 초기화
    public void clearUsers();

    // User 객체에 data 넣기
    public void storeUser(String userId, String password);

    // 회원 일치 확인
    public String vaildUser(String userId, String password);
}
