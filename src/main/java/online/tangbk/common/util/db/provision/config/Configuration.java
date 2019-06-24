package online.tangbk.common.util.db.provision.config;

import java.util.List;
import java.util.Properties;

import lombok.Data;

@Data
public class Configuration {

	private String databaseDriverClassName;
	private String databaseUrl;
	private String password;
	private String username;
	private String provisionFileSourceDirectory;
	private List<TaskConfiguration> taskConfigList;

	public Properties toProperties() {
		Properties prop = new Properties();
		prop.put("user", username);
		prop.put("password", password);
		return prop;
	}

}
