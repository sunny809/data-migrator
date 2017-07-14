package com.ngit.common.util.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ngit.common.util.config.TableConfigLoader;
import com.ngit.common.util.data.migrator.domain.TableConfigEntity;

@Service
public class SourceDataServiceImpl implements LoadSourceDataService {

	@Autowired
	TableConfigLoader configLoader;

	@Autowired
	JdbcTemplate sqlServerJdbcTemplate;

	@Override
	public Map<TableConfigEntity, List<Map<String, Object>>> load() {

		configLoader.load();
		List<TableConfigEntity> list = configLoader.getConfigList();

		Map<TableConfigEntity, List<Map<String, Object>>> totalResultMap = new HashMap<>();

		for (Iterator<TableConfigEntity> it = list.iterator(); it.hasNext();) {
			TableConfigEntity entity = it.next();
			List<Map<String, Object>> resultList = loadSrcData(entity);
			// System.out.println(resultList);
			totalResultMap.put(entity, resultList);
		}

		return totalResultMap;
	}

	private List<Map<String, Object>> loadSrcData(TableConfigEntity entity) {
		String srcTableName = entity.getSrcTableName();
		String sql = "SELECT * FROM " + srcTableName;
		return sqlServerJdbcTemplate.queryForList(sql);
	}

}
