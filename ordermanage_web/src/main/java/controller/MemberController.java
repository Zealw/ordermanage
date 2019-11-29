package controller;

import com.github.pagehelper.PageInfo;
import domain.Member;
import domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.MemberService;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @RequestMapping("/all")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Member> members = memberService.findAll(pageNum,pageSize);
        modelAndView.setViewName("member_list");
        modelAndView.getModelMap().addAttribute("members",members);
        return modelAndView;
    }


    @RequestMapping("/info")
    public ModelAndView info(String id){
        ModelAndView modelAndView = new ModelAndView();
        Member member = memberService.findById(id);
        modelAndView.getModelMap().addAttribute("member",member);
        modelAndView.setViewName("member_info");
        return modelAndView;
    }

    @RequestMapping("/findByName")
    public ModelAndView findByProductName(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "3") int pageSize,String name){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Member> all = memberService.findByName(pageNum, pageSize,name);
        modelAndView.setViewName("member_list");
        modelAndView.getModelMap().addAttribute("members",all);
        return modelAndView;
    }
}
