package com.example.proxy;

import com.alibaba.fastjson.JSONObject;
import com.example.consts.IntegerConsts;
import com.example.proxy.service.ProxyService;
import com.example.util.CommonReturnUtil;
import com.example.util.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/proxy/v1")
public class ProxyController {

    @Autowired
    private ProxyService proxyService;

    @ResponseBody
    @RequestMapping("/getWeather")
    public Map<String, Object> getWeather(HttpServletRequest request) {
        String city = request.getParameter("city");
        if(StringUtils.isBlank(city)){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL, null, "城市代码为空，获取天气失败！");
        }

        //获取天气代码
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("city", city);

        Map<String, Object> queryResult = null;
        try{
            queryResult = proxyService.getCityCode(queryParams);

            if(queryResult == null || queryResult.isEmpty()){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR, null, "未查询到城市代码");
            }

        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,e.getMessage(),"查询城市代码失败");
        }

        //取天气代码调用国家气象局接口获取天气
        String cityCode = queryResult.get("code").toString();

        String res = "";
        JSONObject resObj = null;
        try {
            res = HttpUtil.get("http://t.weather.sojson.com/api/weather/city/"+cityCode, null, null, "UTF-8");
            resObj = JSONObject.parseObject(res);
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,res,"调用国家气象局接口失败！");
        }
        return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,resObj,"获取天气成功！");
    }

}
