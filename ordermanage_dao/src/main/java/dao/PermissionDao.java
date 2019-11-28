package dao;

import domain.Permission;
import domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    @Select("select *from permission where id in (select permissionId  from role_permission where roleId = #{rid})")
    List<Permission> findByRid(String rid);
    @Select("select *from permission")
    List<Permission> findAll();
    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void add(Permission permission);
    @Select("select * from permission where id = #{id}")
    Permission findById(String id);
    @Update("update permission set permissionName = #{permissionName},url = #{url} where id = #{id}")
    void update(Permission permission);
    @Delete("delete from permission where id = #{id}")
    void del(String id);
}
