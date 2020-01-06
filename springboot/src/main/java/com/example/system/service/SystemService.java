package com.example.system.service;

import com.example.model.SysInfo;
import org.springframework.stereotype.Service;

@Service
public interface SystemService {

    /**
     * 获取系统信息
     * @return
     */
    public SysInfo getSysInfo();
}
