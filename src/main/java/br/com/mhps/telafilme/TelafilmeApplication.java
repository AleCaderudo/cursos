package br.com.mhps.telafilme;

import br.com.mhps.telafilme.model.DadosSerie;
import br.com.mhps.telafilme.service.ConsumoApi;
import br.com.mhps.telafilme.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelafilmeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TelafilmeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApi();
		var json = consumoApi.ObterDados("https://www.omdbapi.com/?t=the+boys&apikey=ec422fb7");
		//System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
