package online.tangbk.common.util.db.provision.engine.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;
import online.tangbk.common.util.db.provision.config.Configuration;
import online.tangbk.common.util.db.provision.exception.ProvisionRuntimeException;

@Slf4j
public abstract class TaskEngine {

	protected LinkedList<Task> upgradeTaskList = new LinkedList<>();
	protected LinkedList<Task> downgradeTaskList = new LinkedList<>();

	protected Task currentTask;

	protected Connection connection;

	TaskEngine() {

	}

	protected boolean checkHistoryTableExists() throws ProvisionRuntimeException {
		String checkSQL = "SELECT table_name FROM information_schema.TABLES WHERE table_name ='provision_history'";
		try {
			Statement checkTableStmt = connection.createStatement();
			checkTableStmt.executeQuery(checkSQL);
		} catch (SQLException e) {
			log.error("check table exists error {}", e);
			throw new ProvisionRuntimeException(e);
		}
		
		return false;
	}

	protected Status getCurrentEngineStatus() {
		return currentTask.status;
	}

	protected Task getCurrentTask() {
		return currentTask;
	}

	private static Connection getConnection(Configuration config) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		try {
			Class.forName(config.getDatabaseDriverClassName());
			conn = DriverManager.getConnection(config.getDatabaseUrl(), config.toProperties());
		} catch (ClassNotFoundException | SQLException e) {

		}

		return conn;

	}

}
