package dk.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 52947 on 07-04-2016.
 */

@Entity
@Table(name = "userroles", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "username"}))
public class UserRole implements Serializable {

    private static final long serialVersionUID = -5624486190249028309L;

    @NotEmpty
    @Column(name = "rolename")
    private String roleName;

    @Id
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", foreignKey = @ForeignKey(name=" fk_authorities_user"))
    private User userName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public UserRole(){
    }

    public UserRole(String roleName, User userName) {
        super();
        this.roleName = roleName;
        this.userName = userName;
    }

}

