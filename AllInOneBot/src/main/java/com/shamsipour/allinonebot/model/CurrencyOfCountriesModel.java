package com.shamsipour.allinonebot.model;

import java.util.List;

public class CurrencyOfCountriesModel {
	public static class Currencies {
		private int id;
		private String name;
		private int value;
		private String icon;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
	}

	private List<Currencies> currencies;

	public List<Currencies> getCurrencies() {
		return currencies;
	}
	public void setCurrency(List<Currencies> currencies) {
		this.currencies = currencies;
	}
}
