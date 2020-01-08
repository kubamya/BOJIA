package com.example.user.service.impl;

import com.example.model.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import com.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.normalizer.UTF16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void setUserDisable(User user) {
        userMapper.setUserDisable(user);
    }

    @Override
    public List<Map<String, Object>> getUserList(User user) {
        List<User> userList = userMapper.getUserList(user);
        if(userList == null || userList.isEmpty()){
            return null;
        }

        List<Map<String,Object>> result = new ArrayList<>();
        for (User user1 : userList){
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", user1.getCId());
            userMap.put("userName", user1.getCUserName());
            userMap.put("loginId", user1.getCLoginId());
            userMap.put("email", user1.getCEmail());
            userMap.put("tel", user1.getCTel());
            userMap.put("cjsj", CommonUtil.dateToStr(user1.getDCjsj()));
            userMap.put("xgsj", CommonUtil.dateToStr(user1.getDXgsj()));

            result.add(userMap);
        }
        return result;
    }
}
