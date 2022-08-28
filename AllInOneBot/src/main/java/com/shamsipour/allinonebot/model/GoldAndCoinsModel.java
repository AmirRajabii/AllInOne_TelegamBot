package com.shamsipour.allinonebot.model;

import java.util.List;

public class GoldAndCoinsModel {

	public static class GoldAndCoins {
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
	private List<GoldAndCoins> goldAndCoins;

	public List<GoldAndCoins> getGoldAndCoins() {
		return goldAndCoins;
	}
	public void setCurrency(List<GoldAndCoins> goldAndCoins) {
		this.goldAndCoins = goldAndCoins;
	}

}
