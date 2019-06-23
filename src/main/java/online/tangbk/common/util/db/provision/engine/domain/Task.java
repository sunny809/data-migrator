package online.tangbk.common.util.db.provision.engine.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Task {

	protected Status status;

	protected String executeSql;

	protected Connection connection;

	public Task(Connection conn, String sql) {
		status = Status.INIT;
		connection = conn;
	}

	void execute() throws SQLException {

		try {
			status = Status.PROCESSING;
			Statement stmt = connection.createStatement();
			stmt.execute(executeSql);
		} catch (SQLException e) {
			log.error("execute SQL {} error {}", executeSql, e);
			status = Status.FAIL;
			throw e;
		}
		status = Status.PROCESSED;
	}

}
