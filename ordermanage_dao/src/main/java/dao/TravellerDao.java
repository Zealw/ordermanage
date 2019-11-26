package dao;

import domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellerDao {

    @Select("SELECT *FROM traveller WHERE id IN (SELECT travellerId FROM orders_traveller WHERE ordersId = #{id} )")
    List<Traveller> findById(String id);
}
