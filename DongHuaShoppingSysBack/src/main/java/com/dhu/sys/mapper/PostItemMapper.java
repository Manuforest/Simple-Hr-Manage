package com.dhu.sys.mapper;

import com.dhu.sys.entity.PostItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cwq
 * @since 2023-10-03
 */
public interface PostItemMapper extends BaseMapper<PostItem> {
    List<Integer> getItemIdByPostId(Integer postId);
}
