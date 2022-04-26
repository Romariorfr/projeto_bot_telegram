package com.bot.jarvis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bot.jarvis.entities.EscalaTrabalho;

@Repository
public interface EscalaRepository extends JpaRepository<EscalaTrabalho,Long> {

}
