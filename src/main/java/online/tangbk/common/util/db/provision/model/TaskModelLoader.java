package online.tangbk.common.util.db.provision.model;

import java.io.InputStream;
import java.util.List;

public interface TaskModelLoader {

	List<TaskConfig> load(String input);

	List<TaskConfig> load(InputStream is);

}
