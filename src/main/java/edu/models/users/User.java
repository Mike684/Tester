package edu.models.users;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mike on 02.05.2017.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID userID;

    @Column(name = "user_name", length = 50, unique = true)
    private String userName;

    @Column(name = "password", length = 50, unique = true)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UAnswer> uAnswers;

    public User() {}

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

}
