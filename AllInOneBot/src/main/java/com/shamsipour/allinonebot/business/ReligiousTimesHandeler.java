package com.shamsipour.allinonebot.business;

import com.shamsipour.allinonebot.model.ReligiousTimesModel;

public class ReligiousTimesHandeler {
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
}

