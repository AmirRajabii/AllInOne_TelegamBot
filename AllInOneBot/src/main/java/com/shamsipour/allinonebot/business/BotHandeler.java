package com.shamsipour.allinonebot.business;

import java.io.File;

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
<<<<<<< Updated upstream
=======
import com.shamsipour.allinonebot.webapi.CurrencyOfCountriesApi;
import com.shamsipour.allinonebot.webapi.ReligiousTimesApi;
import com.shamsipour.allinonebot.webapi.WeatherApi;
>>>>>>> Stashed changes

public class BotHandeler extends TelegramLongPollingBot {
	BotInfoModel botInfoModel = new BotInfoModel();
	Update update;

	public void onUpdateReceived(Update update) {
		this.update = update;
		if (update.hasMessage()) {
			Message message = update.getMessage();
			if (message.hasText() || message.hasLocation()) {
				try {
					handleIncomingMessage(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private void handleIncomingMessage(Message message) throws TelegramApiException {

		answerUser(message);
	}

	private void answerUser(Message message) {

		ReplyKeyboardMarkup replyKeyboardMarkupMainMenu = Keyboards.getMainMenuKeyboard();
		ReplyKeyboardMarkup replyKeyboardMarkupWeather = Keyboards.getWeatherSubMenuKeyboard();
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
<<<<<<< Updated upstream
			} else if (userMessage == "💰 قیمت ارزهای دیجیتال 💰") {
=======
			}
			// --------------- Current ----------------
			else if (userMessage.equalsIgnoreCase("⛅️ آب و هوای امروز ⛅️")) {
				sendMessageRequest.setText("برای دریافت وضعیت آب و هوا به شکل زیر عمل کنید 👇\n" + "\n"
						+ "/w نام شهر \n" + "\n" + "مثال :\n" + " /w تهران\n" + "/w tehran\n" + "\n"
						+ "چند لحظه پس از ارسال وضعیت آب و هوایی شهر مورد نظر شما ارسال خواهد شد ✅");
			} else if (update.getMessage().getText().contains("/w ")) {
				String cityName = update.getMessage().getText().replace("/w ", "");
				try {
					sendMessageRequest.setText(WeatherHandeler.callWeatherByBot(WeatherApi.getWeatherByCity(cityName)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// ************************************************************************

				// ************************* CurrencyOfCountries **************************
			} else if (userMessage.equalsIgnoreCase("💵 قیمت ارزهای کشورها 💵")) {

				try {
					sendMessageRequest.setText(CurrencyOfCountriesHandeler
							.callCurrencyOfCounriesByBot(CurrencyOfCountriesApi.getWeatherByCity()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// ************************************************************************

			} else if (userMessage.equalsIgnoreCase("💰 قیمت ارزهای دیجیتال 💰")) {
>>>>>>> Stashed changes

				sendMessageRequest.setText("💰 قیمت ارزهای دیجیتال 💰");
			} else if (userMessage.equalsIgnoreCase("⭐️ قیمت طلا ⭐️")) {

				sendMessageRequest.setText("⭐️ قیمت طلا ⭐️");
<<<<<<< Updated upstream
			} else if (userMessage == "👁‍🗨 ساخت Qrcode 👁‍🗨") {
=======

				// ******************************* QrCode ************************
			} else if (userMessage.equalsIgnoreCase("👁‍🗨 ساخت Qrcode 👁‍🗨")) {
>>>>>>> Stashed changes
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
				try {
					execute(sendPhoto);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
<<<<<<< Updated upstream
			} else if (userMessage == "درباره ما") {
=======

				// *************************************************************

				// ********************* Oghat Sharae **************************

			} else if (userMessage.equalsIgnoreCase("🕌 اوقات شرعی امروز 🕌")) {
				sendMessageRequest.setText("برای دریافت اوقات شرعی امروز به شکل زیر عمل کنید 👇\n" + "\n"
						+ "/g نام شهر \n" + "\n" + "مثال :\n" + " /g تهران\n" + "/g tehran\n" + "\n"
						+ "چند لحظه پس از ارسال اوقات شرعی شهر مورد نظر شما ارسال خواهد شد ✅");

			} else if (update.getMessage().getText().contains("/g ")) {
				String cityName = update.getMessage().getText().replace("/g ", "");
				try {
					sendMessageRequest.setText(ReligiousTimesHandeler
							.callReligiousTimesByBot(ReligiousTimesApi.getReligiousTimesModel(cityName)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// *************************************************************

			} else if (userMessage.equalsIgnoreCase("درباره ما")) {
>>>>>>> Stashed changes

				sendMessageRequest.setText(
						"\u200C\u200Cما در زمینه\u200Cی طراحی و توسعه\u200Cی وب فارسی فعال هستیم. نشاط، انگیزه و نوآوری اولین چیزی\u200Cست که از تیم ما به چشم می\u200Cخورد. موضوع اصلی فعالیت ما تولید پوسته\u200Cهای ایرانی برای سیستم وردپرس است. همچنین برنامه نویسی، طراحی سایت، خدمات میزبانی و ... از جمله خدمات ماست.");
			} else if (userMessage.equalsIgnoreCase("🏠 منو اصلی 🏠")) {
				sendMessageRequest.setReplyMarkup(replyKeyboardMarkupMainMenu);
				sendMessageRequest.setText(" به منو اصلی بازگشتید");
			} else if (userMessage.equalsIgnoreCase("/start")) {
				sendMessageRequest.setText(botInfoModel.wlecomeMessage(update));
			}
//			else {
//				sendMessageRequest.setText("❌ مقدار اشتباه وارد شده است لطفا از دکمه ها استفاده کنید ❌");
//			}
		}
		try {
			execute(sendMessageRequest);
		} catch (TelegramApiException e) {
			sendMessageRequest.setText("Wrong Command");
		}
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
