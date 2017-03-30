package com.wantscart.jade.exql.impl;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wantscart.jade.exql.ExprResolver;
import com.wantscart.jade.exql.ExqlContext;
import com.wantscart.jade.exql.ExqlPattern;
import com.wantscart.jade.exql.ExqlUnit;

/**
 * 实现语句的执行接口。
 * 
 * @author han.liao
 */
public class ExqlPatternImpl implements ExqlPattern {

    // 输出日志
    private static final Log logger = LogFactory.getLog(ExqlPattern.class);

    // 语句的缓存
    private static final ConcurrentHashMap<String, ExqlPattern> cache = new ConcurrentHashMap<String, ExqlPattern>();

    // 编译的语句
    protected final String pattern;

    // 输出的单元
    protected final ExqlUnit unit;

    /**
     * 构造语句的执行接口。
     * 
     *  pattern - 编译的语句
     *  unit - 输出的单元
     */
    protected ExqlPatternImpl(String pattern, ExqlUnit unit) {
        this.pattern = pattern;
        this.unit = unit;
    }

    /**
     * 从语句编译: ExqlPattern 对象。
     * 
     *  pattern - 待编译的语句
     * 
     *  ExqlPattern 对象
     */
    public static ExqlPattern compile(String pattern) {

        // 从缓存中获取编译好的语句
        ExqlPattern compiledPattern = cache.get(pattern);
        if (compiledPattern == null) {

            // 输出日志
            if (logger.isDebugEnabled()) {
                logger.debug("EXQL pattern compiling:\n    pattern: " + pattern);
            }

            // 重新编译语句
            ExqlCompiler compiler = new ExqlCompiler(pattern);
            compiledPattern = compiler.compile();

            // 语句的缓存
            cache.putIfAbsent(pattern, compiledPattern);
        }

        return compiledPattern;
    }

    @Override
    public String execute(ExqlContext context, Map<String, ?> map) throws Exception {

        // 执行转换
        return execute(context, new ExprResolverImpl(map));
    }

    @Override
    public String execute(ExqlContext context, Map<String, ?> mapVars, Map<String, ?> mapConsts)
            throws Exception {

        // 执行转换
        return execute(context, new ExprResolverImpl(mapVars, mapConsts));
    }

    // 执行转换
    protected String execute(ExqlContext context, ExprResolver exprResolver) throws Exception {

        // 转换语句内容
        unit.fill(context, exprResolver);

        String flushOut = context.flushOut();

        // 输出日志
        if (logger.isDebugEnabled()) {
            logger.debug("EXQL pattern executing:\n    origin: " + pattern + "\n    result: "
                    + flushOut + "\n    params: " + Arrays.toString(context.getParams()));
        }

        return flushOut;
    }

}
