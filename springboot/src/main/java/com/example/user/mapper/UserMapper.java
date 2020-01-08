package com.example.user.mapper;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserMapper {

    /**
     * 新增user
     * @param user
     */
    public void addUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 用户置为无效
     */
    public void setUserDisable(User user);

    /**
     * 获取用户列表
     * @param user
     * @return
     */
    public List<User> getUserList(User user);
}
