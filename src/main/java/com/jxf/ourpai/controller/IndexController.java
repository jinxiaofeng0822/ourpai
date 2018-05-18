package com.jxf.ourpai.controller;

import com.jxf.ourpai.dao.mapper.write.ViewIndexMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
        String Xrealip = request.getHeader("X-real-ip");
        String XForwardedFor = request.getHeader("X-Forwarded-For");
        log.info("Xrealip-{}",Xrealip);
        log.info("XForwardedFor-{}",XForwardedFor);
        Map<String,Object> map = new HashMap<>();
        map.put("ip",Xrealip);
        vi.insert(map);
        return "{\"hello\":\"qqq\"}";
    }

    public static void main(String[] args) {
        System.out.println("hehehe");
    }
}
