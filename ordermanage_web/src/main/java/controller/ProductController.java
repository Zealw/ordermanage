package controller;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.setViewName("order_manage");
        modelAndView.getModelMap().addAttribute("products",products);
        return modelAndView;
    }
    @RequestMapping("/add")
    public String add(Product product){
        productService.add(product);
        return "forward:/product/findAll";
    }
    @RequestMapping("/del")
    public String del(String[] id){
        for(String s : id){
            productService.del(s);
        }
        return "forward:/product/findAll";
    }
    @RequestMapping("/update")
    public String update(Product product){
       productService.update(product);
        return "forward:/product/findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id ){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        modelAndView.getModelMap().addAttribute("product",product);
        modelAndView.setViewName("product_update");
        return modelAndView;

    }



}

