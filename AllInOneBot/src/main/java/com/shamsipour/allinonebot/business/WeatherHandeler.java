package com.shamsipour.allinonebot.business;

import com.shamsipour.allinonebot.model.WeatherModelByCity;

public class WeatherHandeler {
	public static String callWeatherByBot(WeatherModelByCity modelByCity) {
		if (modelByCity == null) {
			return "❌ شهر یافت نشد ❌";
		}
		String icon = modelByCity.getWeather().get(0).getIcon();
		String iconEmoji = "";
		if (icon.equalsIgnoreCase("01d")) {
			iconEmoji = "☀️";
		} else if (icon.equalsIgnoreCase("01n")) {
			iconEmoji = "🌙";
		} else if (icon.equalsIgnoreCase("02d") || icon.equalsIgnoreCase("02n")) {
			iconEmoji = "⛅️️";
		} else if (icon.equalsIgnoreCase("03d") || icon.equalsIgnoreCase("03n")) {
			iconEmoji = "☁️";
		} else if (icon.equalsIgnoreCase("04d") || icon.equalsIgnoreCase("04n")) {
			iconEmoji = "☁️";
		} else if (icon.equalsIgnoreCase("09d") || icon.equalsIgnoreCase("09n")) {
			iconEmoji = "🌧";
		} else if (icon.equalsIgnoreCase("10d") || icon.equalsIgnoreCase("10n")) {
			iconEmoji = "🌦";
		} else if (icon.equalsIgnoreCase("11d") || icon.equalsIgnoreCase("11n")) {
			iconEmoji = "🌩";
		} else if (icon.equalsIgnoreCase("13d") || icon.equalsIgnoreCase("13n")) {
			iconEmoji = "❄️";
		} else if (icon.equalsIgnoreCase("50d") || icon.equalsIgnoreCase("50n")) {
			iconEmoji = "🌪";
		}
		return "✨ آب و هوای امروز شهر " + modelByCity.getName() + " ✨\n" + "\n" + " دمای فعلی :  "
				+ modelByCity.getMain().getTemp() + " 🌡 \n" + "\n" + "وضعیت هوا :  " + iconEmoji + " \n" + "\n"
				+ " توضیحات : " + modelByCity.getWeather().get(0).getDescription() + " 📃\n";
	}
}
