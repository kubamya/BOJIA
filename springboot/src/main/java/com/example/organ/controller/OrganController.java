package com.example.organ.controller;

import com.example.consts.IntegerConsts;
import com.example.util.CommonReturnUtil;
import com.example.util.CommonUtil;
import com.example.util.OrganUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/organ")
public class OrganController {

    /**
     * 根据comid获取组织机构树
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getOrganTreeByComid")
    public Map<String, Object> getOrganTreeByComid(HttpServletRequest request){
        String comId = request.getParameter("comId");
        if(comId == null || comId.equals("")){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_NODATA,null,"comId为空！");
        }
        return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS, new OrganUtil().getOrganTreeByComid(comId),"查询成功");
    }
}
