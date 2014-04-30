package br.com.gardenstation.core.manager;

import org.springframework.stereotype.Repository;

import br.com.gardenstation.core.entity.Umidade;

@Repository
public interface UmidadeManager extends Manager<Umidade, Integer>{
	/**
	 * 
	 * Interface para inserção de métodos incomuns a outros beans
	 * 
	 */
}
