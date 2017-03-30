package com.wantscart.jade.exql;

/**
 * 定义一个语句输出单元, 可以进行组装。
 * 
 * @author han.liao
 */
public interface ExqlUnit {

    String BLANK = "   ";

    /**
     * 检查单元的内容是否有效。
     * 
     *  exprResolver - 使用的引擎
     * 
     *  内容是否有效
     * 
     * @throws Exception
     */
    boolean isValid(ExprResolver exprResolver);

    /**
     * 输出单元的语句内容。
     * 
     *  exqlContext - 输出上下文
     *  exprResolver - 使用的引擎
     * 
     * @throws Exception
     */
    void fill(ExqlContext exqlContext, ExprResolver exprResolver) throws Exception;

    /**
     * 输出xml格式的数据
     * 
     *  xml
     */
    void toXml(StringBuffer xml, String prefix);

}
