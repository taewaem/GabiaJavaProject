package user;

public class User {

    private String loginId;
    private String password;

    private String nickname;

    public User(String loginId, String password, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void userDuplicated(String loginId) {
        if (this.loginId.equals(loginId)) {
            System.out.println("중복 아이디");
        }
        else
            System.out.println("아이디 사용 가능");
    }
}
