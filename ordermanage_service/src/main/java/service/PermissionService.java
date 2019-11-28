package service;

import dao.PermissionDao;
import dao.RoleDao;
import domain.Permission;
import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    public List<Permission> findAll(){
        return permissionDao.findAll();
    }
    public void add(Permission permission){
        permission.setId(UUID.randomUUID().toString());
        permissionDao.add(permission);
    }
    public void update(Permission permission){
        permissionDao.update(permission);
    }
    public void del(String id){
        permissionDao.del(id);
    }
    public Permission findById(String id){
        return permissionDao.findById(id);
    }


}
