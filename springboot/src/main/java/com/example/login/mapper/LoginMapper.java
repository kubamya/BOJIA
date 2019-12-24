package com.example.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginMapper {

    //用户登录
    public Map<String, Object> login(Map<String, Object> queryParam);
}
