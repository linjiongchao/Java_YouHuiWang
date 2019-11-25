package com.springboot.YouHuiWang.Action;

import com.opensymphony.xwork2.ModelDriven;
import com.springboot.YouHuiWang.Service.PrivilegeLinkService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@Api(tags = "高佣接口")
public class PrivilegeLinkAction  extends MyAction{

    private String goodsId;

    @Autowired
    private PrivilegeLinkService privilegeLinkService;


    @GetMapping(value="privilegeLink/getPrivilegeLink.action")
    @ApiOperation(value = "查询淘口令",notes = "")
    @ApiImplicitParam(name = "goodsId", dataType = "string", value = "商品ID", paramType = "query" ,required = true)
    public String getPrivilegeLink() {
        if (goodsId!=null || goodsId.trim().length()!=0){
           Map info =  privilegeLinkService.getPrivilegeLink(goodsId);

           if (info == null){
               response.put("result", CodeUtil.error(0,"查询不到淘口令"));
           }else{
               response.put("result", CodeUtil.success(info));
           }
        }else{
            response.put("result", CodeUtil.error(-1,"商品Id错误"));
        }
        return SUCCESS;
    }



    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

}
