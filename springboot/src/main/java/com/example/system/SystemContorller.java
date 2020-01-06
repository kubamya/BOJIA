package com.example.system;

import com.example.consts.IntegerConsts;
import com.example.system.service.SystemService;
import com.example.util.CommonReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/sys/v1")
public class SystemContorller {

    @Autowired
    private SystemService systemService;

    @ResponseBody
    @RequestMapping("/getSysInfo")
    public Map<String, Object> getWeather(HttpServletRequest request) {
        try{
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,systemService.getSysInfo(),"查询成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"查询失败");
        }
    }

}
