package com.dhu.sys.service;

import com.dhu.sys.entity.Item;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dhu.sys.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
public interface IItemService extends IService<Item> {

    void addToPost(Item item,Integer postId);

    Integer createPost(User user);
}
