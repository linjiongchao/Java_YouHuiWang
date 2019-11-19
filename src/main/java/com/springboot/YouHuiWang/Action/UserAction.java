package com.springboot.YouHuiWang.Action;

import com.opensymphony.xwork2.ModelDriven;
import com.springboot.YouHuiWang.Pojo.User;
import com.springboot.YouHuiWang.Service.UserService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class UserAction extends MyAction implements ModelDriven<User> {

    private User user = new User();

    @Autowired
    private UserService userService;

    @PostMapping(value="user/userLogin.action")
    @ApiOperation(value = "用户登录",notes = "通过账号密码登录")
    public String userLogin() {
        System.out.println(user);
        User userFromDB = userService.selectUser(user);
        if (userFromDB == null){
            response.put("result", CodeUtil.error(-1,"登录错误,无此用户！"));
        }else{
            response.put("result", CodeUtil.success(userFromDB));
        }
        return SUCCESS;
    }

    @PostMapping(value="user/userRegister.action")
    @ApiOperation(value = "用户注册",notes = "通过账号密码注册")
    public String userRegister() {

        if (userService.insertUser(user)){

            response.put("result", CodeUtil.success(null));
        }else{
            response.put("result", CodeUtil.error(-1,"注册错误,已存在此用户！"));
        }

        return SUCCESS;
    }



    @Override
    public User getModel() {
        return user;
    }
}
