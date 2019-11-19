package com.springboot.YouHuiWang.Service.impl;

import com.springboot.YouHuiWang.Service.PrivilegeLinkService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import com.springboot.YouHuiWang.Util.DaTaoKeApi;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PrivilegeLinkServiceImpl implements PrivilegeLinkService {

    @Override
    public Map getPrivilegeLink(String goodsId) {
        String json = DaTaoKeApi.getPrivilegeLink(goodsId);
        if (CodeUtil.isSuccessForDaTaoKe(json)){
            JSONObject  data = (JSONObject) JSONObject.fromObject(json).get("data");
            //淘口令
            String tpwd = data.getString("tpwd");
            //短链接
            String shortUrl = data.getString("shortUrl");
            Map info = new HashMap();
            info.put("tpwd",tpwd);
            info.put("shortUrl",shortUrl);
            return info;
        }
        return null;
    }
}
