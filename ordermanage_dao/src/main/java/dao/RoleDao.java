package dao;

import domain.Role;
import domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role where id in( select roleId from user_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissions", column = "id", many = @Many(select = "dao.PermissionDao.findByRid"))
    })
    List<Role> findByUid(String userId);
    @Select("select *from role")
    List<Role> findAll();
    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void add(Role role);
    @Update("update role set roleName = #{roleName},roleDesc = #{roleDesc} where id = #{id}")
    void update(Role role);

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "permissions", column = "id", many = @Many(select = "dao.PermissionDao.findByRid"))
    })
    Role findById(String id);

    @Select("SELECT * FROM role WHERE id  NOT IN (SELECT roleId FROM user_role WHERE userId = #{uid})")
    List<Role> findOthersById(String uid);

}
