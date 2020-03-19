package com.mapper;

import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 若安择晴
 * @create 2020-03-14 21:14
 */
public class UserMapperTest {

    //        获取sqlSession对象
      SqlSession sqlSession= MybatisUtils.getSqlSession();

    @Test
    public void getUserLisTest(){

        try{
            // 执行SQL
            UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            for(User user:userList){
                System.out.println(user);
            }
        }
        catch (Exception e) {
           e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void  getUserLikeTest(){

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getUserLike("%佳%");
        for (User user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByIdTest(){

      UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
      User user= userMapper.getUserById(1);
          System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUserTest(){

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        int num= userMapper.addUser(new User(5,"小柔","29382239"));
        if(num>0)
        System.out.println("插入成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2Test(){

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
       Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",6);
        map.put("name","佳婷");
        userMapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        int num= userMapper.updateUser(new User(4,"张李","3938279"));
        if(num>0)
            System.out.println("修改成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){

        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
        int num= userMapper.deleteUser(4);
        if(num>0)
            System.out.println("删除成功");
        sqlSession.commit();
        sqlSession.close();
    }


}
