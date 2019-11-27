package dao;

import domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role where id in( select roleId from user_role where userId = #{userId})")
    List<Role> findByUid(String userId);
}
