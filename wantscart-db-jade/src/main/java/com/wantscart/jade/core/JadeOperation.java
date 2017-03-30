package com.wantscart.jade.core;

import com.wantscart.jade.provider.Modifier;

import java.util.Map;

/**
 * 定义一组数据库操作。
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * @author han.liao
 */
public interface JadeOperation {

    /**
     * 
     *
     */
    public Modifier getModifier();

    /**
     * 执行所需的数据库操作。
     * 
     *
     */
    public Object execute(Map<String, Object> parameters);
}
