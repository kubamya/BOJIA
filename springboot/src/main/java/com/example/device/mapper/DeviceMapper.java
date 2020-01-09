package com.example.device.mapper;

import com.example.model.Device;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DeviceMapper {

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
    public List<Device> getDevList();

    /**
     * 根据设备id获取设备信息
     * @param device
     * @return
     */
    public Device getDevById(Device device);

    /**
     * 设备绑定给用户
     * @param device
     */
    public void bindDevByUserId(Device device);

    /**
     * 根据用户id获取设备信息
     * @param device
     * @return
     */
    public List<Device> getDevByUserId(Device device);

}
