package com.whereq.fetcher;

import java.util.Map;

import com.whereq.exception.ApplicationException;
import com.whereq.newsguy.BasePojo;

public interface Fetcher<T extends BasePojo> {
	T fetch(String url, Map<String, String> parameters) throws ApplicationException;
}
