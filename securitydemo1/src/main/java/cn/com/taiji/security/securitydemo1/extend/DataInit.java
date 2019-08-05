package cn.com.taiji.security.securitydemo1.extend;

import cn.com.taiji.security.securitydemo1.domain.Role;
import cn.com.taiji.security.securitydemo1.domain.UserInfo;
import cn.com.taiji.security.securitydemo1.repository.RoleRepository;
import cn.com.taiji.security.securitydemo1.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: securityproject
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-02 17:22
 **/
@Service
public class DataInit {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void dataInit() {
        Role adminRole = new Role();
        adminRole.setRoleName("ROLE_ADMIN");
        adminRole.setDescription("管理员");
        Role normalRole = new Role();
        normalRole.setRoleName("ROLE_USER");
        normalRole.setDescription("普通用户");
        roleRepository.save(adminRole);
        roleRepository.save(normalRole);
        List<Role> roles = new ArrayList<>();
        roles.add(adminRole);
        roles.add(normalRole);
        UserInfo admin = new UserInfo();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setRoles(roles);
        userInfoRepository.save(admin);
        roles = new ArrayList<>();
        roles.add(normalRole);
        UserInfo user = new UserInfo();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRoles(roles);
        userInfoRepository.save(user);
    }
}
