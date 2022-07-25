package com.shamsipour.allinonebot.model;

public class DateModel {

	public static class Dates {
		private String georgianDate;
		private String persianDate;
		private String hijriDate;

		public String getGeorgianDate() {
			return georgianDate;
		}

		public void setGeorgianDate(String georgianDate) {
			this.georgianDate = georgianDate;
		}

		public String getPersianDate() {
			return persianDate;
		}

		public void setPersianDate(String persianDate) {
			this.persianDate = persianDate;
		}

		public String getHijriDate() {
			return hijriDate;
		}

		public void setHijriDate(String hijriDate) {
			this.hijriDate = hijriDate;
		}

	}

	private Dates dates;

	public Dates getDates() {
		return dates;
	}

	public void setDates(Dates dates) {
		this.dates = dates;
	}

}
