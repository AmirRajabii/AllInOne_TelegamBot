package com.shamsipour.allinonebot.model;

import java.util.List;

public class BoursModel {
	public static class Result {
		private String Update;
		private String nerkh_feli;
		private String balatarin_gheymat;
		private String paintarin_gheymat;
		private String navesan;
		private String darsad_navesan;
		private String nerkh_bazgoshaie_bazar;
		private String zaman_update_nerkh;
		private String nerkh_diruz;
		private String darsad_taghir_nesbat_be_diruz;
		private String mizan_taghir_nesbatbe_diruz;

		public String getUpdate() {
			return Update;
		}

		public void setUpdate(String update) {
			Update = update;
		}

		public String getNerkh_feli() {
			return nerkh_feli;
		}

		public void setNerkh_feli(String nerkh_feli) {
			this.nerkh_feli = nerkh_feli;
		}

		public String getBalatarin_gheymat() {
			return balatarin_gheymat;
		}

		public void setBalatarin_gheymat(String balatarin_gheymat) {
			this.balatarin_gheymat = balatarin_gheymat;
		}

		public String getPaintarin_gheymat() {
			return paintarin_gheymat;
		}

		public void setPaintarin_gheymat(String paintarin_gheymat) {
			this.paintarin_gheymat = paintarin_gheymat;
		}

		public String getNavesan() {
			return navesan;
		}

		public void setNavesan(String navesan) {
			this.navesan = navesan;
		}

		public String getDarsad_navesan() {
			return darsad_navesan;
		}

		public void setDarsad_navesan(String darsad_navesan) {
			this.darsad_navesan = darsad_navesan;
		}

		public String getNerkh_bazgoshaie_bazar() {
			return nerkh_bazgoshaie_bazar;
		}

		public void setNerkh_bazgoshaie_bazar(String nerkh_bazgoshaie_bazar) {
			this.nerkh_bazgoshaie_bazar = nerkh_bazgoshaie_bazar;
		}

		public String getZaman_update_nerkh() {
			return zaman_update_nerkh;
		}

		public void setZaman_update_nerkh(String zaman_update_nerkh) {
			this.zaman_update_nerkh = zaman_update_nerkh;
		}

		public String getNerkh_diruz() {
			return nerkh_diruz;
		}

		public void setNerkh_diruz(String nerkh_diruz) {
			this.nerkh_diruz = nerkh_diruz;
		}

		public String getDarsad_taghir_nesbat_be_diruz() {
			return darsad_taghir_nesbat_be_diruz;
		}

		public void setDarsad_taghir_nesbat_be_diruz(String darsad_taghir_nesbat_be_diruz) {
			this.darsad_taghir_nesbat_be_diruz = darsad_taghir_nesbat_be_diruz;
		}

		public String getMizan_taghir_nesbatbe_diruz() {
			return mizan_taghir_nesbatbe_diruz;
		}

		public void setMizan_taghir_nesbatbe_diruz(String mizan_taghir_nesbatbe_diruz) {
			this.mizan_taghir_nesbatbe_diruz = mizan_taghir_nesbatbe_diruz;
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
