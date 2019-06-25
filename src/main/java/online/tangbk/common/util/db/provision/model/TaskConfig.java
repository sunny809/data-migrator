package online.tangbk.common.util.db.provision.model;

import java.util.Date;

import lombok.Data;

@Data
public class TaskConfig {
	private Date date;
	private String executeSql;
	private String rollbackSql;
}
