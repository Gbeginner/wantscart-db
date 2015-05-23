package cn.techwolf.jade.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import cn.techwolf.jade.datasource.DataSourceFactory;

/**
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * 
 */
public abstract class XnDataSourceFactory implements DataSourceFactory {

    private Map<String, DataSource> cached = new HashMap<String, DataSource>();

    @Override
    public abstract DataSource getDataSource(Class<?> daoClass);

    public void remove(XnDataSource xnDataSource) {
        cached.remove(xnDataSource.getBizName());
    }

}
