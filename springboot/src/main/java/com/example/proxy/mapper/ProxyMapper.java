package com.example.proxy.mapper;

import java.util.Map;

public interface ProxyMapper {

    /**
     * 根据城市名称获取城市代码
     * @param queryParams
     * @return
     */
    public Map<String, Object> getCityCode(Map<String, Object> queryParams);
}
