package Aplicacoes;

import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author Lucas Leite Severo
 * Data: 20/02/2022
 *
 */

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException{
		Scanner entrada = new Scanner(System.in);
		int questaoInformada = 0;
		while (questaoInformada != 4) {

			System.out.println("--------- DESAFIO QUESTOES - CAPGEMINI----------");
			System.out.println("1 - TRIANGULO DE ASTERISCOS");
			System.out.println("2 - VERIFICACAO DE SENHA FORTE");
			System.out.println("3 - PARES DE ANAGRAMAS");
			System.out.println("4 - SAIR DO MENU");
			System.out.println("------------------------------------------------");
			System.out.println("Infome uma das opcoes acima que deseja realizar:");

			questaoInformada = entrada.nextInt();
			
			
			switch (questaoInformada) {
			case 1: /* Questao 1 */
				/**
				 * Metodo que imprime no console um triangulo de asteriscos alinhados a direita
				 * e recebe um numero inteiro como parametro
				 */
				System.out.println("Informe um numero inteiro positivo para formar o triangulo de asteriscos:");
				int numeroDeAsteriscos = entrada.nextInt();
				
				MetodosDesafio.trianguloDeAsteriscos(numeroDeAsteriscos);
				System.out.println();
				break;
				
			case 2: /* Questao 2 */
				/**
				 * Metodo que verifica se uma senha preenche todos os requisitos de uma senha
				 * forte e retorna um numero inteiro com os requisitos nao preenchidos
				 * 
				 */
				System.out.println("Informe a senha a ser verificada: ");
				String senha = entrada.next();
				System.out.println(MetodosDesafio.senhaForte(senha));
				break;
				
			case 3: /* Questao 3 */
				/**
				 * Metodo que conta e retorna a quantidade de anagramas (substrings) derivados
				 * de uma String informada
				 */
				System.out.println("Informe a palavra (String) que sera analisada: ");
				String palavra = entrada.next();
				System.out.println(MetodosDesafio.countPairsAnagrams(palavra));
				break;
				
			case 4:
				System.out.println("Saindo do Menu... Até Logo!");
		        break;

			default:
				System.out.println("Opcao Invalida!\n");
				break;
			}
		}
		entrada.close();
	}

}
