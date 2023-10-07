package com.dhu.sys.service.impl;

import com.dhu.sys.entity.*;
import com.dhu.sys.mapper.ItemMapper;
import com.dhu.sys.mapper.PostItemMapper;
import com.dhu.sys.mapper.PostMapper;
import com.dhu.sys.mapper.UserPostMapper;
import com.dhu.sys.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {
    @Resource
    private PostItemMapper postItemMapper;
    @Resource
    private UserPostMapper userPostMapper;
    @Resource
    private PostMapper postMapper;

    @Override
    public void addToPost(Item item,Integer postId) {
        postItemMapper.insert(new PostItem(null, postId, item.getId()));
    }
    private int generateRandomOrderId() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = dateFormat.format(now);
        Random random = new Random();
        int randomValue = random.nextInt(100);
        String orderId = formattedDate + String.format("%02d", randomValue);
        return Integer.parseInt(orderId);
    }
    @Override
    public Integer createPost(User user) {
        int orderId = generateRandomOrderId();
        userPostMapper.insert(new UserPost(null,user.getId(),orderId));
        postMapper.insert(new Post(orderId,1,null));
        return orderId;
    }

}
