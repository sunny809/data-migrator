package com.ngit.common.util.data.config;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TestDate {

	@Test
	public void test() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.DAY_OF_MONTH, 29);
		System.out.println(cal.getTime().toString());
		cal.add(Calendar.DATE, 90);
		System.out.println(cal.getTime().toString());
	}

}
