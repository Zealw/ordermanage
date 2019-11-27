package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.MemberDao;
import dao.OrdersDao;
import dao.ProductDao;
import dao.TravellerDao;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private TravellerDao travellerDao;

    public PageInfo<Orders> findAll(int pageNum,int pageSize){
        sort();
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> orders = ordersDao.findAll();
        return new PageInfo<>(orders);
    }
    public void sort(){
        List<Orders> orders = ordersDao.findAll();
        for(Orders order:orders){
            boolean b = order.getOrderStatus() == 0 && (new Date().getTime() - order.getOrderTime().getTime())>15*60;
            System.out.println(b);
            if(order.getOrderStatus() == 0 && (new Date().getTime() - order.getOrderTime().getTime())>10*1000 ){
                ordersDao.delById(order.getId());
            }
        }
    }
    public Orders findById(String id){
            return ordersDao.findById(id);
    }
    public void updateStatus(String id){
         ordersDao.updateOrderStatus(id);
    }
    public void addOrder(Orders orders){
        String numStr = ordersDao.findMaxOrderNum();
        int num = Integer.parseInt(numStr) + 1;
        numStr = String.valueOf(num);
        orders.setOrderNum(numStr);
        orders.setId(UUID.randomUUID().toString());
        orders.setOrderTime(new Date());
        orders.setOrderStatus(0);
        ordersDao.addOrder(orders);
    }
    public QueryVo findQuery(){
        List<Product> products = productDao.findAll();
        List<Member> members = memberDao.findAll();
        List<Traveller> travellers = travellerDao.findAll();
        QueryVo queryVo = new QueryVo();
        queryVo.setMembers(members);
        queryVo.setProducts(products);
        queryVo.setTravellers(travellers);
        return queryVo;

    }




}
