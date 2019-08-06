package cn.com.taiji.security.securitydemo1.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @program: securityproject
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-02 16:23
 **/
@Entity
public class UserInfo {
    //    public enum Role{
//        ROLE_ADMIN,ROLE_USER
//    }
    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "UserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "rid")})
    private List<Role> roles;
    @Id
    @GeneratedValue
    private long uid;//主键.
    private String username;//用户名.
    private String password;//密码.
//    @Enumerated(EnumType.STRING)
//    private Role role;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
