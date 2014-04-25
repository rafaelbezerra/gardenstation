package br.com.gardenstation.core.manager.impl;

import org.springframework.stereotype.Service;

import br.com.gardenstation.core.entity.Temperatura;
import br.com.gardenstation.core.manager.TemperaturaManager;

@Service
public class TemperaturaManagerImpl extends ManagerImpl<Temperatura, Integer> implements TemperaturaManager{

	@Override
	protected Class<Temperatura> informPersistenceClass() {
		return Temperatura.class;
	}
}
