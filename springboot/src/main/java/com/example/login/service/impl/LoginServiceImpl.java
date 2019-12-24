package com.example.login.service.impl;

import com.example.login.mapper.LoginMapper;
import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Map<String, Object> login(Map<String, Object> queryParam) {
        return loginMapper.login(queryParam);
    }
}
