package org.uam.retoOpenxava.config;


import org.hibernate.resource.jdbc.spi.StatementInspector;



public class SqlCommentStatementInspector implements StatementInspector {

/*    private static final Logger LOGGER = LoggerFactory
            .getLogger(
                    SqlCommentStatementInspector.class
            );

    private static final Pattern SQL_COMMENT_PATTERN = Pattern
            .compile(
                    "\\/\\*.*?\\*\\/\\s*"
            );
*/
    @Override
    public String inspect(String sql) {
        System.out.println("SQL PROVISTO:" + sql);
        return sql;
    }
}