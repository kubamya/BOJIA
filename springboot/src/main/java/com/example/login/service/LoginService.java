package com.example.login.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface LoginService {

    //用户登录
    public Map<String, Object> login(Map<String, Object> queryParam);
}
