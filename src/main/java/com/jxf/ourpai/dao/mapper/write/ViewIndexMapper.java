package com.jxf.ourpai.dao.mapper.write;

import com.jxf.ourpai.model.ViewIndex;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * 首页浏览量
 */
public interface ViewIndexMapper extends Mapper<ViewIndex> {
    void customInsert(Map<String,Object> map);
}
