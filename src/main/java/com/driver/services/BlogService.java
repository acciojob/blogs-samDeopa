package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        Blog blog = new Blog(title, content);
        blog.setPubDate(new Date());
        User user = userRepository1.findById(userId).get();

        List<Blog> userBlocks = user.getWrittenBlogs();
        userBlocks.add(blog);
        user.setWrittenBlogs(userBlocks);

        blog.setUser(user);

        userRepository1.save(user);
        return  blog;
        //create a blog at the current time

    }

    public void deleteBlog(int blogId){

        Blog blog = blogRepository1.findById(blogId).get();

        User user = blog.getUser();

        List<Blog> blogsList = user.getWrittenBlogs();
        blogsList.remove(blog);
        user.setWrittenBlogs(blogsList);

        blogRepository1.deleteById(blog.getId());
        //delete blog and corresponding images

    }
}
