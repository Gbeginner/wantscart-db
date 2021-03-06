package com.wantscart.db.client.ds;

import com.wantscart.db.xml.DbServerConfig;

import javax.sql.DataSource;


/**
 * jdbc数据源工厂.
 * 
 */
public interface JdbcDataSourceFactory {

    /**
     * 创建一个数据源.
     * 
     *  server 数据库服务器配置
     *
     */
    DataSource createDataSource(final DbServerConfig server);

    /**
     * 回收一个数据源. 数据源被回收后将不能再被使用.
     * 
     *  ds 将要被回收的数据源
     */
    void closeDataSource(final DataSource ds);

    /**
     * 获取一个数据源的描述信息.
     * 
     *  ds
     *
     */
    String describeDataSource(final DataSource ds);

}
