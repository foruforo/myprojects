/**
 * 
 */
package com.the13star.configurations;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

/**
 * @author Programmers
 *
 */

/**
 * The DefaultExecuteListener class is the public default implementation of the
 * ExecuteListener interface which provides listener methods for different life
 * cycle events of a single query execution.
 */
public class JOOQToSpringExceptionTransformer extends DefaultExecuteListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5749466061513426635L;

	/**
	 * This method is called if an exception is thrown at any moment of the
	 * execution life cycle.
	 */
	@Override
	public void exception(ExecuteContext ctx) {
		SQLDialect dialect = ctx.configuration().dialect();
		SQLExceptionTranslator sqlExceptionTranslator = null;
		if(dialect != null){
			sqlExceptionTranslator = new SQLErrorCodeSQLExceptionTranslator(dialect.getName());
		}else{
			sqlExceptionTranslator = new SQLStateSQLExceptionTranslator();
		}
		
		ctx.exception(sqlExceptionTranslator.translate("JOOQ", ctx.sql(), ctx.sqlException()));
	}
}
