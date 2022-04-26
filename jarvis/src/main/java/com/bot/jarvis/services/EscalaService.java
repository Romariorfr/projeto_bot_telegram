package com.bot.jarvis.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bot.jarvis.entities.EscalaTrabalho;
import com.bot.jarvis.repositories.EscalaRepository;

@Service
public class EscalaService {

	private EscalaRepository repository;

	public EscalaService(EscalaRepository repository) {
		super();
		this.repository = repository;
	}

	public List<EscalaTrabalho> findAll() {
		return repository.findAll();
	}

}
