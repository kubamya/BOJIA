package com.example.organ.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrganMapper {

    /**
     * 获取所有coms
     * @return
     */
    public List<Map<String, Object>> getAllComs(Map<String, Object> queryParams);

    /**
     * 根据comId获取com
     * @param queryParams
     * @return
     */
    public Map<String, Object> getComById(Map<String, Object> queryParams);

    /**
     * 根据comid获取dept树
     * @param queryParams
     * @return
     */
    public List<Map<String, Object>> getDeptByComID(Map<String, Object> queryParams);

    /**
     * 根据comId获取所有人员
     * @param queryParams
     * @return
     */
    public List<Map<String, Object>> getUsersByComid(Map<String, Object> queryParams);
}
