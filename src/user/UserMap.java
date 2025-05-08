package user;

import java.util.HashMap;

public class UserMap {
    HashMap<String, User> userMap = new HashMap<>();

    public void addUser(String loginId, String password, String nickname) {
        User user = new User(loginId, password, nickname);
        userMap.put(loginId ,user);
    }

    public User getUser(String loginId) {
        return userMap.get(loginId);
    }

    public boolean containsUser(String loginId) {
        return userMap.containsKey(loginId);
    }

}
