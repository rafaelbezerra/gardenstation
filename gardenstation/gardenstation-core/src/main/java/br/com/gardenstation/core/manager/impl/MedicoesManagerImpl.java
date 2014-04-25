package br.com.gardenstation.core.manager.impl;

import org.springframework.stereotype.Service;

import br.com.gardenstation.core.entity.Medicoes;
import br.com.gardenstation.core.manager.MedicoesManager;

@Service
public class MedicoesManagerImpl extends ManagerImpl<Medicoes, Integer> implements MedicoesManager{

	@Override
	protected Class<Medicoes> informPersistenceClass() {
		return Medicoes.class;
	}
}
