package com.cust.movie.mapper;

import com.cust.movie.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

//该注解表示标注当前的类是一个测试类
@SpringBootTest
//此注解表示的是启动这个单元测试类，需要传递一个参数
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    /*
     * 1.必须被Test注解所修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void insert (){
        User user = new User();
        user.setUsername("test01");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void updateInfoByUid () {
        User user = new User();
        user.setUid(4);
        user.setPhone("15234174870");
        user.setEmail("admin@qq.com");
        user.setGender(1);
        user.setModifiedUser("admin");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateAvatarByUid () {
        userMapper.updateAvatarByUid(1,
                "/upload/avatar.png",
                "test01",
                new Date());
    }
}
