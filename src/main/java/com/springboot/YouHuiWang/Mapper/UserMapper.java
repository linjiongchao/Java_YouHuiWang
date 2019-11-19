package com.springboot.YouHuiWang.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.YouHuiWang.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  extends BaseMapper<User> {

    //添加一个用户
    public int insertUser(User user);

    //查询userName是否占用
    public int selectUserName(String userName);

    //通过用户名密码查询用户
    public User selectUser(User user);

    //通过id修改信息
    public int updateUserById(User user);

    //通过账号手机修改密码
    public int updateUserPasswordByNameAndPhone(User user);

}

