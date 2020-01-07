package com.example.device;

import com.example.consts.IntegerConsts;
import com.example.device.service.DeviceService;
import com.example.model.Device;
import com.example.util.CommonReturnUtil;
import com.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/device/v1")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @ResponseBody
    @RequestMapping("/getDevById")
    public Map<String, Object> getDevById(HttpServletRequest request) {
        Device device = getDeviceFromRequest(request);
        try {
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS, deviceService.getDevById(device), "查询成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR, e.getMessage(),"查询设备失败！");
        }
    }


    /**
     * 获取设备列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDevList")
    public Map<String, Object> getDevList(HttpServletRequest request) {
        try {
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,deviceService.getDevList(),"查询成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"获取设备列表失败！");
        }
    }

    /**
     * 删除设备
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteDev")
    public Map<String, Object> deleteDev(HttpServletRequest request) {
        Device device = getDeviceFromRequest(request);
        try{
            deviceService.setDevDisable(device);
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"删除成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"删除失败！");
        }
    }

    /**
     * 新增或更新设备信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addOrUpdateDev")
    public Map<String, Object> addOrUpdateDev(HttpServletRequest request) {
        String optFlag = request.getParameter("optFlag");
        if(optFlag == null){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,null,"操作类型为空！");
        }
        Device device = getDeviceFromRequest(request);
        if("add".equals(optFlag)){
            //新增
            try{
                deviceService.addDev(device);
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"设备添加成功！");
            }catch (Exception e){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"添加失败！");
            }
        }else {
            //修改
            try{
                deviceService.updateDev(device);
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"更新成功！");
            }catch (Exception e){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"更新失败！");
            }
        }
    }

    /**
     * 获取前端传递参数组装实体bean
     * @param request
     * @return
     */
    private Device getDeviceFromRequest(HttpServletRequest request){
        Device device = new Device();

        if(request.getParameter("devId") == null){
            device.setCId(CommonUtil.getUUid());
            device.setCCjr(request.getParameter("cjr"));
            device.setDCjsj(CommonUtil.getCurDateTime());
        }else{
            device.setCId(request.getParameter("devId"));
            device.setCXgr(request.getParameter("xgr"));
            device.setDXgsj(CommonUtil.getCurDateTime());
        }

        device.setCName(request.getParameter("devName"));
        device.setCProId(request.getParameter("proId"));
        device.setCSbmy(request.getParameter("sbmy"));

        return device;
    }
}
