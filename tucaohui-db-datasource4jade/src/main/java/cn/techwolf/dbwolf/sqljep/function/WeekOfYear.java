/*****************************************************************************
      SQLJEP - Java SQL Expression Parser 0.2
      November 1 2006
         (c) Copyright 2006, Alexey Gaidukov
      SQLJEP Author: Alexey Gaidukov

      SQLJEP is based on JEP 2.24 (http://www.singularsys.com/jep/)
           (c) Copyright 2002, Nathan Funk
 
      See LICENSE.txt for license information.
 *****************************************************************************/

package cn.techwolf.dbwolf.sqljep.function;

import static java.util.Calendar.WEEK_OF_YEAR;

import java.sql.Timestamp;
import java.util.Calendar;

import cn.techwolf.dbwolf.sqljep.ASTFunNode;
import cn.techwolf.dbwolf.sqljep.JepRuntime;
import cn.techwolf.dbwolf.sqljep.ParseException;

public class WeekOfYear extends PostfixCommand {

    final public int getNumberOfParameters() {
        return 1;
    }

    public Comparable<?>[] evaluate(ASTFunNode node, JepRuntime runtime) throws ParseException {
        node.childrenAccept(runtime.ev, null);
        Comparable<?> param = runtime.stack.pop();
        return new Comparable<?>[] { param };

    }

    public static Integer weekOfYear(Comparable<?> param, Calendar cal) throws ParseException {
        if (param == null) {
            return null;
        }
        if (param instanceof Timestamp || param instanceof java.sql.Date) {
            java.util.Date ts = (java.util.Date) param;
            cal.setTimeInMillis(ts.getTime());
            return new Integer(cal.get(WEEK_OF_YEAR));
        }
        throw new ParseException(WRONG_TYPE + " weekofyear(" + param.getClass() + ")");
    }

    public Comparable<?> getResult(Comparable<?>... comparables) throws ParseException {
        return weekOfYear(comparables[0], JepRuntime.getCalendar());
    }
}
