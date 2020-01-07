package com.example.device.service;

import com.example.model.Device;
import com.example.model.Production;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DeviceService {

    /**
     * 新增设备
     * @param device
     */
    public void addDev(Device device);

    /**
     * 更新设备
     * @param device
     */
    public void updateDev(Device device);

    /**
     * 设备置为无效
     * @param device
     */
    public void setDevDisable(Device device);

    /**
     * 获取设备列表
     * @return
     */
    public List<Map<String, Object>> getDevList();

    /**
     * 根据设备id获取设备信息
     * @param device
     * @return
     */
    public Map<String, Object> getDevById(Device device);
}
