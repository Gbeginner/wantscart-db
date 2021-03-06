package com.wantscart.jade.datasource;

/**
 * 定义单个数据表的配置描述项。
 * 
 * @author han.liao
 */
public interface RoutingDescriptor {

    /**
     * 返回配置的数据源名称: dbName.
     * 
     *  配置的数据源名称: dbName
     */
    String getDbName();

    /**
     * 获取一个散库的路由, 用于计算散库后的数据库: Pattern 名称。
     * 
     *  散库的路由, 返回 <code>null</code> 表示不需要散库
     */
    Router getDbRouter();

    /**
     * 获取一个散表的路由, 用于计算散表后的数据表名称。
     * 
     *  散表的路由, 返回 <code>null</code> 表示不需要散表
     */
    Router getTableRouter();
}
