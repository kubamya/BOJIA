package com.example.login.controller;

import com.example.consts.IntegerConsts;
import com.example.login.service.LoginService;
import com.example.util.CommonReturnUtil;
import com.example.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/login/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 默认的使用用户名密码登录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginDefault")
    public Map<String, Object> loginDefault(HttpServletRequest request) {
        //获取传递参数
        String loginid = request.getParameter("loginId");
        String password = request.getParameter("password");

        try {
            password = SecurityUtil.MD5Encode(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //组装查询参数
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("loginid", loginid);
        queryParams.put("password", password);

        //定义结果集
        Map<String, Object> resultMap = new HashMap<>();

        //数据库操作
        try {
            resultMap = loginService.login(queryParams);

            if(resultMap == null || resultMap.isEmpty()){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_NODATA, resultMap, "未匹配到用户数据！");
            }
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS, resultMap, "用户匹配成功！");
        } catch (Exception e) {
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR, resultMap, "数据库异常！"+e.getMessage());
        }



    }
}
