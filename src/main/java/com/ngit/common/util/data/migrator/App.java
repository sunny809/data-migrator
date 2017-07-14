package com.ngit.common.util.data.migrator;

import com.ngit.common.util.config.TableConfigLoader;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		TableConfigLoader test = new TableConfigLoader();
		test.load();
		test.getConfigList();
	}
}
