package com.dhu.sys.service.impl;

import com.dhu.sys.entity.Post;
import com.dhu.sys.mapper.PostMapper;
import com.dhu.sys.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
