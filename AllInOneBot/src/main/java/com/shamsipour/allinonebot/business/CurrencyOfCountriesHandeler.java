package com.shamsipour.allinonebot.business;

import com.shamsipour.allinonebot.model.CurrencyOfCountriesModel;

public class CurrencyOfCountriesHandeler {
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
}
