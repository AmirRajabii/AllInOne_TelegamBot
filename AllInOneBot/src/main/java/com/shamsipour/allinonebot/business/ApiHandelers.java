package com.shamsipour.allinonebot.business;

import java.util.Date;

import com.shamsipour.allinonebot.model.BoursModel;
import com.shamsipour.allinonebot.model.CryptoModel;
import com.shamsipour.allinonebot.model.CurrencyOfCountriesModel;
import com.shamsipour.allinonebot.model.DateModel;
import com.shamsipour.allinonebot.model.GoldAndCoinsModel;
import com.shamsipour.allinonebot.model.ReligiousTimesModel;
import com.shamsipour.allinonebot.model.WeatherCurrentByCityModel;
import com.shamsipour.allinonebot.model.WeatherTenDaysModel;

public class ApiHandelers {

	// *********** Bours ************
	public static String callBoursByBot(BoursModel boursModel) {
		return "🗓 آپدیت روز : " + boursModel.getResult().get(0).getUpdate() + " 🗓\n" + "\n" + "📊 شاخص فعلی : "
				+ boursModel.getResult().get(0).getNerkh_feli() + " 📊\n" + "\n" + "📈 بالاترین نرخ شاخص : "
				+ boursModel.getResult().get(0).getBalatarin_gheymat() + " 📈\n" + "\n" + "📉 پایین ترین نرخ شاخص : "
				+ boursModel.getResult().get(0).getPaintarin_gheymat() + " 📉\n" + "\n" + "🗓 شاخص روز قبل : "
				+ boursModel.getResult().get(0).getNerkh_diruz() + " 🗓";
	}

	// *********** Country Currency ************
	public static String callCurrencyOfCounriesByBot(CurrencyOfCountriesModel currencyOfCounriesModel) {

		return "💰 قیمت ارزهای کشورها 💰\n" + "\n" + "🇱🇷 دلار آمریکا : "
				+ currencyOfCounriesModel.getCurrencies().get(0).getValue() + " ریال " + "🇺🇸\n" + "\n"
				+ "🇪🇺 یورو اروپا : " + currencyOfCounriesModel.getCurrencies().get(1).getValue() + " ریال " + "🇪🇺\n"
				+ "\n" + "🇨🇳 یوآن : " + currencyOfCounriesModel.getCurrencies().get(2).getValue() + " ریال "
				+ "🇨🇳 \n" + "\n" + "🇦🇪 درهم امارات : " + currencyOfCounriesModel.getCurrencies().get(3).getValue()
				+ " ریال " + "🇦🇪 \n" + "\n" + "🇯🇵 ین : " + currencyOfCounriesModel.getCurrencies().get(4).getValue()
				+ " ریال " + "🇯🇵 \n" + "\n" + "🇨🇭 فرانک سوئیس : "
				+ currencyOfCounriesModel.getCurrencies().get(5).getValue() + " ریال " + " 🇨🇭 \n" + "\n"
				+ "🇷🇺 روبل : " + currencyOfCounriesModel.getCurrencies().get(6).getValue() + " ریال " + " 🇷🇺 \n"
				+ "\n" + "🇸🇪 کرون سوئد :" + currencyOfCounriesModel.getCurrencies().get(7).getValue() + " ریال "
				+ " 🇸🇪 \n" + "\n" + "🏴󠁧󠁢󠁥󠁮󠁧󠁿 پوند انگلیس : "
				+ currencyOfCounriesModel.getCurrencies().get(8).getValue() + " ریال " + " 🏴󠁧󠁢󠁥󠁮󠁧󠁿 \n" + "\n"
				+ "🇦🇷 پزو آرژانتین : " + currencyOfCounriesModel.getCurrencies().get(9).getValue() + " ریال "
				+ " 🇦🇷";
	}

	// *********** Oghat Sharae ************
	public static String callReligiousTimesByBot(ReligiousTimesModel religiousTimesModel) {
		if (religiousTimesModel == null) {
			return "❌ شهر یافت نشد ❌";
		}

		return "✨ اوقات شرعی امروز شهر " + religiousTimesModel.getResult().get(0).getShahr() + "✨\n" + "\n"
				+ "🗓 تاریخ  :  " + religiousTimesModel.getResult().get(0).getTarikh() + "\n" + "\n" + "🕋 اذان صبح : "
				+ religiousTimesModel.getResult().get(0).getAzansobh() + " \n" + "\n" + "🌅 طلوع آفتاب : "
				+ religiousTimesModel.getResult().get(0).getToloaftab() + " \n" + "\n" + "🕋 اذان ظهر : "
				+ religiousTimesModel.getResult().get(0).getAzanzohr() + " \n" + "\n" + "🌃 غروب آفتاب : "
				+ religiousTimesModel.getResult().get(0).getGhorubaftab() + " \n" + "\n" + "🕋 اذان مغرب : "
				+ religiousTimesModel.getResult().get(0).getAzanmaghreb() + " \n" + "\n" + "🌙 نیمه شب : "
				+ religiousTimesModel.getResult().get(0).getNimeshab();
	}

	// *********** Weather Current ************
	public static String callWeatherByBot(WeatherCurrentByCityModel modelByCity) {
		if (modelByCity == null) {
			return "❌ شهر یافت نشد ❌";
		}
		String icon = modelByCity.getWeather().get(0).getIcon();
		String iconEmoji = getIcon(icon);
		return "✨ آب و هوای امروز شهر " + modelByCity.getName() + " ✨\n" + "\n" + " دمای فعلی :  "
				+ modelByCity.getMain().getTemp() + " 🌡 \n" + "\n" + "وضعیت هوا :  " + iconEmoji + " \n" + "\n"
				+ " توضیحات : " + modelByCity.getWeather().get(0).getDescription() + " 📃\n";
	}

	// *********** Gold And Coins ************
	public static String callGoldAndCoinsByBot(GoldAndCoinsModel goldAndCoinsModel) {
		return "✨ قیمت طلا و سکه ✨\n" + "\n" + "1️⃣ سکه امامی : "
				+ goldAndCoinsModel.getGoldAndCoins().get(0).getValue() * 1000 + "ریال" + " \n" + "\n"
				+ "2️⃣ سکه بهار آزادی : " + goldAndCoinsModel.getGoldAndCoins().get(3).getValue() * 1000 + "ریال" + "\n"
				+ "\n" + "3️⃣ نیم سکه : " + goldAndCoinsModel.getGoldAndCoins().get(4).getValue() * 1000 + "ریال"
				+ " \n" + "\n" + "4️⃣ ربع سکه : " + goldAndCoinsModel.getGoldAndCoins().get(5).getValue() * 1000
				+ "ریال" + " \n" + "\n" + "5️⃣ طلای ۱۸ عیار ( گرم ) : "
				+ goldAndCoinsModel.getGoldAndCoins().get(2).getValue() + "ریال" + " \n" + "\n"
				+ "6️⃣ طلای آب شده ( مثقال ) : " + goldAndCoinsModel.getGoldAndCoins().get(1).getValue() * 1000
				+ "ریال";
	}

	// ************** Dates ***************
	public static String callDatesByBot(DateModel dateModel) {

		return "📅 تاریخ امروز 📅\n" + "\n" + " 🔵 شمسی : " + dateModel.getDates().getPersianDate() + " \n" + "\n"
				+ " 🟡 میلادی : " + dateModel.getDates().getGeorgianDate() + "\n" + "\n" + "🟣 قمری : "
				+ dateModel.getDates().getHijriDate();
	}

	// *********** Weather 10 Days ************
	public static String callWeatherTenDaysByBot(WeatherTenDaysModel weatherTenDaysModel) {
		if (weatherTenDaysModel == null) {
			return "❌ شهر یافت نشد ❌";
		}

		return "✨ آب و هوای 10 روز آینده شهر " + weatherTenDaysModel.getCity().getName() + " ✨\n" + "\n" + "1️⃣"
				+ new JalaliConverter(weatherTenDaysModel.getList().get(0).getDt() * 1000).getShamsi() + "\n" + "\n"
				+ "  بیشترین دما :  " + weatherTenDaysModel.getList().get(0).getTemp().getMax() + " 🌡 \n" + "\n"
				+ "  کمترین دما :  " + weatherTenDaysModel.getList().get(0).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(0).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "2️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(1).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(1).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(1).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(1).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "3️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(2).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(2).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(2).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(2).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "4️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(3).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(3).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(3).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(3).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "5️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(4).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(4).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(4).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(4).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "6️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(5).getDt() * 1000).getShamsi()
				+ " \n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(5).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(5).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(5).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "7️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(6).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(6).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(6).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(6).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "8️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(7).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(7).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(7).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(7).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "9️⃣" + new JalaliConverter(weatherTenDaysModel.getList().get(8).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(8).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(8).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(8).getWeather().get(0).getIcon()) + " \n"
				+ "\n" + "🔟" + new JalaliConverter(weatherTenDaysModel.getList().get(9).getDt() * 1000).getShamsi()
				+ "\n" + "\n" + "  بیشترین دما :  " + weatherTenDaysModel.getList().get(9).getTemp().getMax() + " 🌡 \n"
				+ "\n" + "  کمترین دما :  " + weatherTenDaysModel.getList().get(9).getTemp().getMin() + " 🌡 \n" + "\n"
				+ "وضعیت هوا :  " + getIcon(weatherTenDaysModel.getList().get(9).getWeather().get(0).getIcon());
	}
	// *************** Crypto Search *****************

	public static String callCryptoByBot(CryptoModel cryptoModel, String cryptoName) {

		return "📅 " + new Date(cryptoModel.getTimestamp() * 1000) + " 📅\n" + "\n" + "💵 قیمت ارز : "
				+ cryptoModel.getRates().get(cryptoName).toString() + " 💵";
	}

	public static String callTopTenCryptoByBot(CryptoModel cryptoModel) {
		return "📅 " + new Date(cryptoModel.getTimestamp() * 1000) + " 📅\n" + "\n" + "💵 BTC :  "
				+ cryptoModel.getRates().get("BTC").toString() + "$" + " 💵\n" + "\n" + "💵 ETH :  "
				+ cryptoModel.getRates().get("ETH").toString() + "$" + " 💵\n" + "\n" + "💵 USDT :  "
				+ cryptoModel.getRates().get("USDT").toString() + "$" + " 💵\n" + "\n" + "💵 BNB :  "
				+ cryptoModel.getRates().get("BNB").toString() + "$" + " 💵\n" + "\n" + "💵 XRP :  "
				+ cryptoModel.getRates().get("XRP").toString() + "$" + " 💵\n" + "\n" + "💵 ADA :  "
				+ cryptoModel.getRates().get("ADA").toString() + "$" + " 💵\n" + "\n" + "💵 LTC :  "
				+ cryptoModel.getRates().get("LTC").toString() + "$" + " 💵\n" + "\n" + "💵 DOGE :  "
				+ cryptoModel.getRates().get("DOGE").toString() + "$" + " 💵\n" + "\n" + "💵 TRC :  "
				+ cryptoModel.getRates().get("TRC").toString() + "$" + " 💵\n" + "\n" + "💵 TRX :  "
				+ cryptoModel.getRates().get("TRX").toString() + "$" + " 💵";
	}

	// --------------------- Get Weather Icon ---------------------
	private static String getIcon(String icon) {
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
		return iconEmoji;
	}
}
