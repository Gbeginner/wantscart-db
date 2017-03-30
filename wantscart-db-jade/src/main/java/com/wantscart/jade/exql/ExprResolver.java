package com.wantscart.jade.exql;

/**
 * 定义处理表达式的接口, 以兼容不同的表达式语法。
 * 
 * @author han.liao
 */
public interface ExprResolver {

    /**
     * 返回变量的内容。
     * 
     *  variant - 变量的名称
     * 
     *  变量的内容
     */
    Object getVar(String variant);

    /**
     * 设置变量的内容。
     * 
     *  variant - 变量的名称
     * 
     *  value - 变量的内容
     */
    void setVar(String variant, Object value);

    /**
     * 返回在语句输出的内容。
     * 
     *  expression - 解释的表达式
     * 
     *  输出的内容
     * 
     * @throws Exception
     */
    Object executeExpr(String expression) throws Exception;
}
