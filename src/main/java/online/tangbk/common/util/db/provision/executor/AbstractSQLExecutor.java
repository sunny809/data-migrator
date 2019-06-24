package online.tangbk.common.util.db.provision.executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;
import online.tangbk.common.util.db.provision.exception.ProvisionRuntimeException;

@Slf4j
public abstract class AbstractSQLExecutor {

	protected Statement stmt;
	protected Connection conn;
	protected String sql;

	public AbstractSQLExecutor(Connection conn, String sql) {
		this.conn = conn;
		this.sql = sql;
	}

	public boolean execute() throws ProvisionRuntimeException {
		boolean result = false;
		try {
			stmt = conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			throw new ProvisionRuntimeException(e);
		}

		return result;
	}
}
