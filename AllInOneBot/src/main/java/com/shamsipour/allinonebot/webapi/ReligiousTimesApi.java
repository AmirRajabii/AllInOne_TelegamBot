package com.shamsipour.allinonebot.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shamsipour.allinonebot.model.ReligiousTimesModel;

public class ReligiousTimesApi {
	private static final String API_URL = "https://api.codebazan.ir/owghat/";

	private ReligiousTimesApi() {
	}

	public static ReligiousTimesModel getReligiousTimesModel(String cityName) throws IOException {
		ReligiousTimesModel result = null;
		final URL url = new URL(API_URL.concat("?city=" + cityName));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();

		if (responseCode != HttpURLConnection.HTTP_OK) {
			return null;
//			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String strResult = br.readLine();
		conn.disconnect();
		result = new ObjectMapper().readValue(strResult, ReligiousTimesModel.class);
		return result;
	}

}
