package com.wantscart.jade.datasource;

/**
 * 存放: XceDataSource 的配置信息。
 * 
 * @author han.liao
 */
public interface RoutingConfigurator {

    /**
     * 返回 Catalog 的配置信息。
     * 
     *  catalog - 模块名称
     * 
     *  数据表的配置信息
     */
    RoutingDescriptor getCatalogDescriptor(String catalog);

    /**
     * 返回数据表的配置信息。
     * 
     *  catalog - 模块名称
     * 
     *  name - 数据表名称
     * 
     *  数据表的配置信息
     */
    RoutingDescriptor getDescriptor(String catalog, String name);
}
