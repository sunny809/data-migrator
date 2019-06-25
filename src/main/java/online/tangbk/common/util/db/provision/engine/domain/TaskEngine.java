package online.tangbk.common.util.db.provision.engine.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import lombok.extern.slf4j.Slf4j;
import online.tangbk.common.util.db.provision.config.Configuration;

@Slf4j
public abstract class TaskEngine {

	protected LinkedList<Task> upgradeTaskList = new LinkedList<>();
	protected LinkedList<Task> downgradeTaskList = new LinkedList<>();

	protected Task currentTask;

	protected Connection connection;

	TaskEngine() {

	}

	protected boolean checkHistoryTableExists() {
		return false;
	}

	protected Status getCurrentEngineStatus() {
		return currentTask.status;
	}

	protected Task getCurrentTask() {
		return currentTask;
	}

	protected static Connection getConnection(Configuration config) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		try {
			Class.forName(config.getDatabaseDriverClassName());
			conn = DriverManager.getConnection(config.getDatabaseUrl(), config.toProperties());
		} catch (ClassNotFoundException | SQLException e) {

		}

		return conn;

	}

}
