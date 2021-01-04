package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired(required=false)
    private UserMapper userMapper;
    @Autowired(required=false)
    private DiscussPostMapper discussPostMapper;


    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder11@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("百里香");
        user.setPassword("12345");
        user.setSalt("qwert");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        //user.setCreateTime(new Date());
        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());
    }

    @Test
    public void testUpateUser() {
        int row1 = userMapper.updateHeader(151, "http://www.nowcoder.com/201.png");
        System.out.println(row1 + "updateHeader");

        int row2 = userMapper.updatePassword(151, "qwert12345");
        System.out.println(row2 + "updatePassword");

        int row3 = userMapper.updateStatus(151, 0);
        System.out.println(row3 + "updateStatus");
    }

    @Test
    public void testSelectPost() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost discussPost: list) {
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostsRows(0);
        System.out.println(rows);
    }

}
