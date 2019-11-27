package dao;

import domain.Member;
import domain.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {
    @Select("select * from member")
    List<Member> findAll();
    @Select("select * from member where id = #{id}")
    Member findById(String id);
}
