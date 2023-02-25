package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image();
        image.setBlog(blog);
        image.setDescription(description);
        image.setDimensions(dimensions);

        List<Image> listOfImage = blog.getImageList();
        listOfImage.add(image);
        blog.setImageList(listOfImage);



        blogRepository2.save(blog);
        //add an image to the blog
        return  image;
    }

    public void deleteImage(Integer id){
        Image image = imageRepository2.findById(id).get();
        Blog blog = image.getBlog();
        List<Image> listOfImage = blog.getImageList();
        listOfImage.remove(image);
        blog.setImageList(listOfImage);
        imageRepository2.deleteById (image.getId());
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {

        Image image = imageRepository2.findById(id).get();
        String imageDimension = image.getDimensions();
        int screenArea = Integer.parseInt(screenDimensions.substring(0,1))* Integer.parseInt(screenDimensions.substring(2));
        int imageArea = Integer.parseInt(imageDimension.substring(0,1))* Integer.parseInt(imageDimension.substring(2));
        int count = screenArea/imageArea;
        return  count;
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

    }
}
