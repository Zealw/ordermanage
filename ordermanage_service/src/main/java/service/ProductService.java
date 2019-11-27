package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.ProductDao;
import domain.Member;
import domain.Orders;
import domain.Product;
import domain.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    public PageInfo<Product> findAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Product> all = productDao.findAll();
        return new PageInfo<>(all);
    }
    public PageInfo<Product> findOrderBy(int pageNum, int pageSize,String orderSql){
        PageHelper.startPage(pageNum,pageSize,orderSql);
        List<Product> all = productDao.findOrderBy();
        return new PageInfo<>(all);
    }
    public void add(Product product){
        product.setId(UUID.randomUUID().toString());
        productDao.add(product);
    }
    public void del(String id){
        productDao.del(id);
    }
    public void update(Product product){
        productDao.update(product);
    }
    public Product findById(String id){
        return productDao.findById(id);
    }
    public void updateStatusOpen(String id){
        Product product = new Product();
        product.setId(id);
        product.setProductStatus(1);
        productDao.updateStatus(product);
    }
    public void updateStatusClose(String id){
        Product product = new Product();
        product.setId(id);
        product.setProductStatus(0);
        productDao.updateStatus(product);
    }
    public PageInfo<Product> findByProductName(int pageNum, int pageSize,String productName){
        PageHelper.startPage(pageNum,pageSize);
        productName = "%" +productName +"%";
        List<Product> all = productDao.findByProductName(productName);
        return new PageInfo<>(all);
    }


}

