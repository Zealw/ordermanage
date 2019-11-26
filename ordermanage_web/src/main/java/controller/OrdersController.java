package controller;

import com.github.pagehelper.PageInfo;
import domain.Orders;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.OrdersService;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/all")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "3") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Orders> orders = ordersService.findAll(pageNum,pageSize);
        modelAndView.setViewName("order_list");
        modelAndView.getModelMap().addAttribute("orders",orders);
        return modelAndView;
    }
    @RequestMapping("/info")
    public ModelAndView info(String id){
        ModelAndView modelAndView = new ModelAndView();
        Orders order = ordersService.findById(id);
        modelAndView.setViewName("order_info");
        modelAndView.getModelMap().addAttribute("order",order);
        return modelAndView;
    }


}
