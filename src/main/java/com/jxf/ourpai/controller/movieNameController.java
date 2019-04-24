package com.jxf.ourpai.controller;

import com.jxf.ourpai.dao.mapper.write.MovieNameMapper;
import com.jxf.ourpai.model.MovieName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jin Xiaofeng
 */
@RestController
public class movieNameController {
    private static final Logger log = LoggerFactory.getLogger(movieNameController.class);

    @Autowired
    private MovieNameMapper mapper;

    @RequestMapping("/addName")
    public String addName() {
        MovieName mn = new MovieName();
        mn.setMovieName("电影名字");
        mn.setFullpathName("路径123123");
        mapper.insertSelective(mn);
        return "{\"ret\":\"1\"}";
    }

    public static void main(String[] args) {
        int count = 0;
        File file = new File("C:\\Users\\小风\\Desktop\\testfile");
        System.out.println(file.exists());

        Queue<File> queue = new ArrayDeque<>();//保存目录
        Stack<File> stack = new Stack<>();

        //这里的栈，类似深度优先搜索
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                count++;
                System.out.println(files[i].getPath());
            } else {
                stack.push(files[i]);
            }
        }

        while (stack.size() != 0) {
            File pf = stack.pop();
            File[] pfs = pf.listFiles();
            for (int i = 0; i < pfs.length; i++) {
                if (pfs[i].isFile()) {
                    count++;
                    System.out.println(pfs[i].getPath());
                } else {
                    stack.push(pfs[i]);
                }
            }
        }
        System.out.println("执行完毕");
        System.out.println("共有" + count + "个文件");

        System.out.println("开始队列打印");
        file.listFiles();
        count=0;
        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile()){
                count++;
                System.out.println(files[i].getPath());
            }else{
                queue.add(files[i]);
            }
        }


        while (queue.size()!=0){
            File pf = queue.poll();
            File[] pfs = pf.listFiles();
            for (int i = 0; i < pfs.length; i++) {
                if(pfs[i].isFile()){
                    count++;
                    System.out.println(pfs[i].getPath());
                }else{
                    queue.add(pfs[i]);
                }
            }
        }

        System.out.println("执行完毕");
        System.out.println("共有" + count + "个文件");
    }
}
