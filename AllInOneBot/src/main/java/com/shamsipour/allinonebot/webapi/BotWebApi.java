package com.shamsipour.allinonebot.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shamsipour.allinonebot.model.BoursModel;
import com.shamsipour.allinonebot.model.CryptoModel;
import com.shamsipour.allinonebot.model.CurrencyOfCountriesModel;
import com.shamsipour.allinonebot.model.DateModel;
import com.shamsipour.allinonebot.model.GoldAndCoinsModel;
import com.shamsipour.allinonebot.model.ReligiousTimesModel;
import com.shamsipour.allinonebot.model.WeatherCurrentByCityModel;
import com.shamsipour.allinonebot.model.WeatherTenDaysModel;

@JsonIgnoreProperties
public class BotWebApi {

	public BotWebApi() {
	}

	// *********** Bours ************
	public static BoursModel getBoursModel() throws IOException {
		final String API_URL = "https://api.codebazan.ir/bours/";
		BoursModel result = null;
		final URL url = new URL(API_URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");

		int responseCode = conn.getResponseCode();

		if (responseCode != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		StringBuffer strResult = new StringBuffer();
		String str = "";
		do {
			strResult.append(str.trim());
			str = br.readLine();
		} while (str != null);
		conn.disconnect();
		result = new ObjectMapper().readValue(strResult.toString().replaceAll("-", "_"), BoursModel.class);
		return result;
	}

	// *********** Country Currency ************
	public static CurrencyOfCountriesModel getWeatherByCity() throws IOException {
		final String API_URL = "http://veset.ir/api/Currency";
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

	// *********** Oghat Sharae ************
	public static ReligiousTimesModel getReligiousTimesModel(String cityName) throws IOException {
		final String API_URL = "http://api.codebazan.ir/owghat/";
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
		StringBuffer strResult = new StringBuffer();
		String str = "";
		do {
			strResult.append(str.trim());
			str = br.readLine();
		} while (str != null);
		conn.disconnect();
		result = new ObjectMapper().readValue(strResult.toString(), ReligiousTimesModel.class);
		return result;
	}

	// *********** Weather Current ************
	public static WeatherCurrentByCityModel getWeatherByCity(String cityName) throws IOException {
		final String APP_ID = "";
		final String API_URL = "http://api.openweathermap.org/data/2.5/weather";
		WeatherCurrentByCityModel result = null;
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
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		result = objectMapper.readValue(strResult, WeatherCurrentByCityModel.class);
		return result;
	}

	// *********** Gold And Coins ************
	public static GoldAndCoinsModel getGoldAndCoins() throws IOException {
		final String API_URL = "http://veset.ir/api/GoldAndCoins/";
		GoldAndCoinsModel result = null;
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
		result = new ObjectMapper().readValue(strResult, GoldAndCoinsModel.class);
		return result;
	}

	// *********** Dates ************
	public static DateModel getDate() throws IOException {
		final String API_URL = "http://veset.ir/api/Time/AllDates/";
		DateModel result = null;
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
		result = new ObjectMapper().readValue(strResult, DateModel.class);
		return result;
	}

	// *********** Weather 10 Days ************
	public static WeatherTenDaysModel getWeatherTenDayds(String cityName) throws IOException {
		final String APP_ID = "";
		final String API_URL = "http://api.openweathermap.org/data/2.5/forecast/daily";
		WeatherTenDaysModel result = null;
		final URL url = new URL(API_URL.concat("?q=" + cityName + "&cnt=10" + "&appid=" + APP_ID + "&units=metric "));
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
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		result = objectMapper.readValue(strResult, WeatherTenDaysModel.class);
		return result;
	}

	// *************** Crypto Search And Top 10 Crypto Price *****************
	public static CryptoModel getCrypto() throws IOException {
		final String key = "";
		final String API_URL = "http://api.coinlayer.com/api/live";
		CryptoModel result = null;
		final URL url = new URL(API_URL.concat("?access_key=" + key));
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
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		result = objectMapper.readValue(strResult, CryptoModel.class);
		return result;
	}
}
