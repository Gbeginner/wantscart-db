package cn.techwolf.jade.core;

import java.util.Map;

import cn.techwolf.jade.provider.Modifier;

/**
 * 定义一组数据库操作。
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * @author han.liao
 */
public interface JadeOperation {

    /**
     * 
     * @return
     */
    public Modifier getModifier();

    /**
     * 执行所需的数据库操作。
     * 
     * @return
     */
    public Object execute(Map<String, Object> parameters);
}
