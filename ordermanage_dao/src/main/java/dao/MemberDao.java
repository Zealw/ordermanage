package dao;

import domain.Member;
import domain.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {
    @Select("select * from member")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "travellers",column = "id",many = @Many(select = "dao.TravellerDao.findByMid"))
    })
    List<Member> findAll();
    @Select("select * from member where id = #{id}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "travellers",column = "id",many = @Many(select = "dao.TravellerDao.findByMid"))
    })
    Member findById(String id);

    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "travellers",column = "id",many = @Many(select = "dao.TravellerDao.findByMid"))
    })
    @Select("select *from member where name like #{name} ")
    List<Member> findByName(String name);
}
