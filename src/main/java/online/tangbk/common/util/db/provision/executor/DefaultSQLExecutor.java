package online.tangbk.common.util.db.provision.executor;

import java.sql.Connection;

public class DefaultSQLExecutor extends AbstractSQLExecutor {

	public DefaultSQLExecutor(Connection conn, String sql) {
		super(conn, sql);
	}

}
