package com.cust.movie.service;

import com.cust.movie.entity.User;
import com.cust.movie.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//该注解表示标注当前的类是一个测试类
@SpringBootTest
//此注解表示的是启动这个单元测试类，需要传递一个参数
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService userService;

    /*
     * 1.必须被Test注解所修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("王小美");
            user.setPassword("123");
            userService.reg(user);
            //若未插入成功会抛出异常，则不会执行以下的输出语句
            System.out.println("OK");
        } catch (ServiceException e) {
            // 获取类的对象再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            // 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        try {
            String username = "admin";
            String password = "123";
            User user = userService.login(username, password);
            System.out.println("登录成功！" + user);
        } catch (ServiceException e) {
            System.out.println("登录失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changeAvatar () {
        try {
            userService.changeAvatar(1,"test01","/upload/test.png");
        } catch (ServiceException e) {
            System.out.println("更新用户头像失败！"+e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
