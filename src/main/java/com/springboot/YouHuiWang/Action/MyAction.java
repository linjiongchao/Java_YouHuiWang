package com.springboot.YouHuiWang.Action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;

public class MyAction extends ActionSupport {

    public Map response = new HashMap();

    public Map getResponse() {
        return response;
    }

    public void setResponse(Map response) {
        this.response = response;
    }
}
