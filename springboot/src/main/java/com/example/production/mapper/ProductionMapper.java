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
}
