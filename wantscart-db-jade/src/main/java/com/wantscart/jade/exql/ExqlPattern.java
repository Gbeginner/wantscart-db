package com.wantscart.jade.exql;

import java.util.Map;

/**
 * 定义一个语句的执行接口。
 * 
 * @author han.liao
 */
public interface ExqlPattern {

    /**
     * 输出全部的语句内容。
     * 
     *  context - 输出上下文
     * 
     *  map - 参数表
     * 
     *  语句内容
     * 
     * @throws Exception
     */
    String execute(ExqlContext context, Map<String, ?> map) throws Exception;

    /**
     * 输出全部的语句内容。
     * 
     *  context - 输出上下文
     * 
     *  mapVars - 参数表
     *  mapConsts - 常量表
     * 
     *  语句内容
     * 
     * @throws Exception
     */
    String execute(ExqlContext context, Map<String, ?> mapVars, // NL
            Map<String, ?> mapConsts) throws Exception;
}
