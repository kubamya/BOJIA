package com.example.production.service.impl;

import com.example.model.Production;
import com.example.production.mapper.ProductionMapper;
import com.example.production.service.ProductionService;
import com.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductionImpl implements ProductionService {

    @Autowired
    private ProductionMapper productionMapper;

    @Override
    public void addProduction(Production production) {
        productionMapper.addProduction(production);
    }

    @Override
    public void updateProduction(Production production) {
    productionMapper.updateProduction(production);
    }

    @Override
    public List<Map<String, Object>> getProList() {
        List<Production> proList =  productionMapper.getProList();
        if(proList == null){
            return null;
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for(Production production : proList){
            Map<String, Object> proMap = new HashMap<>();
            proMap.put("proId", production.getCId());
            proMap.put("proName", production.getCName());
            proMap.put("type",production.getNType());
            proMap.put("cjr", production.getCCjr());
            proMap.put("xgr", production.getCXgr());
            proMap.put("cjsj", CommonUtil.dateToStr(production.getDCjsj()));
            proMap.put("xgsj", CommonUtil.dateToStr(production.getDXgsj()));

            result.add(proMap);
        }

        return result;
    }
}
