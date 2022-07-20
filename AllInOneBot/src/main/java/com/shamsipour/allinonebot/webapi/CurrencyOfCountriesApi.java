package com.shamsipour.allinonebot.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shamsipour.allinonebot.model.CurrencyOfCountriesModel;

public class CurrencyOfCountriesApi {
	private static final String API_URL = "http://veset.ir/api/Currency";

	private CurrencyOfCountriesApi() {
	}

	public static CurrencyOfCountriesModel getWeatherByCity() throws IOException {
		CurrencyOfCountriesModel result = null;
		final URL url = new URL(API_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();

		if (responseCode != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String strResult = br.readLine();
		conn.disconnect();
		result = new ObjectMapper().readValue(strResult, CurrencyOfCountriesModel.class);
		return result;
	}
}
