package com.dhu.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dhu.common.Result;
import com.dhu.sys.entity.Item;
import com.dhu.sys.entity.Post;
import com.dhu.sys.entity.User;
import com.dhu.sys.service.IItemService;
import com.dhu.sys.service.IPostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cwq
 * @since 2023-09-26
 */
@Api(tags = "商品接口列表")
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private IItemService itemService;


    @GetMapping("/list")
    public Result<Map<String,Object>> getItemList(@RequestParam(value = "itemname",required = false) String Itemname,
                                                  @RequestParam(value = "pageNo") Long pageNo,
                                                  @RequestParam(value = "pageSize") Long pageSize){

        LambdaQueryWrapper<Item> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(Itemname),Item::getItemname,Itemname);
        wrapper.orderByDesc(Item::getId);

        Page<Item> page = new Page<>(pageNo,pageSize);
        itemService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

        return Result.success(data);
    }

    @GetMapping("/{id}")
    public Result<Item> getItemById(@PathVariable("id") Integer id){
        Item item = itemService.getById(id);
        return Result.success(item);
    }

    @PostMapping
    public  Result<?> createPost(@RequestBody User user){
        Integer postId = itemService.createPost(user);
        return Result.success(postId);
    }

    @PostMapping("/add")
    public Result<?> addToPost(@RequestBody Item item) {
        itemService.addToPost(item, item.getPostId());
        return Result.success(item.getId());
    }

}
