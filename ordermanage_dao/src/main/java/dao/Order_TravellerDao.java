package dao;

import domain.Order_Traveller;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_TravellerDao {
    @Insert("insert into orders_traveller values(#{orderId},#{travellerId})")
    void addOaT(Order_Traveller order_traveller);
}
