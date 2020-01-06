package com.example.system.service.impl;

import com.example.model.SysInfo;
import com.example.system.mapper.SystemMapper;
import com.example.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public SysInfo getSysInfo() {
        return systemMapper.getSysInfo();
    }
}
