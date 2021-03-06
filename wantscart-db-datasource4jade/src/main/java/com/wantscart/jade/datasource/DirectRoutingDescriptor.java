package com.wantscart.jade.datasource;

/**
 * 实现简单的散表配置项。
 * 
 * @author han.liao
 */
public class DirectRoutingDescriptor implements RoutingDescriptor {

    protected String dbName;

    /**
     * 创建简单的散表配置项。
     * 
     *  dbName - 数据源名称
     */
    public DirectRoutingDescriptor(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String getDbName() {
        return dbName;
    }

    /**
     * 设置数据源名称。
     * 
     *  dbName - 数据源名称
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public Router getDbRouter() {
        return null; // 没有路由
    }

    @Override
    public Router getTableRouter() {
        return null; // 没有路由
    }
}
