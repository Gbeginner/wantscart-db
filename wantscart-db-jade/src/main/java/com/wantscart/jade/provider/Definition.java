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
package com.wantscart.jade.provider;

import com.wantscart.jade.core.GenericUtils;
import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;


/**
 * 提供 Definition 包装对 DAO 的定义。<br/>
 * <p/>
 * {@link Definition#constants}
 * Map对象包括了类的所有接口属性、所有父类和自己的静态常量，非静态常量不包括在该Map中。
 *
 * @author 王志亮 [qieqie.wang@gmail.com]
 * @author 廖涵 [in355hz@gmail.com]
 */
public class Definition {

    private final Class<?> clazz;

    private final Class<?> genericsClazz;

    private final Map<String, ?> constants;

    public Definition(Class<?> clazz) {
        this.clazz = clazz;
        Type[] genTypes = clazz.getGenericInterfaces();
        if(ArrayUtils.isNotEmpty(genTypes)){
            Type[] params = ((ParameterizedType) genTypes[0]).getActualTypeArguments();
            if (params.length > 0) {
                this.genericsClazz = (Class<?>) params[0];
            }else {
                this.genericsClazz = null;
            }
        }else {
            this.genericsClazz = null;
        }
        this.constants = Collections.unmodifiableMap( // NL
                GenericUtils.getConstantFrom(clazz, true, true));
    }

    public String getName() {
        return clazz.getName();
    }

    public Map<String, ?> getConstants() {
        return constants;
    }

    public Class<?> getDAOClazz() {
        return clazz;
    }

    public Class<?> getDAOGenericsClazz() {
        return genericsClazz;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Definition) {
            Definition definition = (Definition) obj;
            return clazz.equals(definition.clazz);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return clazz.hashCode() * 13;
    }

    @Override
    public String toString() {
        return clazz.getName();
    }
}
