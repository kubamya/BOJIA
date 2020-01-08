package com.example.user;

import com.example.consts.IntegerConsts;
import com.example.model.Production;
import com.example.model.User;
import com.example.production.service.ProductionService;
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

    @Autowired
    private ProductionService productionService;

    /**
     * app用户注册
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/regis")
    public Map<String, Object> regis(HttpServletRequest request) {
        User user = new User();
        try{
            user = getUserFromRequest(request);
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,e.getMessage(),"注册失败！");
        }

        String proId = request.getParameter("proId");
        if(StringUtils.isBlank(proId)){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,null,"产品序列号不能为空！");
        }

        //校验产品序列号合法性
        Production production = new Production();
        production.setCId(proId);
        try{
            production = productionService.getProById(production);
            if(production == null){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,null,"产品序列号不存在！");
            }
            if(production.getCUserId() != null && !production.getCUserId().equals(user.getCId())){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,null,"该产品序列号已被注册！");
            }
            if(production.getCUserId() != null && production.getCUserId().equals(user.getCId())){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,null,"您已注册该产品序列号！");
            }
//            if(production.getCUserId() == null){
//                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"产品序列号可以使用！");
//            }
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"查询产品信息出错");
        }

        //创建用户
        try{
            userService.addUser(user);
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"创建用户失败！");
        }

        //用户和产品进行绑定
        production.setCUserId(user.getCId());
        try{
            productionService.bindProByUserId(production);
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"注册成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"产品信息绑定失败！");
        }
    }

    /**
     * 获取用户列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserList")
    public Map<String, Object> getUserList(HttpServletRequest request) {
        User user = new User();
        try {
            user = getUserFromRequest(request);
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,userService.getUserList(user),"查询成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,e.getMessage(),"获取用户列表失败！");
        }
    }

    /**
     * 删除用户
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public Map<String, Object> deleteUser(HttpServletRequest request) {
        User user = new User();
        try{
            user = getUserFromRequest(request);
            userService.setUserDisable(user);
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"删除成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL, e.getMessage(),"删除失败！");
        }
    }

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
                    userService.addUser(user);
                    return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"添加成功！");
                }catch (Exception e){
                    return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"新增人员失败！");
                }
            }else{
                //修改
                try {
                    userService.updateUser(user);
                    return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"更新成功！");
                }catch (Exception e){
                    return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"修改人员信息失败！");
                }
            }
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,e.getMessage(),"用户密码MD5加密失败！");
        }
    }

    private User getUserFromRequest(HttpServletRequest request) throws Exception{
        User user = new User();
        if(request.getParameter("userId") == null){
            user.setCId(CommonUtil.getUUid());
            user.setCCjr(request.getParameter("cjr"));
            if(request.getParameter("userName") == null){
                user.setCUserName(CommonUtil.getRandomUserName());
            }else {
                user.setCUserName(request.getParameter("userName"));
            }
            user.setDCjsj(CommonUtil.getCurDateTime());
        }else {
            user.setCId(request.getParameter("userId"));
            user.setCUserName(request.getParameter("userName"));
            user.setCXgr(request.getParameter("xgr"));
            user.setDXgsj(CommonUtil.getCurDateTime());
        }
        user.setCLoginId(request.getParameter("loginId"));
        if(request.getParameter("password") != null){
            user.setCPassword(SecurityUtil.MD5Encode(request.getParameter("password")));
        }

        user.setCEmail(request.getParameter("email"));
        user.setCTel(request.getParameter("tel"));
        if(request.getParameter("type") != null){
            user.setNType(Integer.parseInt(request.getParameter("type")));

            if("1".equals(request.getParameter("type"))){
                user.setCComId(request.getParameter("userId"));
                user.setCDeptId(request.getParameter("deptId"));
                if(request.getParameter("xssx") != null){
                    user.setNXssx(Integer.parseInt(request.getParameter("xssx")));
                }
            }
        }

        return user;
    }
}
