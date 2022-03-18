package com.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pojo.Permission;
import com.pojo.Role;
import com.pojo.User;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class SpringSecurityService implements UserDetailsService {
    //通过dubbo调服务
    @Reference
    private UserService userService;
//实现UserDetailsService的loadUserByUsername方法
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if(user == null){
            //查不到用户
            return null;
        }
        //创建存放权限的集合
        List<GrantedAuthority> list = new ArrayList<>();
        //查看用户角色(角色与user直接关联)
        Set<Role> roles = user.getRoles();
        for(Role role : roles){
            /***遍历角色的关键字，即将字符串类型的角色授予到list，间接授予给用户
             * 默认ROLE_开头的为角色，其他属性为权限
             */
            list.add(new SimpleGrantedAuthority(role.getKeyword()));
            //间接查角色的权限grant集合
            Set<Permission> permissions = role.getPermissions();
            for(Permission permission : permissions){
                list.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }
        //UserDetails是接口，new出来它的实现类User，并初始化三个参数
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(), list);
        //返回给接口，接口接收到会自动处理并处理
        return userDetails;
        /***
         * 如果是明文的密码需要在password前面加上字符串{nood}，因为配置了加密，客户端的密码会自动转为指定的密文和服务器端的password进行比对
         */
    }
}
