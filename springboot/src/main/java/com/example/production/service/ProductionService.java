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
    
    /**
     * 产品置为无效
     * @param production
     */
    public void setProDisable(Production production);

    /**
     * 获取代售产品列表
     * @return
     */
    public List<Map<String, Object>> getSellProList();

    /**
     * 根据产品id获取产品信息
     * @return
     */
    public Production getProById(Production production);

    /**
     * 绑定产品和用户信息
     * @param production
     */
    public void bindProByUserId(Production production);
}
