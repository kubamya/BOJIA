package com.example.production.mapper;

import com.example.model.Production;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionMapper {

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
    public List<Production> getProList();
    
    /**
     * 产品置为无效
     * @param production
     */
    public void setProDisable(Production production);

    /**
     * 获取代售产品列表
     * @return
     */
    public List<Production> getSellProList();

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
