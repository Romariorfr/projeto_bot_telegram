package com.bot.jarvis.launch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.bot.jarvis.services.EscalaService;

@SpringBootApplication
public class RunBot implements CommandLineRunner {

	@Autowired
	private EscalaService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new JarvisBot(service));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
