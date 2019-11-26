import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
    @org.junit.Test
    public void t1(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "select *from product order by ";
        String orderSql = "productNum desc";
        if(orderSql.contains("productNum")){
            orderSql = orderSql + "productNum";
        }else if(orderSql.contains("departureTime")){
            orderSql = orderSql + "departureTime";
        }else if(orderSql.contains("productPrice")){
            orderSql = orderSql + "productPrice";
        }
    }
}
