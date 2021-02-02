package com.awesomeapi.moeda;

import com.awesomeapi.moeda.entity.MoedaEntity;
import com.awesomeapi.moeda.service.MoedaService;
import com.awesomeapi.moeda.utils.Constants;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MoedaApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(MoedaApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		System.out.println("##########################");
		System.out.println("### Consulta de Moedas ###");
		System.out.println("##########################");
		MoedaService moedaService = new MoedaService();

		while (true){
			System.out.println("\nEscolha a Moeda:");
			System.out.println("<1> Dolar Comercial");
			System.out.println("<2> Dolar Turismo");
			System.out.println("<3> Euro");
			System.out.println("Sua opcao:  ");
			int opcao = scanner.nextInt();

			MoedaEntity moeda = new MoedaEntity();
			if(opcao == 1){
				moeda = moedaService.buscaMoeda(Constants.USD_BRL);
			}else if(opcao == 2){
				moeda = moedaService.buscaMoeda(Constants.USDT_BRL);
			}else if(opcao == 3){
				moeda = moedaService.buscaMoeda(Constants.EUR_BRL);
			}else{
				System.out.println("Opcao invalida!");
			}

			System.out.println("Dados do(a) " + moeda.getCode() + " - " + moeda.getName());
			System.out.println("Valor atual R$" + String.format("%.2f", moeda.getBid()));
			System.out.println("\nDeseja buscar novamente?\n<0> Não\n<1> Sim\nSua opcao: ");

			opcao = scanner.nextInt();
			if(opcao == 0){
				break;
			}
		}
		System.out.print("Fim de programa!");

	}

}
