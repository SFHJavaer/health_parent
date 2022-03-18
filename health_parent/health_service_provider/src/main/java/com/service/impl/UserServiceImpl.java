package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dao.PermissionDao;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.pojo.Permission;
import com.pojo.Role;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public User findByUserName(String username) {
        User user = userDao.findByUsername(username);
        if(user ==null){
            return null;
        }
        /***由用户id查询角色，在查询权限，赋值给user对象，return到具体赋予权限的上一层Service进行授予操作
         * 这里的Service和Dao是负责和设置对象属性业务的，目的返回给上一层，这里不处理赋权业务
         * User的属性是Role对象，Role对象的属性是Permission权限对象
         */


        Integer userId = user.getId();
        Set<Role> roles = roleDao.findByUserId(userId);
        if(roles !=null && roles.size() > 0){
            for(Role role: roles){
                Integer roleId = role.getId();
                Set<Permission> permissions = permissionDao.findByRoleId(roleId);
                if(permissions != null && permissions.size() > 0){
                    role.setPermissions(permissions);
                }

            }
            user.setRoles(roles);

        }
        return user;
    }
}
