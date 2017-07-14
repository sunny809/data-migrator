package com.ngit.common.util.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngit.common.util.data.migrator.domain.TableConfigEntity;
import com.ngit.common.util.freemarker.FreeMarkerUtil;

@Service
public class OutputService {
	@Autowired
	FreeMarkerUtil freeMarkerUtil;

	public void process(Map<TableConfigEntity, List<Map<String, Object>>> inputDataMap) {
		Set<TableConfigEntity> keySet = inputDataMap.keySet();

		for (Iterator<TableConfigEntity> it = keySet.iterator(); it.hasNext();) {
			TableConfigEntity entity = it.next();
			List<Map<String, Object>> currentDataMap = inputDataMap.get(entity);
			String templateFileName = entity.getTemplateFileName();
			String srcTableName = entity.getSrcTableName();
			String outputFileName = entity.getDestTableName() + ".sql";
			freeMarkerUtil.fprint(templateFileName, convert(currentDataMap), outputFileName);
		}
	}

	private Map convert(List<Map<String, Object>> dataList) {
		Map<String, List<Map<String, Object>>> convertResult = new HashMap();
		convertResult.put("root", dataList);
		// System.out.println(dataList.toString());
		return convertResult;
	}
}
