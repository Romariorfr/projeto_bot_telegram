package com.bot.jarvis.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.jarvis.entities.EscalaTrabalho;
import com.bot.jarvis.repositories.EscalaRepository;

@Service
public class EscalaService {

	@Autowired
	private EscalaRepository repository;

	public List<EscalaTrabalho> findAll() {
		return repository.findAll();
	}

	public String decodificaHorario(int turno) {

		String turno1 = "23:00 ás 07:20";
		String turno2 = "07:00 ás 15:20";
		String turno3 = "15:00 ás 23:20";
		String turno4 = "Folga";

		String resposta = "";

		switch (turno) {
		case 1:
			resposta = turno1;
			break;

		case 2:
			resposta = turno2;
			break;

		case 3:
			resposta = turno3;
			break;

		case 4:
			resposta = turno4;
			break;
		}
		return resposta;
	}

	public String decodificaLetra(String letra) {

		String letraA = "Tiago e Romário";
		String letraB = "Lucas e Jean";
		String letraC = "João Carlos e Celso";
		String letraD = "Michael e Carlos";

		String resposta = "";

		switch (letra) {
		case "A":
			resposta = letraA;
			break;

		case "B":
			resposta = letraB;
			break;

		case "C":
			resposta = letraC;
			break;

		case "D":
			resposta = letraD;
			break;
		}

		return resposta;
	}

	public String retornaHoraAtual() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date hora = Calendar.getInstance().getTime();
		String horaF = sdf.format(hora);
		return horaF;
	}

}
