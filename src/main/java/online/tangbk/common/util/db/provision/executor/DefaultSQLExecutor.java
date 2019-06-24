package online.tangbk.common.util.db.provision.executor;

import java.sql.Connection;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;
import online.tangbk.common.util.db.provision.exception.ProvisionRuntimeException;

@Slf4j
public class DefaultSQLExecutor extends AbstractSQLExecutor {

	public DefaultSQLExecutor(Connection conn, String sql) {
		super(conn, sql);
	}

	@Override
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
