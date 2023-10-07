package com.dhu.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dhu.common.Result;
import com.dhu.sys.entity.Item;
import com.dhu.sys.entity.Post;
import com.dhu.sys.entity.User;
import com.dhu.sys.service.IItemService;
import com.dhu.sys.service.IPostItemService;
import com.dhu.sys.service.IPostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
@Api(tags = "订单接口列表")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private IPostItemService postItemService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getPostList(@RequestParam(value = "postId",required = false) Integer postId,
                                                  @RequestParam(value = "pageNo") Long pageNo,
                                                  @RequestParam(value = "pageSize") Long pageSize){

        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(null != postId ,Post::getPostId,postId);
        wrapper.orderByDesc(Post::getId);

        Page<Post> page = new Page<>(pageNo,pageSize);
        postService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

        return Result.success(data);
    }

    @GetMapping("/{id}")
    public Result<List<Integer>> getItemByPostId(@PathVariable("id") Integer id){
        List<Integer> itemIdList = postItemService.getItemIdById(id);
        return Result.success(itemIdList);
    }

}
