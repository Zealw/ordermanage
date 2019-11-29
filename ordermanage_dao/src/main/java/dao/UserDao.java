package dao;

import domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from userInfo where username = #{username}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "roles", column = "id" ,many = @Many(select = "dao.RoleDao.findByUid"))
    })
    UserInfo findByUsername(String username);

    @Select("select * from userInfo where username like #{username}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "roles", column = "id" ,many = @Many(select = "dao.RoleDao.findByUid"))
    })
    List<UserInfo> findByUsernameS(String username);

    @Select("select *from userInfo")
    List<UserInfo> findAll();
    @Insert("insert into userInfo values(#{id},#{username},#{email},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);
    @Select("select * from userInfo where id = #{id}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "roles", column = "id" ,many = @Many(select = "dao.RoleDao.findByUid"))
    })
    UserInfo findById(String id);

    @Insert("insert into user_role values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);



}
