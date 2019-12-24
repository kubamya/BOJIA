package com.example.organ.service;

import com.example.organ.mapper.OrganMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrganService {

    /**
     * 获取所有coms
     * @return
     */
    public List<Map<String, Object>> getAllComs(boolean isValid);

    /**
     * 根据comId获取com
     * @param queryParams
     * @return
     */
    public Map<String, Object> getComById(Map<String, Object> queryParams);

    /**
     * 根据comid获取dept树
     * @param comId
     * @param isValid 是否有效
     * @return
     */
    @Deprecated
    public List<Map<String, Object>> getDeptByComID(String comId, boolean isValid);

    /**
     * 根据comId获取对应的组织机构树
     * @param comId
     * @return
     */
    public List<Map<String, Object>> getOrganTreeByComid(String comId);

    /**
     * 根据comId获取所有人员
     * @param queryParams
     * @return
     */
    public List<Map<String, Object>> getUsersByComid(Map<String, Object> queryParams);
}
