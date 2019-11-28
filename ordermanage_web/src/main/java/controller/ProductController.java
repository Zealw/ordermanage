package controller;

import com.github.pagehelper.PageInfo;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Product> all = productService.findAll(pageNum, pageSize);
        modelAndView.setViewName("product_manage");
        modelAndView.getModelMap().addAttribute("products",all);
        return modelAndView;
    }
    @RequestMapping("/findOrderBy")
    public ModelAndView findOrderBy(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize,String orderSql){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Product> all = productService.findOrderBy(pageNum, pageSize,orderSql);
        modelAndView.setViewName("product_manage");
        modelAndView.getModelMap().addAttribute("products",all);
        return modelAndView;
    }
    @RequestMapping("/findByProductName")
    public ModelAndView findByProductName(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize,String productName){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Product> all = productService.findByProductName(pageNum, pageSize,productName);
        modelAndView.setViewName("product_manage");
        modelAndView.getModelMap().addAttribute("products",all);
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
    @RequestMapping("/updateStatusOpen")
    public String updateStatusOpen(String[] id){
        if(id != null) {
            for (String s : id) {
                productService.updateStatusOpen(s);
            }
        }
        return "redirect:/product/findAll";
    }
    @RequestMapping("/updateStatusClose")
    public String updateStatusClose(String[] id){
        if(id != null){
            for(String s : id){
                productService.updateStatusClose(s);
            }
        }

        return "redirect:/product/findAll";
    }



}

