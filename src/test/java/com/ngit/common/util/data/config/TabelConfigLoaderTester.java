package com.ngit.common.util.data.config;

import org.junit.Test;

import online.tangbk.common.util.db.provision.config.TableConfigLoader;

public class TabelConfigLoaderTester {

	@Test
	public void test() {

		TableConfigLoader test = new TableConfigLoader();

		test.load();
		test.getConfigList();
	}

}
