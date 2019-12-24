package com.example.util;

import com.example.organ.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织机构工具类
 */
public class OrganUtil {

    @Autowired
    private  OrganService organService;

    /**
     * 获取所有coms
     * @param isValid 是否有效
     * @return
     */
    public  List<Map<String, Object>> getAllComs(boolean isValid){
        return organService.getAllComs(isValid);
    }

    /**
     * 根据comId获取com
     * @param comId
     * @return
     */
    public  Map<String, Object> getComById(String comId){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("comId", comId);
        return organService.getComById(queryParams);
    };

    /**
     * 根据comid获取dept树
     * @param comId
     * @return
     */
    public  List<Map<String, Object>> getDeptByComID(String comId){
        return null;
    }

    /**
     * 根据comId获取对应的组织机构树
     * @param comId
     * @return
     */
    public  List<Map<String, Object>> getOrganTreeByComid(String comId){
        return organService.getOrganTreeByComid(comId);
    }

    /**
     * 根据comId获取所有人员
     * @param comId
     * @return
     */
    public  List<Map<String, Object>> getUsersByComid(String comId){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("comId", comId);
        return null;
    }

}
