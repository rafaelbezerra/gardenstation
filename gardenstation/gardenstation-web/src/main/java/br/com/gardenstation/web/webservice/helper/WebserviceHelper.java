package br.com.gardenstation.web.webservice.helper;

import java.util.Date;

import org.springframework.stereotype.Component;

import spark.Request;
import br.com.gardenstation.core.entity.Luminosidade;
import br.com.gardenstation.core.entity.Medicoes;
import br.com.gardenstation.core.entity.Temperatura;
import br.com.gardenstation.core.entity.Umidade;
import br.com.gardenstation.core.manager.LuminosidadeManager;
import br.com.gardenstation.core.manager.MedicoesManager;
import br.com.gardenstation.core.manager.TemperaturaManager;
import br.com.gardenstation.core.manager.UmidadeManager;
import br.com.gardenstation.core.manager.impl.LuminosidadeManagerImpl;
import br.com.gardenstation.core.manager.impl.MedicoesManagerImpl;
import br.com.gardenstation.core.manager.impl.TemperaturaManagerImpl;
import br.com.gardenstation.core.manager.impl.UmidadeManagerImpl;

@Component
public class WebserviceHelper {
	
	private UmidadeManager umidadeManager;
	private TemperaturaManager temperaturaManager;
	private LuminosidadeManager luminosidadeManager;
	private MedicoesManager medicoesManager;
	
	
	private Request request;
	private Medicoes medicoes;
	
	public static final String HTML_BREAKLINE = "<br/>";
	public static final String CONSOLE_BREAKLINE = "\n";
	
	public WebserviceHelper(){
		this.umidadeManager = new UmidadeManagerImpl();
		this.temperaturaManager = new TemperaturaManagerImpl();
		this.luminosidadeManager = new LuminosidadeManagerImpl();
		this.medicoesManager = new MedicoesManagerImpl();
	}
	
	public void defineRequest(Request request){
		this.request = request;
		this.constructMedicoes();
	}
	
	public void persistMedicoes(){
		this.umidadeManager.save(this.medicoes.getUmidade());
		this.temperaturaManager.save(this.medicoes.getTemperatura());
		this.luminosidadeManager.save(this.medicoes.getLuminosidade());
		
		this.medicoesManager.save(medicoes);
	}
	
	public String constructReturnString (String breakLineConstant){
		return "Request received at " + new Date() + breakLineConstant
				+ "valSensorUmidadeTerra = " + this.medicoes.getUmidade().getTerra() + breakLineConstant
				+ "valSensorTemperaturaTerra = " + this.medicoes.getTemperatura().getTerra() + breakLineConstant
				+ "valSensorTemperaturaAr = " + this.medicoes.getTemperatura().getAr() + breakLineConstant
				+ "valSensorUmidadeAr = " + this.medicoes.getUmidade().getAr() + breakLineConstant
				+ "valSensorLuminosidade1 = " + this.medicoes.getLuminosidade().getLumi1() + breakLineConstant
				+ "valSensorLuminosidade2 = " + this.medicoes.getLuminosidade().getLumi2() + breakLineConstant
				+ "valSensorLuminosidade3 = " + this.medicoes.getLuminosidade().getLumi3() + breakLineConstant
				+ "valSensorLuminosidade4 = " + this.medicoes.getLuminosidade().getLumi4();
	}
	
	private void constructMedicoes(){
		Umidade umidade = new Umidade();
		Temperatura temperatura = new Temperatura();
		Luminosidade luminosidade = new Luminosidade();
		
		Double umidadeTerra = Double.parseDouble(request.queryParams("valSensorUmidadeTerra"));
		Double umidadeAr = Double.parseDouble(request.queryParams("valSensorUmidadeAr"));
		Double temperaturaTerra = Double.parseDouble(request.queryParams("valSensorTemperaturaTerra"));
		Double temperaturaAr = Double.parseDouble(request.queryParams("valSensorTemperaturaAr"));
		int luminosidade1 = Integer.parseInt(request.queryParams("valSensorLuminosidade1"));
		int luminosidade2 = Integer.parseInt(request.queryParams("valSensorLuminosidade2"));
		int luminosidade3 = Integer.parseInt(request.queryParams("valSensorLuminosidade3"));
		int luminosidade4 = Integer.parseInt(request.queryParams("valSensorLuminosidade4"));
		
		umidade.setTerra(umidadeTerra);
		umidade.setAr(umidadeAr);
		temperatura.setTerra(temperaturaTerra);
		temperatura.setAr(temperaturaAr);
		luminosidade.setLumi1(luminosidade1);
		luminosidade.setLumi2(luminosidade2);
		luminosidade.setLumi3(luminosidade3);
		luminosidade.setLumi4(luminosidade4);

		this.medicoes = new Medicoes();
		this.medicoes.setUmidade(umidade);
		this.medicoes.setTemperatura(temperatura);
		this.medicoes.setLuminosidade(luminosidade);
	}
}
