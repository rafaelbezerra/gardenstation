package br.com.gardenstation.core.manager.impl;

import org.springframework.stereotype.Service;

import br.com.gardenstation.core.entity.Luminosidade;
import br.com.gardenstation.core.manager.LuminosidadeManager;

@Service
public class LuminosidadeManagerImpl extends ManagerImpl<Luminosidade, Integer> implements LuminosidadeManager {

	@Override
	protected Class<Luminosidade> informPersistenceClass() {
		return Luminosidade.class;
	}
}
