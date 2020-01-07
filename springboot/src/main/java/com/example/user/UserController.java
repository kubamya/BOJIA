package com.example.user;

import com.example.consts.IntegerConsts;
import com.example.model.User;
import com.example.user.service.UserService;
import com.example.util.CommonReturnUtil;
import com.example.util.CommonUtil;
import com.example.util.SecurityUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增或修改人员信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addOrUpdateUser")
    public Map<String, Object> addOrUpdateUser(HttpServletRequest request) {
        String optFlag = request.getParameter("optFlag");
        if(StringUtils.isBlank(optFlag)){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,null,"操作类型为空！");
        }
        User user = new User();
        try{
            user = getUserFromRequest(request);
            if("add".equals(optFlag)){
                //新增
                try {

                }catch (Exception e){
                    return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"新增人员失败！");
                }
            }else{
                //修改
                try {

                }catch (Exception e){
                    return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"修改人员信息失败！");
                }
            }
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,e.getMessage(),"用户密码MD5加密失败！");
        }
        return null;
    }

    private User getUserFromRequest(HttpServletRequest request) throws Exception{
        User user = new User();
        if(request.getParameter("userId") == null){
            user.setCId(CommonUtil.getUUid());
            user.setCCjr(request.getParameter("cjr"));
            user.setDCjsj(CommonUtil.getCurDateTime());
        }else {
            user.setCId(request.getParameter("userId"));
            user.setCXgr(request.getParameter("xgr"));
            user.setDXgsj(CommonUtil.getCurDateTime());
        }
        user.setCLoginId(request.getParameter("loginId"));
        user.setCPassword(SecurityUtil.MD5Encode(request.getParameter("password")));
        user.setCUserName(request.getParameter("userName"));
        if("1".equals(request.getParameter("type"))){
            user.setCComId(request.getParameter("userId"));
            user.setCDeptId(request.getParameter("deptId"));
            if(request.getParameter("xssx") != null){
                user.setNXssx(Integer.parseInt(request.getParameter("xssx")));
            }
        }
        user.setCEmail(request.getParameter("email"));
        user.setCTel(request.getParameter("tel"));
        if(request.getParameter("type") != null){
            user.setNType(Integer.parseInt(request.getParameter("type")));
        }

        return user;
    }
}
