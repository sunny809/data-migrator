package online.tangbk.common.util.db.provision.config;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;
import online.tangbk.common.util.db.provision.model.TaskConfig;

@Slf4j
public class TaskConfigLoader implements Loader {

	Logger logger = LoggerFactory.getLogger(TaskConfigLoader.class);

	@Override
	public List<TaskConfig> load(String input) {
		log.debug("input:[{}]", input);
		Gson gson = new Gson();
		Type configListType = new TypeToken<List<TaskConfig>>() {
		}.getType();
		return gson.fromJson(input, configListType);
	}

	@Override
	public List<TaskConfig> loadByInputFileFil(String inputFileName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskConfig> load(InputStream is) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
