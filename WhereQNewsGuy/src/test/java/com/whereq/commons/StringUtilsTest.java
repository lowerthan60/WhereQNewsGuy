package com.whereq.commons;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void test() {
		String str = "\r\n\t\t\t\t\t\t\t\t\t\t";
		str = null;
		System.out.println(StringUtils.isEmpty(str));
//		System.out.println(StringUtils.isEmpty(str.trim()));
		
		System.out.println(StringUtils.trim(str));
		
	}

}
