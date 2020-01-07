package com.example.device.service.impl;

import com.example.device.mapper.DeviceMapper;
import com.example.device.service.DeviceService;
import com.example.model.Device;
import com.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public void addDev(Device device) {
        deviceMapper.addDev(device);
    }

    @Override
    public void updateDev(Device device) {
        deviceMapper.updateDev(device);
    }

    @Override
    public void setDevDisable(Device device) {
        deviceMapper.setDevDisable(device);
    }

    @Override
    public List<Map<String, Object>> getDevList() {
        List<Device> deviceList = deviceMapper.getDevList();
        if(deviceList == null || deviceList.isEmpty()){
            return null;
        }

        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Device device : deviceList){
            Map<String, Object> devMap = new HashMap<>();
            devMap.put("proName", device.getCProId());
            devMap.put("devName", device.getCName());
            devMap.put("devId", device.getCId());
            devMap.put("sfzx", device.getNSfzx());
            devMap.put("cjxj", CommonUtil.dateToStr(device.getDCjsj()));
            devMap.put("xgxj", CommonUtil.dateToStr(device.getDXgsj()));

            resultList.add(devMap);
        }

        return resultList;
    }

    @Override
    public Map<String, Object> getDevById(Device device) {
        Device device1 = deviceMapper.getDevById(device);
        if(device1 == null){
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("proId", device1.getCProId());
        result.put("devName", device1.getCName());
        result.put("devId", device1.getCId());
        result.put("sbmy", device1.getCSbmy());
        return result;
    }
}
