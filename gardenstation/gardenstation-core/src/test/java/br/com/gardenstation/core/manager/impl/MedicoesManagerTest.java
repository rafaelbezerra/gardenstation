package br.com.gardenstation.core.manager.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.gardenstation.core.entity.Luminosidade;
import br.com.gardenstation.core.entity.Medicoes;
import br.com.gardenstation.core.entity.Temperatura;
import br.com.gardenstation.core.entity.Umidade;
import br.com.gardenstation.core.manager.LuminosidadeManager;
import br.com.gardenstation.core.manager.MedicoesManager;
import br.com.gardenstation.core.manager.TemperaturaManager;
import br.com.gardenstation.core.manager.UmidadeManager;


@Component
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:/META-INF/spring-test/spring-config.xml")
public class MedicoesManagerTest {
	
	@Autowired
	private UmidadeManager umidadeManager;
	
	@Autowired
	private TemperaturaManager temperaturaManager;
	
	@Autowired
	private LuminosidadeManager luminosidadeManager;
	
	@Autowired
	private MedicoesManager medicoesManager;
	
	private Medicoes medicoes, medicoes2;
	private Luminosidade luminosidade;
	private Temperatura temperatura;
	private Umidade umidade, umidade2;
	
	@Before
	public void init(){
		
		this.luminosidade = new Luminosidade();
		this.temperatura = new Temperatura();
		this.umidade = new Umidade();
		this.medicoes = new Medicoes();
		
		this.luminosidade.setLumi1(1);
		this.luminosidade.setLumi2(2);
		this.luminosidade.setLumi3(3);
		this.luminosidade.setLumi4(4);
		
		this.temperatura.setAr(20D);
		this.temperatura.setTerra(40D);
		
		this.umidade.setAr(5D);
		this.umidade.setTerra(10D);
		
		this.medicoes.setLuminosidade(this.luminosidade);
		this.medicoes.setTemperatura(this.temperatura);
		this.medicoes.setUmidade(this.umidade);
	}
	
	@Test
	public void testaSave(){
		this.luminosidadeManager.save(luminosidade);
		this.temperaturaManager.save(temperatura);
		this.umidadeManager.save(umidade);
		
		this.medicoesManager.save(this.medicoes);

		Assert.assertNotNull(this.medicoes.getLuminosidade().getId());
		Assert.assertNotNull(this.medicoes.getTemperatura().getId());
		Assert.assertNotNull(this.medicoes.getUmidade().getId());
		Assert.assertNotNull(this.medicoes.getId());
	}
	
	@Test
	public void testaMerge(){
		this.luminosidadeManager.save(luminosidade);
		this.temperaturaManager.save(temperatura);
		this.umidadeManager.save(umidade);
		
		this.medicoesManager.save(this.medicoes);
		
		this.umidade2 = new Umidade();
		this.umidade2.setAr(50D);
		this.umidade2.setTerra(100D);
		
		this.umidadeManager.save(umidade2);
		
		this.medicoes.setUmidade(umidade2);
		
		this.medicoesManager.merge(medicoes);
		
		Assert.assertTrue(this.medicoes.getUmidade().getId() == this.umidade2.getId());
	}
	
	@Test
	public void testaRemove(){
		this.luminosidadeManager.save(luminosidade);
		this.temperaturaManager.save(temperatura);
		this.umidadeManager.save(umidade);
		
		this.medicoesManager.save(this.medicoes);
		
		Integer idMedicoes = this.medicoes.getId();
		
		this.medicoesManager.remove(medicoes);
		
		medicoes2 = this.medicoesManager.findById(idMedicoes);
		
		Assert.assertNull(medicoes2);
	}
	
	@Test
	public void testaFindById(){
		this.luminosidadeManager.save(luminosidade);
		this.temperaturaManager.save(temperatura);
		this.umidadeManager.save(umidade);
		
		this.medicoesManager.save(this.medicoes);
		
		Integer idMedicoes = this.medicoes.getId();
		
		
		medicoes2 = this.medicoesManager.findById(idMedicoes);
		
		Assert.assertTrue(medicoes.getId() == medicoes2.getId());
	}
}
