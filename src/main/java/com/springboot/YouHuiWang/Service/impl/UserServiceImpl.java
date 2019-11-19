package com.springboot.YouHuiWang.Service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.springboot.YouHuiWang.Mapper.UserMapper;
import com.springboot.YouHuiWang.Pojo.User;
import com.springboot.YouHuiWang.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public boolean insertUser(User user){
        int userId = (int) (System.currentTimeMillis());
        user.setUserId(userId);

        //判断userName是否被使用
        if(userMapper.selectUserName(user.getUserName()) ==  0){
            userMapper.insertUser(user);
            return true;
        }
        return false;
    }

    @Override
    public User selectUser(User user) {
        if ((user.getUserName() == null ||user.getUserName().trim().length()==0 )
                || (user.getUserPassword() == null ||user.getUserPassword().trim().length()==0)){
            return null;
        }else{
            return userMapper.selectUser(user);

        }
    }

    @Override
    public boolean updateUserById(User user) {
        if (user.getUserId()!=0 && user.getPhone().length() == 11) {
            if (userMapper.updateUserById(user) == 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateUserPasswordByNameAndPhone(User user) {
        if (user.getUserName()!=null || user.getUserName().trim().length()!=0
                || user.getPhone()!=null || user.getPhone().trim().length()!=0){
            if (userMapper.updateUserPasswordByNameAndPhone(user)==1){
                return true;
            }
        }
        return false;
    }



}
