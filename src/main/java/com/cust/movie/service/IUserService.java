package com.cust.movie.service;

import com.cust.movie.entity.User;

/*用户数据处理的相关功能理模块业务层接口*/
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户数据
     */
    User login (String username,String password);

    /**
     * 用户修改密码
     * @param uid 用户的id可在控制层中用session对象来获取
     * @param username
     * @param oldPassword 用户输入的旧密码
     * @param newPassword 用户输入的新密码
     */
    void changPassword(Integer uid,
                       String username,
                       String oldPassword,
                       String newPassword);

    /**
     * 获取当前已登录用户的个人信息
     * @param uid 当前已登录的用户的用户名
     * @return 用户的数据
     */
    User getByUid(Integer uid);

    /**
     * 修改用户的个人资料
     * @param uid 当前登录的用户的uid
     * @param username 当前登录的用户名
     * @param user 用户的新的数据
     */
    void changeInfo(Integer uid,String username,User user);

    /**
     * 用户修改头像
     * @param uid 用户的uid (需要由控制层传递，控制层从session域对象中获取)
     * @param username 用户名
     * @param avatar 用户头像存放路径
     */
    void changeAvatar (Integer uid,String username,String avatar);

}
