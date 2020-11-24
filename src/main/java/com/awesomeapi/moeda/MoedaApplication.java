package com.awesomeapi.moeda;

import com.awesomeapi.moeda.utils.Moeda;
import com.awesomeapi.moeda.utils.ServicoMoeda;
import org.springframework.boot.SpringApplication;
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

		while (true){
			System.out.println("\nEscolha a Moeda:");
			System.out.println("<1> Dolar Comercial");
			System.out.println("<2> Dolar Turismo");
			System.out.println("<3> Euro");
			System.out.println("Sua opcao:  ");
			int opcao = scanner.nextInt();

			Moeda moeda = new Moeda();
			if(opcao == 1){
				moeda = ServicoMoeda.buscaMoeda("USD-BRL");
			}else if(opcao == 2){
				moeda = ServicoMoeda.buscaMoeda("USDT-BRL");
			}else if(opcao == 3){
				moeda = ServicoMoeda.buscaMoeda("EUR-BRL");
			}else{
				System.out.println("Opcao invalida!");
			}

			System.out.println("Dados do(a) " + moeda.getName());
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
