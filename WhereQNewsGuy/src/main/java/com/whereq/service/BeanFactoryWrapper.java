package com.whereq.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whereq.fetcher.Fetcher;
import com.whereq.newsguy.gas.pojo.GasPrice;
import com.whereq.newsguy.gas.service.GasPriceManager;

public class BeanFactoryWrapper {
	private static BeanFactory ctx = null;

	public final static BeanFactory getCtx() {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext(new String[] {
					"classpath*:/**/whereq-context*.xml",
					"classpath*:/**/applicationContext*.xml",
					"classpath*:META-INF/applicationContext*.xml" });
		}
		return ctx;
	}

	public final static Object getBean(String name) {
		return getCtx().getBean(name);
	}

	public static Properties loadProperties(String filename) throws IOException {
		Properties p = new Properties();
		InputStream stream = System.class.getResourceAsStream("/" + filename);
		if (stream != null) {
			try {
				p.load(stream);
			} finally {
				if (stream != null)
					stream.close();
			}
		}
		return p;
	}

	public static GasPriceManager getGasPriceManager() {
		return (GasPriceManager) getBean("gasPriceManager");
	}

	public static Fetcher<GasPrice> getTomorrowGasPriceFetcher() {
		return (Fetcher<GasPrice>) getBean("tomorrowGasPrice");
	}

}
