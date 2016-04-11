package dk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 52947 on 07-04-2016.
 */
@Entity
@Table(name ="users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue()
    private int id;

    @NotEmpty
    @Column(name = "username", unique = true)
    private String username;

    @NotEmpty
    @Column (name = "password", unique = true)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @JsonIgnore
    //@NotEmpty
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userName")
    private Set<UserRole> userRoles;

    public User() {
    }


    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public User(String username, String password, boolean enabled, Set<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRoles = userRoles;
    }

}
