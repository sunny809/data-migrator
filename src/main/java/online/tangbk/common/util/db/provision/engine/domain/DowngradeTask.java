package online.tangbk.common.util.db.provision.engine.domain;

import java.sql.Connection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DowngradeTask extends Task {
	public DowngradeTask(Connection conn, String sql) {
		super(conn, sql);
	}

}
