package com.ngit.common.util.data.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ngit.common.util.config.TableConfigLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class TabelConfigLoaderTester {

	@Test
	public void test() {

		TableConfigLoader test = new TableConfigLoader();

		test.load();
		test.getConfigList();
	}

}
