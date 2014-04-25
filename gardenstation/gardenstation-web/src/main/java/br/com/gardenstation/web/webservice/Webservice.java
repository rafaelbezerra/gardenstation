package br.com.gardenstation.web.webservice;

import static spark.Spark.get;
import static spark.Spark.post;

import org.springframework.beans.factory.annotation.Autowired;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.servlet.SparkApplication;
import br.com.gardenstation.core.manager.MedicoesManager;
import br.com.gardenstation.web.webservice.helper.WebserviceHelper;

//@Component
public class Webservice implements SparkApplication{

	@Autowired
	WebserviceHelper webserviceHelper;

	@Autowired
	MedicoesManager medicoesManager;
	
	@Override
	public void init() {
		post(new Route("/webservice") {
			@Override
			public Object handle(Request request, Response response) {
				
				webserviceHelper.defineRequest(request);
				
				webserviceHelper.persistMedicoes();
				
				System.out.println(webserviceHelper.constructReturnString(WebserviceHelper.CONSOLE_BREAKLINE));
				return webserviceHelper.constructReturnString(WebserviceHelper.HTML_BREAKLINE);
			}
		});
		
		get(new Route("/test") {
			@Override
			public Object handle(Request request, Response response) {
				return "<div align='center'><h1>Spark webservice is OK!</h1></div>";
			}
		});
	}
}
