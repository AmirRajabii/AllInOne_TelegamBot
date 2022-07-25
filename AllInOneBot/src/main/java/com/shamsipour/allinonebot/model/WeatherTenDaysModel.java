package com.shamsipour.allinonebot.model;

public class WeatherTenDaysModel {

	public static class City {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static class List {
		private Long dt;
		private Temp temp;

		private java.util.List<Weather> weather;

		public Long getDt() {
			return dt;
		}

		public void setDt(Long dt) {
			this.dt = dt;
		}

		public Temp getTemp() {
			return temp;
		}

		public void setTemp(Temp temp) {
			this.temp = temp;
		}

		public java.util.List<Weather> getWeather() {
			return weather;
		}

		public void setWeather(java.util.List<Weather> weather) {
			this.weather = weather;
		}

	}

	public static class Temp {
		private float min;
		private float max;

		public float getMin() {
			return min;
		}

		public void setMin(float min) {
			this.min = min;
		}

		public float getMax() {
			return max;
		}

		public void setMax(float max) {
			this.max = max;
		}

	}

	public static class Weather {
		private String icon;

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}
	}

	private City city;

	private java.util.List<List> list;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public java.util.List<List> getList() {
		return list;
	}

	public void setList(java.util.List<List> list) {
		this.list = list;
	}

}
