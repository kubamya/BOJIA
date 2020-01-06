package com.example.production.service;

import com.example.model.Production;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ProductionService {

    /**
     * 新增产品信息
     * @param production
     */
    public void addProduction(Production production);

    /**
     * 修改产品信息
     * @param production
     */
    public void updateProduction(Production production);

    /**
     * 获取产品列表
     * @return
     */
    public List<Map<String, Object>> getProList();
}
