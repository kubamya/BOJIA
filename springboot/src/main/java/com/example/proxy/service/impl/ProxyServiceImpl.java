package com.example.proxy.service.impl;

import com.example.proxy.mapper.ProxyMapper;
import com.example.proxy.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired
    private ProxyMapper proxyMapper;

    @Override
    public Map<String, Object> getCityCode(Map<String, Object> queryParams) {
        return proxyMapper.getCityCode(queryParams);
    }
}
