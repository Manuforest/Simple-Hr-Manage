package com.dhu.sys.service;

import com.dhu.sys.entity.PostItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cwq
 * @since 2023-10-03
 */
public interface IPostItemService extends IService<PostItem> {

    List<Integer> getItemIdById(Integer id);
}
