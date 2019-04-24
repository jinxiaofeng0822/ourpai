package com.jxf.ourpai.controller;

import com.jxf.ourpai.dao.mapper.write.MovieNameMapper;
import com.jxf.ourpai.model.MovieName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jin Xiaofeng
 */
@RestController
public class movieNameController {
    private static final Logger log = LoggerFactory.getLogger(movieNameController.class);

    @Autowired
    private MovieNameMapper mapper;

    @RequestMapping("/addName")
    public String addName(){
        MovieName mn=new MovieName();
        mn.setMovieName("电影名字");
        mn.setFullpathName("路径123123");
        mapper.insertSelective(mn);
        return "{\"ret\":\"1\"}";
    }

    public static void main(String[] args) {

    }
}
