package com.shamsipour.allinonebot.view;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.shamsipour.allinonebot.business.BotHandeler;

public class Main {

	public static void main(String[] args) {

		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new BotHandeler());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		System.out.println("--- Bot Started ---");
	}

}
