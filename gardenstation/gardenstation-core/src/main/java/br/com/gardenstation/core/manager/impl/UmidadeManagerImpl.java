package br.com.gardenstation.core.manager.impl;

import org.springframework.stereotype.Service;

import br.com.gardenstation.core.entity.Umidade;
import br.com.gardenstation.core.manager.UmidadeManager;

@Service
public class UmidadeManagerImpl extends ManagerImpl<Umidade, Integer> implements UmidadeManager{

	@Override
	protected Class<Umidade> informPersistenceClass() {
		return Umidade.class;
	}
}
