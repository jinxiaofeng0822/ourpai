package com.jxf.ourpai.controller;

import com.jxf.ourpai.dao.mapper.write.MovieNameMapper;
import com.jxf.ourpai.model.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
        File file = new File("E:\\电影");
        Stack<File> stack = new Stack<>();
        stack.push(file);
        log.info("开始保存===");
        while (stack.size() != 0) {
            File pf = stack.pop();
            File[] pfs = pf.listFiles();
            for (int i = 0; i < pfs.length; i++) {
                if (pfs[i].isFile()) {
                    log.info(pfs[i].getPath());
                    try {
                        //保存到数据库
                        FileInfo mn = new FileInfo();
                        mn.setMovieName(pfs[i].getName());
                        mn.setDirectPath(pfs[i].getParentFile().getName());
                        mn.setFullpathName(pfs[i].getPath());
                        mn.setFileType(getFileType(pfs[i].getName()));
                        mn.setFileSize(Double.valueOf(pfs[i].length()));
                        mn.setMd5(DigestUtils.md5DigestAsHex(new FileInputStream(pfs[i].getPath())));
                        mapper.insertSelective(mn);
                    } catch (Exception e) {
                        log.error("保存文件出错" + pfs[i].getPath(), e);
                    }

                } else {
                    stack.push(pfs[i]);
                }
            }
        }
        log.info("执行完毕");
        return "{\"ret\":\"1\"}";
    }

    private String getFileType(String fileName) {
        int point = fileName.lastIndexOf(".");
        if (point != -1) {
            return fileName.substring(point);
        } else {
            return "unkown";
        }
    }

    public static void main(String[] args) {
        try {
            String md5 = DigestUtils.md5DigestAsHex(new FileInputStream("C:\\Users\\小风\\Desktop\\testfile\\f1.txt"));
            System.out.println(md5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
