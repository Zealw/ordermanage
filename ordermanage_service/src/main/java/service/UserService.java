package service;

import dao.UserDao;
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

    public List<UserInfo> findAll(){
        return userDao.findAll();
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
}
