package dao;

import domain.Product;
import domain.QueryVo;
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
    @Insert("insert into product values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void add(Product product);
    @Delete("delete from product where id = #{id}")
    void del(String id);
    @Update("update product set productNum = #{productNum}, productName = #{productName},departureTime = #{departureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus},cityName = #{cityName} where id = #{id}")
    void update(Product product);
    @Select("select *from product where id = #{id} ")
    Product findById(String id);
    @Update("update product set productStatus = #{productStatus} where id = #{id}")
    void updateStatus(Product product);
    @Select("select *from product where productName like #{productName} ")
    List<Product> findByProductName(String productName);
    @Select("SELECT * FROM product")
    List<Product> findOrderBy();





}
