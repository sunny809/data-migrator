package com.ngit.common.util.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.ngit.common.util.data.migrator.domain.TableConfigEntity;

@Component
public class TableConfigLoader implements ConfigLoader {

	private List<TableConfigEntity> list;

	Logger logger = LoggerFactory.getLogger(TableConfigLoader.class);

	@Override
	public void load() {
		// System.out.println(ClassLoader.getSystemResource(""));
		// System.out.println(ClassLoader.getSystemResource("migration_config.json"));

		InputStreamReader bis = new InputStreamReader(ClassLoader.getSystemResourceAsStream("migration_config.json"));

		try {
			BufferedReader br = new BufferedReader(bis);
			String jsonString = extractString(br);
			list = JSONObject.parseArray(jsonString, TableConfigEntity.class);
			System.out.println(list.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
