package online.tangbk.common.util.db.provision.config;

import java.util.Date;

import lombok.Data;

@Data
public class TaskConfiguration {

	private int step;

	private Date date;

	private String upgradeSql;

	private String downgradeSql;

}