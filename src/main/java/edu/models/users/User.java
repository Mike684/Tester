package edu.models.users;

import java.util.List;
import java.util.UUID;

/**
 * User is a simple representation of a user.
 * Created by Mike on 02.05.2017.
 */
public class User {

    private UUID userID;

    private String userName;

    private String password;

    private List<UAnswer> uAnswers;

    /**
     * This is default constructor.
     */
    public User() {
        userID = UUID.randomUUID();
    }

    /**
     * This is a constructor to initialize entire User object.
     * @param userName an initial username.
     * @param password an initial password.
     */
    public User(String userName, String password){
        userID = UUID.randomUUID();
        this.userName = userName;
        this.password = password;
    }

    /**
     * Get user id.
     * @return user id.
     */
    public UUID getUserID() {
        return userID;
    }

    /**
     * Set user id.
     * @param userID is a new user id.
     */
    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    /**
     * Get username.
     * @return username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set username.
     * @param userName is a new username.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get password.
     * @return user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set new password.
     * @param password is a new user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get answer list of current user.
     * @return current user answers.
     */
    public List<UAnswer> getuAnswers() {
        return uAnswers;
    }

    /**
     * Set answers for current user.
     * @param uAnswers is a new answer list.
     */
    public void setuAnswers(List<UAnswer> uAnswers) {
        this.uAnswers = uAnswers;
    }

    /**
     * Get all user details in one string.
     * @return user details string.
     */
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", uAnswers=" + uAnswers +
                '}';
    }
}
