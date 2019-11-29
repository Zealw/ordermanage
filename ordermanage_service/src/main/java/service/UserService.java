package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserDao;
import domain.Member;
import domain.Role;
import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for(Role role :userInfo.getRoles()){
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        User  user = new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false:true,
                true,
                true,
                true,
                list);
        return user;
    }

    public PageInfo<UserInfo> findAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> users = userDao.findAll();
        return new PageInfo<>(users);
    }
    public void add(UserInfo userInfo){
        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userDao.addUser(userInfo);
    }
    public void addRoleToUser(String userId,String[] roleIds){
        for(String roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }
    public UserInfo findById(String id){
        return userDao.findById(id);
    }

    public PageInfo<UserInfo> findByUsername(int pageNum, int pageSize,String username){
        PageHelper.startPage(pageNum,pageSize);
        username = "%" +username +"%";
        List<UserInfo> all = userDao.findByUsernameS(username);
        return new PageInfo<>(all);
    }
}
