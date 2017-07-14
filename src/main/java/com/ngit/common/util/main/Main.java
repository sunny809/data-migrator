package com.ngit.common.util.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ngit.common.util.data.migrator.domain.TableConfigEntity;
import com.ngit.common.util.service.OutputService;
import com.ngit.common.util.service.SourceDataServiceImpl;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.proc();
	}

	private void proc() {

		String paths[] = { "applicationContext.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(paths);
		BeanFactory factory = (BeanFactory) context;
		SourceDataServiceImpl sourceDataServiceImpl = (SourceDataServiceImpl) factory.getBean("sourceDataServiceImpl");
		Map<TableConfigEntity, List<Map<String, Object>>> dataMap = sourceDataServiceImpl.load();
		OutputService outputService = (OutputService) factory.getBean("outputService");
		outputService.process(dataMap);

	}

}
