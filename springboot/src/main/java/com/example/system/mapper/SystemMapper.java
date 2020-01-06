package com.example.system.mapper;

import com.example.model.SysInfo;
import org.springframework.stereotype.Service;

@Service
public interface SystemMapper {

    /**
     * 获取系统信息
     * @return
     */
    public SysInfo getSysInfo();
}
