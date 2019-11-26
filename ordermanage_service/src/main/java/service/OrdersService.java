package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.OrdersDao;
import domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    public PageInfo<Orders> findAll(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> orders = ordersDao.findAll();
        return new PageInfo<>(orders);
    }
    public Orders findById(String id){
            return ordersDao.findById(id);
    }

}
