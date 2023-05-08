package model;

// User의 객체이며 file에 넘겨질 data입니다.
public class User {
    long id;
    String userId; // Id
    String password; // password

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    // Setter
    public void setUser(long id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }
}
