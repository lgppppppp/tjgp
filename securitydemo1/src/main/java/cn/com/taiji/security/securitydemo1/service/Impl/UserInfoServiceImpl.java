package cn.com.taiji.security.securitydemo1.service.Impl;

import cn.com.taiji.security.securitydemo1.domain.UserInfo;
import cn.com.taiji.security.securitydemo1.repository.UserInfoRepository;
import cn.com.taiji.security.securitydemo1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: securityproject
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-02 16:28
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}
