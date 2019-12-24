package com.example.organ.service.impl;

import com.example.consts.IntegerConsts;
import com.example.organ.mapper.OrganMapper;
import com.example.organ.service.OrganService;
import com.example.util.OrganUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganServiceImpl implements OrganService {

    @Autowired
    private OrganMapper organMapper;

    @Override
    public List<Map<String, Object>> getAllComs(boolean isValid) {
        Map<String, Object> queryParams = new HashMap<>();
        if(isValid){
            queryParams.put("sfyx", IntegerConsts.CODE_YES);
        }else{
            queryParams.put("sfyx", IntegerConsts.CODE_NO);
        }
        return organMapper.getAllComs(queryParams);
    }

    @Override
    public Map<String, Object> getComById(Map<String, Object> queryParams) {
        return organMapper.getComById(queryParams);
    }

    @Override
    public List<Map<String, Object>> getDeptByComID(String comId, boolean isValid) {
//        Map<String, Object> queryParams = new HashMap<>();
//        if(isValid){
//            queryParams.put("sfyx", IntegerConsts.CODE_YES);
//        }else{
//            queryParams.put("sfyx", IntegerConsts.CODE_NO);
//        }
//
//        //先查出一级dept
//        queryParams.put("jb", IntegerConsts.DEPT_LEVEL_ONE);
//        List<Map<String, Object>> deptList = organMapper.getDeptByComID(queryParams);
//
//        //再查出二级dept
//        queryParams.put("jb", IntegerConsts.DEPT_LEVEL_TWO);
//        List<Map<String, Object>> childDeptList = organMapper.getDeptByComID(queryParams);
//
//        //没有二级直接返回一级
//        if(childDeptList == null || childDeptList.isEmpty()){
//            return deptList;
//        }
//
//        //有二级进行绑定
//        for(Map<String, Object> dept : deptList){
//            List<Map<String, Object>> temp = new ArrayList<>();
//            for (Map<String, Object> childDept : childDeptList){
//                if(dept.get("id").toString().equals(childDept.get("pid").toString())){
//                    temp.add(childDept);
//                }
//            }
//            dept.put("children", temp);
//        }
        return null;
    }

    @Override
    public List<Map<String, Object>> getOrganTreeByComid(String comId) {
        List<Map<String, Object>> finalResult = new ArrayList<>();

        //获取com信息
        Map<String, Object> comInfo = new OrganUtil().getComById(comId);

        //获取user信息
        List<Map<String, Object>> userList = new OrganUtil().getUsersByComid(comId);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("comId", comId);
        queryParams.put("jb", IntegerConsts.DEPT_LEVEL_ONE);
        //获取一级dept
        List<Map<String, Object>> deptList = organMapper.getDeptByComID(queryParams);
        //获取二级dept
        queryParams.put("jb", IntegerConsts.DEPT_LEVEL_ONE);
        List<Map<String, Object>> childDeptList = organMapper.getDeptByComID(queryParams);

        //dept和user组装
        if(childDeptList != null || childDeptList.size() > 0){
            dealDeptUser(childDeptList, userList);
        }
        dealDeptUser(deptList, userList);

        //dept和childDept组装
        if(childDeptList != null || childDeptList.size() > 0){
            for(Map<String, Object> dept : deptList){
                List<Map<String, Object>> temp = new ArrayList<>();
                for (Map<String, Object> childDept : childDeptList){
                    if(dept.get("id").toString().equals(childDept.get("pid").toString())){
                        temp.add(childDept);
                    }
                }
                dept.put("children", temp);
            }
        }

        //com和dept组合
        comInfo.put("children", deptList);
        finalResult.add(comInfo);
        return finalResult;
    }

    @Override
    public List<Map<String, Object>> getUsersByComid(Map<String, Object> queryParams) {
        return organMapper.getUsersByComid(queryParams);
    }

    private void dealDeptUser(List<Map<String, Object>> deptList, List<Map<String, Object>> userList){
        for(Map<String, Object> dept : deptList){
            List<Map<String, Object>> temp = new ArrayList<>();
            for (Map<String, Object> user : userList){
                if(dept.get("id").toString().equals(user.get("deptid").toString())){
                    temp.add(user);
                }
            }
            dept.put("children", temp);
        }
    }
}
