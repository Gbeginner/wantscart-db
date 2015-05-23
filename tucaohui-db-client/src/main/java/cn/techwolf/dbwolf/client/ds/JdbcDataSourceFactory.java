package cn.techwolf.dbwolf.client.ds;

import javax.sql.DataSource;

import cn.techwolf.dbwolf.xml.DbServerConfig;

/**
 * jdbc数据源工厂.
 * 
 */
public interface JdbcDataSourceFactory {

    /**
     * 创建一个数据源.
     * 
     * @param server 数据库服务器配置
     * @return
     */
    DataSource createDataSource(final DbServerConfig server);

    /**
     * 回收一个数据源. 数据源被回收后将不能再被使用.
     * 
     * @param ds 将要被回收的数据源
     */
    void closeDataSource(final DataSource ds);

    /**
     * 获取一个数据源的描述信息.
     * 
     * @param ds
     * @return
     */
    String describeDataSource(final DataSource ds);

}
