package controller;

import com.github.pagehelper.PageInfo;
import domain.Member;
import domain.Role;
import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.RoleService;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/all")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<UserInfo> users = userService.findAll(pageNum,pageSize);
        modelAndView.setViewName("user_list");
        modelAndView.getModelMap().addAttribute("users",users);
        return modelAndView;
    }
    @RequestMapping("/findOthersById")
    public ModelAndView findOthersById(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_role_add");
        List<Role> roles = roleService.findOthersById(id);
        modelAndView.getModelMap().addAttribute("roles",roles);
        modelAndView.getModelMap().addAttribute("id",id);
        return modelAndView;
    }
    @RequestMapping("/add")
    public String add(UserInfo userInfo){
        userService.add(userInfo);
        return "redirect:/user/all";
    }

    @RequestMapping("/info")
    public ModelAndView info(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userService.findById(id);
        modelAndView.getModelMap().addAttribute("user",user);
        modelAndView.setViewName("user_info");
        return modelAndView;
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId,String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:/user/all";
    }
    @RequestMapping("/findByUsername")
    public ModelAndView findByProductName(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize,String username){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<UserInfo> all = userService.findByUsername(pageNum, pageSize,username);
        modelAndView.setViewName("user_list");
        modelAndView.getModelMap().addAttribute("users",all);
        return modelAndView;
    }
}

