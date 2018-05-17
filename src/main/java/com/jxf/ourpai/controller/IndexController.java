package com.jxf.ourpai.controller;

import com.jxf.ourpai.dao.mapper.write.ViewIndexMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ViewIndexMapper vi;

    private static int viewCount = 0;

    @RequestMapping("/viewIndex")
    public String viewIndex(HttpServletRequest request){
        viewCount++;
        log.info("有{}个访问了",viewCount);
        log.info("访问人ip地址是:{}",request.getRemoteAddr());
        vi.insert();
        return "{\"hello\":\"qqq\"}";
    }

    public static void main(String[] args) {
        System.out.println("hehehe");
    }
}
