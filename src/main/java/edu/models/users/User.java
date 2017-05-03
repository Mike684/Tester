package edu.models.users;

import java.util.List;
import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
public class User {

    private UUID userID;

    private String userName;

    private String password;

    private List<UAnswer> uAnswers;

    public User() {
        userID = UUID.randomUUID();
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UAnswer> getuAnswers() {
        return uAnswers;
    }

    public void setuAnswers(List<UAnswer> uAnswers) {
        this.uAnswers = uAnswers;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password +
                '}';
    }
}
