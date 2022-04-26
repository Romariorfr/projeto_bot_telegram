package com.bot.jarvis.launch;

import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.bot.jarvis.entities.EscalaTrabalho;
import com.bot.jarvis.services.EscalaService;

public class JarvisBot extends TelegramLongPollingBot {

	private EscalaService service;

	public JarvisBot(EscalaService service) {

		this.service = service;
	}

	@Override
	public String getBotUsername() {
		return DadosBot.BOT_USER_NAME;
	}

	@Override
	public String getBotToken() {
		return DadosBot.BOT_TOKEN;
	}

	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {
			var mensagem = responder(update, service);
			try {
				execute(mensagem);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	private SendMessage responder(Update update, EscalaService service) {

		var textoMensagem = update.getMessage().getText().toLowerCase();
		var chatId = update.getMessage().getChatId().toString();

		var resposta = "";

		if ("data".equals(textoMensagem)) {
			resposta = "	retorna a data";
		}

		else if (textoMensagem.startsWith("turno atual")) {
			List<EscalaTrabalho> list = service.findAll();
			resposta = list.get(1).getLetra();
		}

		else {
			resposta = "não entendi seu comando!";
		}

		return SendMessage.builder().text(resposta).chatId(chatId).build();
	}

}
