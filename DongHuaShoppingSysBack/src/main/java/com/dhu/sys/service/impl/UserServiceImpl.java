package com.dhu.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dhu.common.Result;
import com.dhu.sys.entity.User;
import com.dhu.sys.mapper.UserMapper;
import com.dhu.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhu.common.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public Map<String, Object> login(User user) {
        //查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        User loginUser = this.baseMapper.selectOne(wrapper);
        if (loginUser != null && passwordEncoder.matches(user.getPassword(), loginUser.getPassword())){
            //JWT
            loginUser.setPassword(null);
            String token = jwtUtil.createToken(loginUser);
            //返回数据
            Map<String,Object> data = new HashMap<>();
            data.put("token",token);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        User loginUser = null;
        try {
            loginUser = jwtUtil.parseToken(token,User.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (loginUser != null){
            Map<String, Object> data = new HashMap<>();
            data.put("name",loginUser.getUsername());

            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
    }



}
