package com.wantscart.jade.datasource;

import java.sql.SQLException;

/**
 * 提供单个数据表的散表配置。
 * 
 * @author han.liao
 */
public interface Router {

    /**
     * 获取散列的列名。
     * 
     *  散列的列名
     */
    String getColumn();

    /**
     * 根据列名的值，计算重定向的散列名。 如果不需要重定向, 可以返回 <code>null</code>.
     * 
     *  columnValue - 列名的值
     * 
     *  重定向的散列名
     * 
     * @throws SQLException
     */
    String doRoute(Object columnValue);
}
