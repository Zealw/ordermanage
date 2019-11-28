package controller;

import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.MemberService;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @RequestMapping("/all")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Member> members = memberService.findAll();
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
}
