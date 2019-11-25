package dao;

import domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    @Select("select *from product ")
    List<Product> findAll();
    @Insert("insert into product values(#{id},#{productNum},#{productName},#{departureTime},#{productPrice},#{productDesc},#{productStatus},#{cityName})")
    void add(Product product);
    @Delete("delete from product where id = #{id}")
    void del(String id);
    @Update("update product set productNum = #{productNum}, productName = #{productName},departureTime = #{departureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus},cityName = #{cityName} where id = #{id}")
    void update(Product product);
    @Select("select *from product where id = #{id} ")
    Product findById(String id);
}
