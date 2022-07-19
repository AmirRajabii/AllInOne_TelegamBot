package com.shamsipour.allinonebot.model;

import java.util.List;

public class WeatherModelByCity {
	// Start inner class
	public static class Coord {
		private float lon;
		private float lat;

		public float getLon() {
			return lon;
		}

		public void setLon(float lon) {
			this.lon = lon;
		}

		public float getLat() {
			return lat;
		}

		public void setLat(float lat) {
			this.lat = lat;
		}
	}

	public static class Weather {
		private long id;
		private String main;
		private String description;
		private String icon;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getMain() {
			return main;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}
	}

	public static class Main {
		private float temp;
		private float feels_like;
		private float temp_min;
		private float temp_max;
		private int pressure;
		private int humidity;

		public float getTemp() {
			return temp;
		}

		public void setTemp(float temp) {
			this.temp = temp;
		}

		public float getFeels_like() {
			return feels_like;
		}

		public void setFeels_like(float feels_like) {
			this.feels_like = feels_like;
		}

		public float getTemp_min() {
			return temp_min;
		}

		public void setTemp_min(float temp_min) {
			this.temp_min = temp_min;
		}

		public float getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(float temp_max) {
			this.temp_max = temp_max;
		}

		public int getPressure() {
			return pressure;
		}

		public void setPressure(int pressure) {
			this.pressure = pressure;
		}

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

	}

	public static class Wind {
		private float speed;
		private int deg;

		public float getSpeed() {
			return speed;
		}

		public void setSpeed(float speed) {
			this.speed = speed;
		}

		public int getDeg() {
			return deg;
		}

		public void setDeg(int deg) {
			this.deg = deg;
		}
	}

	public static class Clouds {
		private int all;

		public int getAll() {
			return all;
		}

		public void setAll(int all) {
			this.all = all;
		}

	}

	public static class Sys {
		private int type;
		private int id;
		private String country;
		private long sunrise;
		private long sunset;

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public long getSunrise() {
			return sunrise;
		}

		public void setSunrise(long sunrise) {
			this.sunrise = sunrise;
		}

		public long getSunset() {
			return sunset;
		}

		public void setSunset(long sunset) {
			this.sunset = sunset;
		}

	}
	// End of inner class

	// Start dec fields
	private Coord coord;
	private List<Weather> weather;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private Sys sys;
	private int visibility;
	private String base;
	private long dt;
	private long timezone;
	private long id;
	private String name;
	private int cod;

	// End dec fields
	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public long getTimezone() {
		return timezone;
	}

	public void setTimezone(long timezone) {
		this.timezone = timezone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

}