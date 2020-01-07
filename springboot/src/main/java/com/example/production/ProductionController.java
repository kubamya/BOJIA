package com.example.production;

import com.example.consts.IntegerConsts;
import com.example.model.Com;
import com.example.model.Production;
import com.example.production.service.ProductionService;
import com.example.util.CommonReturnUtil;
import com.example.util.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pro/v1")
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    /**
     * 获取代售产品列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSellProList")
    public Map<String, Object> getSellProList(HttpServletRequest request) {
        try{
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS, productionService.getSellProList(),"获取成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR, e.getMessage(), "获取代售产品失败！");
        }
    }

    /**
     * 产品置为无效
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/setProDisable")
    public Map<String, Object> setProDisable(HttpServletRequest request) {
    	
    	Production pro = getProductionFromRequest(request);
    	try {
			productionService.setProDisable(pro);
			
			return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS, null, "删除成功！");
		} catch (Exception e) {
			return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR, e.getMessage(), "删除失败！");
		}
    }

    /**
     * 获取产品列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getProList")
    public Map<String, Object> getProList(HttpServletRequest request) {

        List<Map<String, Object>> ret = new ArrayList<>();

        try {
            ret = productionService.getProList();

            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,ret,"获取产品列表成功！");
        }catch (Exception e){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,e.getMessage(),"获取产品列表失败！");
        }
    }

    /**
     * 新增或修改设备
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addOrUpdatePro")
    public Map<String, Object> addOrUpdatePro(HttpServletRequest request) {

        Production pro = getProductionFromRequest(request);

        String optFlag = null;
        if(request.getParameter("optFlag") == null){
            return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_FAIL,null,"操作类型字段为空！");
        }

        optFlag = request.getParameter("optFlag");

        if("add".equals(optFlag)){
            //新增
            try{
                productionService.addProduction(pro);
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"添加成功！");
            }catch (Exception e){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"添加失败！");
            }
        }else{
            //修改
            try{
                productionService.updateProduction(pro);
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_SUCCESS,null,"更新成功！");
            }catch (Exception e){
                return CommonReturnUtil.CommonReturnMsg(IntegerConsts.RET_CODE_DATABASEERROR,e.getMessage(),"更新失败！");
            }
        }
    }

    /**
     * 前端请求封装实体bean
     * @param request
     * @return
     */
    private Production getProductionFromRequest(HttpServletRequest request){
        Production pro = new Production();

        if(request.getParameter("proId") == null || StringUtils.isBlank(request.getParameter("proId"))){
            pro.setCId(CommonUtil.getUUid());
            pro.setCCjr(request.getParameter("cjr"));
            pro.setDCjsj(CommonUtil.getCurDateTime());
        }else{
            pro.setCId(request.getParameter("proId"));
            pro.setCXgr(request.getParameter("xgr"));
            pro.setDXgsj(CommonUtil.getCurDateTime());
        }

        pro.setCName(request.getParameter("proName"));
        pro.setNYx(IntegerConsts.CODE_YES);
        if(request.getParameter("type") != null) {
        	pro.setNType(Integer.parseInt(request.getParameter("type")));
        }

        return pro;
    }
}
