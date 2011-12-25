package com.whereq.fetcher.newsguy.gas;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.whereq.component.httpclient.HttpClientHelper;
import com.whereq.exception.ApplicationException;
import com.whereq.fetcher.Fetcher;
import com.whereq.newsguy.gas.Trend;
import com.whereq.newsguy.gas.pojo.GasPrice;

public class TomorrowGasPrice implements Fetcher<GasPrice> {
	
	public final static String URL = "http://tomorrowsgaspricetoday.com/gas-prices.html";
	final static String PREDICATION_GASONLINE = "<div class=\"predication_gasoline_litre_pro_01\" style=\"font-size:45px\">";
	final static String PREDICATION_GASONLINE_DELTA = "<div class=\"predication_gasoline_litre_pro_01\">";
	final static String PREDICATION_GASONLINE_LITRE_ARROW = "<div class=\"predication_gasoline_litre_arrow\" style=\"padding:2px\">";
	final static String ARROW_IMAGE_SRC = "src=\"";
	
	final static String UP_SM = "gas_arrow_up.gif";
	final static String DROP_SM = "";
	final static String NO_CHANGE_SM = "no-change-sm.gif";
	
	
	
	@Override
	public GasPrice fetch(String url, Map<String, String> parameters) throws ApplicationException{
		String content = null;		
		try {
			content = HttpClientHelper.post(url, parameters);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		
		Date today = new Date();
		GasPrice gasPrice = new GasPrice();
		gasPrice.setDate(today);
		int begin = 0;
		int end = 0;
		
		//get price
		begin = content.indexOf(PREDICATION_GASONLINE) + PREDICATION_GASONLINE.length();
		end = content.indexOf("</div>", begin);
		String priceStr = content.substring(begin, end);
		
		if(!StringUtils.isEmpty(priceStr)){
			gasPrice.setTomorrowPrice(Double.parseDouble(priceStr.trim()));
		}else{
			gasPrice.setTomorrowPrice(0.0);
		}
		
		//get delta value
		begin = content.indexOf(PREDICATION_GASONLINE_DELTA) + PREDICATION_GASONLINE_DELTA.length();
		end = content.indexOf("</div>", begin);
		String deltaStr = StringUtils.trim(content.substring(begin, end));
		if (!StringUtils.isEmpty(deltaStr)){
			gasPrice.setDelta(Double.parseDouble(deltaStr.trim()));
		}else{
			gasPrice.setDelta(0.0);
		}
		
		//get trend
		begin = content.indexOf(PREDICATION_GASONLINE_LITRE_ARROW);
		begin = content.indexOf(ARROW_IMAGE_SRC, begin) + ARROW_IMAGE_SRC.length();
		begin = content.indexOf("/", begin) + 1;
		end = content.indexOf("\"", begin);
		String trend = content.substring(begin, end);
		if(trend.equals(NO_CHANGE_SM)){
			gasPrice.setTrend(Trend.CHANGELESS);
		}else if(trend.equals(UP_SM)){
			gasPrice.setTrend(Trend.UP);
		}else if(trend.equals(DROP_SM)){
			gasPrice.setTrend(Trend.DROP);
		}
		
		return gasPrice;
	}

}
