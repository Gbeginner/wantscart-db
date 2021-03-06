/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License i distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wantscart.jade.provider.jdbc;

import com.wantscart.jade.provider.AbstractDataAccessProvider;
import com.wantscart.jade.provider.DataAccess;
import com.wantscart.jade.provider.SQLInterpreter;

import javax.sql.DataSource;

/**
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * @author 廖涵 [in355hz@gmail.com]
 */
public class JdbcDataAccessProvider extends AbstractDataAccessProvider {

    private static final SQLInterpreter[] DEF_SQLI = { new SimpleSQLInterpreter() };

    private static final JdbcWrapper[] DEF_WRAPPER = {};

    @Override
    protected final DataAccess createDataAccess(DataSource dataSource) {
        JdbcDataAccess dataAccess = createEmptyJdbcTemplateDataAccess(dataSource);
        dataAccess.setInterpreters(findSQLInterpreters());
        dataAccess.setJdbcWrappers(findJdbcWrappers());
        return dataAccess;
    }

    protected JdbcDataAccess createEmptyJdbcTemplateDataAccess(DataSource dataSource) {
        return new JdbcDataAccess(new JdbcImpl(dataSource), dataSource);
    }

    protected SQLInterpreter[] findSQLInterpreters() {
        return DEF_SQLI;
    }

    protected JdbcWrapper[] findJdbcWrappers() {
        return DEF_WRAPPER;
    }
}
