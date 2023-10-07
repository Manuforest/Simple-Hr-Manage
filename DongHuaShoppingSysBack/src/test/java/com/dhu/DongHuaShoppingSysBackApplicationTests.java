package com.dhu;

import com.dhu.sys.entity.Item;
import com.dhu.sys.entity.Post;
import com.dhu.sys.entity.User;
import com.dhu.sys.entity.UserPost;
import com.dhu.sys.mapper.ItemMapper;
import com.dhu.sys.mapper.PostMapper;
import com.dhu.sys.mapper.UserMapper;
import com.dhu.sys.mapper.UserPostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DongHuaShoppingSysBackApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private PostMapper postMapper;
    @Resource
    private UserPostMapper userPostMapper;

    @Test
    void testMapper() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void testMapper2() {
        List<Item> items = itemMapper.selectList(null);
        items.forEach(System.out::println);
    }

    @Test
    void testMapper3() {
        userPostMapper.insert(new UserPost(null,1,2));
    }
}
