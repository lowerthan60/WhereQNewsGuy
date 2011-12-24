package com.whereq.component.httpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpClientHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPost() {
		String url = "http://tomorrowsgaspricetoday.com/gas-prices.html";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("cityId", "101");
		
		String content = null;

		try {
			content = HttpClientHelper.post(url, parameters);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(content);

		int begin = 0;
		int end = 0;
		
		String PREDICATION_GASONLINE = "<div class=\"predication_gasoline_litre_pro_01\" style=\"font-size:45px\">";
		
		begin = content.indexOf(PREDICATION_GASONLINE) + PREDICATION_GASONLINE.length();
		end = content.indexOf("</div>", begin);
		
		String todayPriceStr = content.substring(begin, end);
		System.out.println(todayPriceStr.trim());
		System.out.println(Double.parseDouble(todayPriceStr));
		System.out.println(todayPriceStr.length());
	}

}
