package com.shamsipour.allinonebot.business;

import java.io.File;
import java.io.IOException;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.shamsipour.allinonebot.model.BotInfoModel;
import com.shamsipour.allinonebot.model.Keyboards;
import com.shamsipour.allinonebot.webapi.BotWebApi;

public class BotHandeler extends TelegramLongPollingBot {
	BotInfoModel botInfoModel = new BotInfoModel();
	Update update;

	public void onUpdateReceived(Update update) {
		this.update = update;
		if (update.hasMessage()) {
			Message message = update.getMessage();
			if (message.hasText()) {
				try {
					handleIncomingMessage(message);
				} catch (TelegramApiException | IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private void handleIncomingMessage(Message message) throws TelegramApiException, IOException {

		answerUser(message);
	}

	private void answerUser(Message message) throws IOException, TelegramApiException {

		ReplyKeyboardMarkup replyKeyboardMarkupMainMenu = Keyboards.getMainMenuKeyboard();
		ReplyKeyboardMarkup replyKeyboardMarkupWeather = Keyboards.getWeatherSubMenuKeyboard();
		ReplyKeyboardMarkup replyKeyboardMarkupCryptoMenu = Keyboards.getCryptoMenuKeyboard();

		SendMessage sendMessageRequest = new SendMessage();

		if (replyKeyboardMarkupMainMenu != null) {
			sendMessageRequest.setReplyMarkup(replyKeyboardMarkupMainMenu);
		}
		if (message.hasText()) {

			sendMessageRequest.setChatId(message.getChatId().toString());

			String userMessage = message.getText();
			if (userMessage.equalsIgnoreCase("⛅️ آب و هوا ⛅️")) {
				if (replyKeyboardMarkupWeather != null) {
					sendMessageRequest.setReplyMarkup(replyKeyboardMarkupWeather);
				}
				sendMessageRequest.setText("👇 لطفا یکی از موارد زیر را انتخاب کنید 👇");
				// --------------- Current ----------------
			} else if (userMessage.equalsIgnoreCase("⛅️ آب و هوای امروز ⛅️")) {
				sendMessageRequest.setText("برای دریافت وضعیت آب و هوا به شکل زیر عمل کنید 👇\n" + "\n"
						+ "/w نام شهر \n" + "\n" + "مثال :\n" + " /w تهران\n" + "/w tehran\n" + "\n"
						+ "چند لحظه پس از ارسال وضعیت آب و هوایی شهر مورد نظر شما ارسال خواهد شد ✅");
			} else if (update.getMessage().getText().contains("/w ")) {
				String cityName = update.getMessage().getText().replace("/w ", "");
				sendMessageRequest.setText(ApiHandelers.callWeatherByBot(BotWebApi.getWeatherByCity(cityName)));

				// --------------- 10 Days ----------------
			} else if (userMessage.equalsIgnoreCase("⛅️ آب و هوای ۱۰ روز آینده ⛅️")) {
				sendMessageRequest.setText("برای دریافت وضعیت آب و هوا 10روز آینده به شکل زیر عمل کنید 👇\n" + "\n"
						+ "/w10 نام شهر \n" + "\n" + "مثال :\n" + " /w10 تهران\n" + "/w10 tehran\n" + "\n"
						+ "چند لحظه پس از ارسال وضعیت آب و هوایی شهر مورد نظر شما ارسال خواهد شد ✅");
			} else if (update.getMessage().getText().contains("/w10 ")) {
				String cityName = update.getMessage().getText().replace("/w10 ", "");
				sendMessageRequest
						.setText(ApiHandelers.callWeatherTenDaysByBot(BotWebApi.getWeatherTenDayds(cityName)));
				// ************************************************************************

				// ************************* CurrencyOfCountries **************************
			} else if (userMessage.equalsIgnoreCase("💵 قیمت ارزهای کشورها 💵")) {
				sendMessageRequest.setText(ApiHandelers.callCurrencyOfCounriesByBot(BotWebApi.getWeatherByCity()));
				// ************************************************************************

				// ******************************* Crypto ************************
			} else if (userMessage.equalsIgnoreCase("💰 قیمت ارزهای دیجیتال 💰")) {
				if (replyKeyboardMarkupWeather != null) {
					sendMessageRequest.setReplyMarkup(replyKeyboardMarkupCryptoMenu);
				}
				sendMessageRequest.setText("👇 لطفا یکی از موارد زیر را انتخاب کنید 👇");
			} else if (userMessage.equalsIgnoreCase("📊 10 ارز برتر 📊")) {
				sendMessageRequest.setText(ApiHandelers.callTopTenCryptoByBot(BotWebApi.getCrypto()));
			} else if (userMessage.equalsIgnoreCase("🔍 جستجوی تکی 🔍")) {
				sendMessageRequest.setText("برای دریافت قیمت ارز مورد نظر به شکل زیر عمل کنید 👇\n" + "\n"
						+ "/c نام ارز \n" + "\n" + "مثال :\n" + "/c BTC\n" + "\n"
						+ "چند لحظه پس از ارسال قیمت ارز مورد نظر شما ارسال خواهد شد ✅");
			} else if (update.getMessage().getText().contains("/c ")) {
				String cryptoName = update.getMessage().getText().replace("/c ", "");
				sendMessageRequest.setText(ApiHandelers.callCryptoByBot(BotWebApi.getCrypto(), cryptoName));
				// ************************************************************************
				// ******************************* Gold & Coins ************************

			} else if (userMessage.equalsIgnoreCase("⭐️ قیمت طلا و سکه ⭐️")) {

				sendMessageRequest.setText(ApiHandelers.callGoldAndCoinsByBot(BotWebApi.getGoldAndCoins()));

				// ************************************************************************

				// ******************************* QrCode ************************
			} else if (userMessage.equalsIgnoreCase("👁‍🗨 ساخت Qrcode 👁‍🗨")) {
				sendMessageRequest.setText("برای ساخت Qrcode با شکل زیر عمل کنید 👇\n" + "\n"
						+ "/qr لینک یا متن مورد نظر\n" + "\n" + "چند لحظه پس از ارسال عکس Qrcode شما ارسال خواهد شد ✅");
			} else if (update.getMessage().getText().contains("/qr ")) {
				String qrcodeText = update.getMessage().getText().replace("/qr", "");
				QrCodeGenerator.getQrcodeData(qrcodeText);
				Long userId = update.getMessage().getFrom().getId();
				SendPhoto sendPhoto = new SendPhoto();
				sendPhoto.setChatId(userId.toString());
				sendPhoto.setPhoto(new InputFile(new File("./Quote.png")));
				sendMessageRequest.setText("کیوآرکد شما با موفقیت ساخته شد ✅ ");
				execute(sendPhoto);
				// *************************************************************
				// ********************* Oghat Sharae **************************
			} else if (userMessage.equalsIgnoreCase("🕌 اوقات شرعی امروز 🕌")) {
				sendMessageRequest.setText("برای دریافت اوقات شرعی امروز به شکل زیر عمل کنید 👇\n" + "\n"
						+ "/g نام شهر \n" + "\n" + "مثال :\n" + " /g تهران\n" + "/g tehran\n" + "\n"
						+ "چند لحظه پس از ارسال اوقات شرعی شهر مورد نظر شما ارسال خواهد شد ✅");

			} else if (update.getMessage().getText().contains("/g ")) {
				String cityName = update.getMessage().getText().replace("/g ", "");

				sendMessageRequest
						.setText(ApiHandelers.callReligiousTimesByBot(BotWebApi.getReligiousTimesModel(cityName)));
				// *************************************************************

				// ************************* Bours **************************
			} else if (userMessage.equalsIgnoreCase("📊 شاخص کل بورس 📊")) {
				sendMessageRequest.setText(ApiHandelers.callBoursByBot(BotWebApi.getBoursModel()));
				// ************************************************************************

				// ************************* Date **************************
			} else if (userMessage.equalsIgnoreCase("🗓 تاریخ امروز 🗓")) {
				sendMessageRequest.setText(ApiHandelers.callDatesByBot(BotWebApi.getDate()));
				// ************************************************************************

			} else if (userMessage.equalsIgnoreCase("👤 درباره ما 👤")) {
				sendMessageRequest.setText("این ربات برای تست می باشد و برای پروژه دانشگاه نوشته شده است 🙏🏻🌹\n"
						+ "\n" + "سازنده : امیر رجبی\n" + "آیدی تلگرام : @Amir_R3\n"
						+ "شماره دانشجویی : 99110033302007\n" + "استاد مربوطه : آقای کوپائی حاجی");
			} else if (userMessage.equalsIgnoreCase("🏠 منو اصلی 🏠")) {
				sendMessageRequest.setReplyMarkup(replyKeyboardMarkupMainMenu);
				sendMessageRequest.setText("🏠 به منو اصلی بازگشتید 🏠");
			} else if (userMessage.equalsIgnoreCase("/start")) {
				sendMessageRequest.setText(botInfoModel.wlecomeMessage(update));
			}
		}
		execute(sendMessageRequest);
	}

	// Bot Config --------------------------------------------------

	public String getBotUsername() {
		return botInfoModel.getBotId();
	}

	@Override
	public String getBotToken() {
		return botInfoModel.getBotToken();
	}
	// --------------------------------------------------------------
}
