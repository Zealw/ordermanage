package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.MemberDao;
import domain.Member;
import domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;
    public Member findById(String id){
        return memberDao.findById(id);
    }
    public PageInfo<Member> findAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Member> members = memberDao.findAll();
        return new PageInfo<>(members);
    }
    public PageInfo<Member> findByName(int pageNum, int pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        name = "%" +name +"%";
        List<Member> all = memberDao.findByName(name);
        return new PageInfo<>(all);
    }

}
