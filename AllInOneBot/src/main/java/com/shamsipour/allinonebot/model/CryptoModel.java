package com.shamsipour.allinonebot.model;

import java.util.Map;

public class CryptoModel {
	private Long timestamp;
	
	private Map<String, Float> rates;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, Float> getRates() {
		return rates;
	}

	public void setRates(Map<String, Float> rates) {
		this.rates = rates;
	}

}
