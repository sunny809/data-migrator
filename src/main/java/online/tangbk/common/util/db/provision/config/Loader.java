package online.tangbk.common.util.db.provision.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import online.tangbk.common.util.db.provision.model.TaskConfig;

public interface Loader {

	public List<TaskConfig> load(String inputJson);

	public List<TaskConfig> loadByInputFileFil(String inputFileName) throws IOException;

	public List<TaskConfig> load(InputStream is) throws IOException;

}
