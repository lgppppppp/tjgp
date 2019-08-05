package cn.com.taiji.security.securitydemo1.repository;

import cn.com.taiji.security.securitydemo1.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: securityproject
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-02 16:24
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    public UserInfo findByUsername(String username);
}
