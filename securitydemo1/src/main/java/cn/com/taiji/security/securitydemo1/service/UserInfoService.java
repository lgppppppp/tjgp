package cn.com.taiji.security.securitydemo1.service;

import cn.com.taiji.security.securitydemo1.domain.UserInfo;

public interface UserInfoService {
    public UserInfo findByUsername(String username);
}