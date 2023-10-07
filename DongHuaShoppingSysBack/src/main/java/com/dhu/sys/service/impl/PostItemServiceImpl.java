package com.dhu.sys.service.impl;

import com.dhu.sys.entity.PostItem;
import com.dhu.sys.mapper.PostItemMapper;
import com.dhu.sys.service.IPostItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cwq
 * @since 2023-10-03
 */
@Service
public class PostItemServiceImpl extends ServiceImpl<PostItemMapper, PostItem> implements IPostItemService {
    @Resource
    private PostItemMapper postItemMapper;

    @Override
    public List<Integer> getItemIdById(Integer id) {
        return postItemMapper.getItemIdByPostId(id);
    }
}
