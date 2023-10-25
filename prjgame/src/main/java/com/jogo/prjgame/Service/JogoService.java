package com.jogo.prjgame.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jogo.prjgame.Repository.JogoRepository;
import com.jogo.prjgame.entities.Jogo;

@Service
public class JogoService {
	private final JogoRepository jogoRepositorio;

	@Autowired
	public JogoService(JogoRepository jogoRepositorio) {
		this.jogoRepositorio = jogoRepositorio;
	}
	
	public Jogo getJogoById(Long id) {
		return jogoRepositorio.findById(id).orElse(null);
	}
	
	public List<Jogo> getAllJogo() {
		return jogoRepositorio.findAll();
	}

	public Jogo saveJogo(Jogo jogo) {
		return jogoRepositorio.save(jogo);
	}
	
	public void deleteJogo(Long id) {
		jogoRepositorio.deleteById(id);
	}
	public Jogo updateJogo(Long id, Jogo novoJogo) {
        Optional<Jogo> jogoOptional = jogoRepositorio.findById(id);
        if (jogoOptional.isPresent()) {
        	Jogo jogoExistente = jogoOptional.get();
           	jogoExistente.setName(novoJogo.getName());
        	jogoExistente.setPlataform(novoJogo.getPlataform());          
            return jogoRepositorio.save(jogoExistente); 
        } else {
            return null; 
        }
    
	}
}

