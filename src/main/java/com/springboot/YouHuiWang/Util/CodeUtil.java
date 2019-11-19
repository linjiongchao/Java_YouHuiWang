package com.springboot.YouHuiWang.Util;

import com.springboot.YouHuiWang.Pojo.Result;
import net.sf.json.JSONObject;

import java.util.Map;

public class CodeUtil {

    public static boolean isSuccessForDaTaoKe(String json) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        int code = jsonObject.getInt("code");
        if (code == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getErrorMsgDaTaoKe(String json) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        int code = jsonObject.getInt("code");
        if (code == -1) {
            return "服务器错误,稍后尝试访问";
        }
        if (code == 1) {
            String msg = jsonObject.getString("msg");
            return "参数错误," + msg;
        }
        if (code == 10006) {
            String msg = jsonObject.getString("msg");
            return msg;
        }
        if (code == 10007) {
            return "参数错误,开始时间必须小于或等于结束时间";
        }
        return "未知错误";
    }


    public static Result success(Object object){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return  result;
    }
    public static Result successNoData(){
        return  success(null);
    }
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }

}
