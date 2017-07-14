package com.ngit.common.util.service;

import java.util.List;
import java.util.Map;

import com.ngit.common.util.data.migrator.domain.TableConfigEntity;

public interface LoadSourceDataService {
	public Map<TableConfigEntity, List<Map<String, Object>>> load();
}
