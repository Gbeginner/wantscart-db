/*
 * 	This program is free software; you can redistribute it and/or modify it under the terms of 
 * the GNU General Public License as published by the Free Software Foundation; either version 3 of the License, 
 * or (at your option) any later version. 
 * 
 * 	This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details. 
 * 	You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.wantscart.db.parser.function;

import java.util.List;

import com.wantscart.db.parser.expression.Expression;
import com.wantscart.db.sqljep.ParseException;

/**
 * 
 * @author <a href=mailto:piratebase@sina.com>Struct chen</a>
 * 
 */
public interface Function {

    @SuppressWarnings("unchecked")
    Comparable evaluate(List<Expression> list, Object[] parameters) throws ParseException;

    /**
     * 获得函数名称
     * 
     *
     */
    public String getName();

    /**
     * 设置函数名称
     * 
     *  name
     */
    public void setName(String name);

    void toString(List<Expression> list, StringBuilder builder);
}
