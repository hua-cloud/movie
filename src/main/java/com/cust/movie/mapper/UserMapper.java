package com.cust.movie.mapper;

import com.cust.movie.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Date;

/*处理用户数据操作的持久层接口*/
@Repository
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findByUsername(String username);

    /**
     * 根据用户的uid来修改与其对应的记录中的密码字段的值(修改用户的密码)
     * @param uid 用户的id
     * @param password 用户输入的新密码
     * @param modifiedUser 密码的修改者
     * @param modifiedTime 密码的修改时间
     * @return 返回受影响的行数
     */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);

    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的id
     * @return 如果找到返回对象，反之返回null
     */
    User findByUid(Integer uid);

    /**
     * 根据uid更新用户资料
     * @param user User实体类中封装了用户个人资料的相关数据
     * @return 受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * 根据uid修改用户头像
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(Integer uid,
                              String avatar,
                              String modifiedUser,
                              Date modifiedTime);
}
