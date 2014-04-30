package br.com.gardenstation.core.manager.impl;

import org.springframework.stereotype.Repository;

import br.com.gardenstation.core.entity.Umidade;
import br.com.gardenstation.core.manager.UmidadeManager;

@Repository
public class UmidadeManagerImpl extends ManagerImpl<Umidade, Integer> implements UmidadeManager{

	@Override
	protected Class<Umidade> informPersistenceClass() {
		return Umidade.class;
	}
}
