package com.shamsipour.allinonebot.model;

import java.util.List;

public class ReligiousTimesModel {
	public static class Result {
		private String shahr;
		private String tarikh;
		private String azansobh;
		private String toloaftab;
		private String azanzohr;
		private String ghorubaftab;
		private String azanmaghreb;
		private String nimeshab;

		public String getShahr() {
			return shahr;
		}

		public void setShahr(String shahr) {
			this.shahr = shahr;
		}

		public String getTarikh() {
			return tarikh;
		}

		public void setTarikh(String tarikh) {
			this.tarikh = tarikh;
		}

		public String getAzansobh() {
			return azansobh;
		}

		public void setAzansobh(String azansobh) {
			this.azansobh = azansobh;
		}

		public String getToloaftab() {
			return toloaftab;
		}

		public void setToloaftab(String toloaftab) {
			this.toloaftab = toloaftab;
		}

		public String getAzanzohr() {
			return azanzohr;
		}

		public void setAzanzohr(String azanzohr) {
			this.azanzohr = azanzohr;
		}

		public String getGhorubaftab() {
			return ghorubaftab;
		}

		public void setGhorubaftab(String ghorubaftab) {
			this.ghorubaftab = ghorubaftab;
		}

		public String getAzanmaghreb() {
			return azanmaghreb;
		}

		public void setAzanmaghreb(String azanmaghreb) {
			this.azanmaghreb = azanmaghreb;
		}

		public String getNimeshab() {
			return nimeshab;
		}

		public void setNimeshab(String nimeshab) {
			this.nimeshab = nimeshab;
		}

	}

	public boolean Ok;
	public List<Result> Result;

	public boolean isOk() {
		return Ok;
	}

	public void setOk(boolean ok) {
		Ok = ok;
	}

	public List<Result> getResult() {
		return Result;
	}

	public void setResult(List<Result> result) {
		this.Result = result;
	}

}
