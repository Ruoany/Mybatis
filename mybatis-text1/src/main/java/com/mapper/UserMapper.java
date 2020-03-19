package com.mapper;

import com.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 若安择晴
 * @create 2020-03-14 21:01
 */
public interface UserMapper {

    /**
     * 以List集合返回所有的用户信息Like模糊查询
     * @param value 传入模糊匹配的值
     * @return List<User>
     *
     */
    List<User> getUserLike(String value);


    /**
     * 以List集合返回所有的用户信息
     * @return List<User>
     */
    List<User>  getUserList();

    /**
     * 根据id来返回指定的用户信息
     * @param id 传入需要查询用户的id
     * @return User
     */
    User getUserById(int id);

    /**
     * 根据id来返回指定的用户信息
     * @param user 传入需要增加的user信息
     * @return User
     */
    int addUser(User user);

    /**
     * 当数据库中表的字段过多时，应当考虑用map来完成增删改操作
     * 根据id来返回指定的用户信息
     * @param map 传入需要增加的user信息
     * @return User
     */

    int addUser2(Map<String,Object> map);

    /**
     * 根据id来返回指定的用户信息
     * @param user 传入需要修改的user信息
     * @return User
     */
    int updateUser(User user);

    /**
     * 根据id来返回指定的用户信息
     * @param id 传入需要删除用户信息的id
     * @return User
     */
    int deleteUser(int id);

}
