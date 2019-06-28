package online.tangbk.common.util.db.provision.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ngit.common.util.data.migrator.domain.TableConfigEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TableConfigLoader implements ConfigLoader {

	private List<TableConfigEntity> list;

	Logger logger = LoggerFactory.getLogger(TableConfigLoader.class);

	@Override
	public void load(String input) throws IOException {
		log.debug("input:[{}]", input);

		try {
			BufferedReader br = new BufferedReader(bis);
			String jsonString = extractString(br);
			list = JSONObject.parseArray(jsonString, TableConfigEntity.class);
			System.out.println(list.toString());
		} catch (IOException e) {
			log.error("loading SQL task from configuration file error {}", e);

		}

	}

	public String extractString(BufferedReader br) throws IOException {
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	public List<TableConfigEntity> getConfigList() {
		return list;
	}

}
