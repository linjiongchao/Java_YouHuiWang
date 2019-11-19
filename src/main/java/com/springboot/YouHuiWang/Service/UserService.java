package com.springboot.YouHuiWang.Service;

import com.springboot.YouHuiWang.Pojo.User;

public interface UserService {

    //添加一个新用户
    public boolean insertUser(User user);

    //查询一个用户 通过账号密码
    public User selectUser(User user);

    //修改用户数据通过Id
    public boolean updateUserById(User user);

    //修改用户数据通过用户名与手机 修改密码
    public boolean updateUserPasswordByNameAndPhone(User user);
}
