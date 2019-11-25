package service;

import dao.ProductDao;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    public List<Product> findAll(){
        return productDao.findAll();
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
}

