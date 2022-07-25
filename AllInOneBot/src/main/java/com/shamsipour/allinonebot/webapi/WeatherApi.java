package com.shamsipour.allinonebot.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shamsipour.allinonebot.model.WeatherModelByCity;

public class WeatherApi {
	private static final String APP_ID = "baff0bf20186f20b88fb78ad9df15830";
	private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

	private WeatherApi() {
	}

	public static WeatherModelByCity getWeatherByCity(String cityName) throws IOException {
		WeatherModelByCity result = null;
		final URL url = new URL(API_URL.concat("?q=" + cityName + "&appid=" + APP_ID + "&units=metric "));
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
		result = new ObjectMapper().readValue(strResult, WeatherModelByCity.class);
		return result;
	}

	// Model Nadare Hanoz
	public static WeatherModelByCity getWeatherByLocation(float lat, float lon) throws IOException {
		WeatherModelByCity result = null;
		final URL url = new URL(API_URL.concat(
				"?lat=" + String.valueOf(lat) + "?lon=" + String.valueOf(lon) + "&appid=" + APP_ID + "&units=metric "));
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
		result = new ObjectMapper().readValue(strResult, WeatherModelByCity.class);
		return result;
	}
}