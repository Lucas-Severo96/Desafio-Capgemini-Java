package Aplicacoes;

import java.util.Arrays;

public class MetodosDesafio {

	public static void trianguloDeAsteriscos(int numeroAsteriscos) {

		int i, j = 0;

		for (i = 1; i <= numeroAsteriscos; i++) {
			for (j = numeroAsteriscos - i; j >= 1; j--) {
				System.out.print(" ");
			}
			for (j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	/**
	 * Metodo que retorna a quantidade minima de caracteres que devem ser 
	 * adicionados para uma senha ser considerada segura	 
	 * @param senha
	 * @return
	 */
	public static int senhaForte(String senha) {

		// Quantidade mínima de caracteres
		int quantMinChar = 6;

		// O contador inicia com a quantidade minima e depois vai decrementando
		int count = quantMinChar;

		// Caracteres especiais
		String specialChats = "!@#$%^&*()-+";

		boolean contemNumero = false;
		boolean contemMaiuscula = false;
		boolean contemMinuscula = false;
		boolean caracterEspecial = false;

		//Condicao para a String nao ser nula nem vazia
		if (senha != null && !senha.isEmpty()) {
			
			for (char c : senha.toCharArray()) {
				
				// verifica se tem digito antes de entrar no if
				if (c >= '0' && c <= '9' && !contemNumero) {
					count--;
					contemNumero = true;
					
				//verifica se tem letra maiscula
				} else if (c >= 'A' && c <= 'Z' && !contemMaiuscula) {
					count--;
					contemMaiuscula = true;
					
				//Verifica se tem letra minuscula
				} else if (c >= 'a' && c <= 'z' && !contemMinuscula) {
					count--;
					contemMinuscula = true;
					
				//Verifica se tem caracter especial
				} else if (specialChats.contains(String.valueOf(c)) && !caracterEspecial) {
					count--;
					caracterEspecial = true;
				}
			}
			
			//Condicao para quantidade minima de caracteres
			if (senha.length() >= quantMinChar) {
				count = count - 2;
			} else {
				count --;
			}
		}
		return count;
	}

	/**
	 * Metodo que serve para contar a quantidade de pares de anagramas existem na
	 * palavra enviada por parametro
	 * 
	 * @param word
	 * @return
	 */
	public static int countPairsAnagrams(String word) {
		int count = 0;

		// transformando a String em um array de caracteres
		char chars1[] = word.toCharArray();

		// inicia a iteracao de 1 em 1 caracter
		for (int z = 1; z < chars1.length; z++) {

			// iterando os caracteres para verificar se eh um anagrama
			for (int i = 0; (i + z) <= chars1.length; i = i + z) {

				// cria um array de char aux para depois transformar partes das palavras em
				// string
				char pairsI[] = new char[z];
				for (int b = 0; b < pairsI.length; b++) {
					pairsI[b] = chars1[i + b];
				}
				String pair1 = new String(pairsI);

				for (int k = i + 1; (k + z) <= chars1.length; k++) {

					// cria um array de char aux para depois transformar partes das palavras em
					// string
					char pairsK[] = new char[z];
					for (int c = 0; c < pairsI.length; c++) {
						pairsK[c] = chars1[k + c];
					}
					String pair2 = new String(pairsK);

					// TODO: REMOVER COMENTARIO ABAIXO
					// System.out.println("comparando: [" + pair1 +":"+ pair2 +"]");

					if (isAnagram(pair1, pair2)) {
						count++;
					}
				}
			}

		}

		return count;
	}

	/**
	 * Metodo privado utilizado para verificar se eh um anagrama ou não
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean isAnagram(String s1, String s2) {
		// se as duas strings não tem o mesmo tamanho, não é anagrama
		if (s1.length() != s2.length()) {
			return false;
		}

		// tranfroma em arrays para poder ordenar
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		// ordena para garantir a comparação simplificada
		Arrays.sort(c1);
		Arrays.sort(c2);

		// cria as novas strings baseadas nos arrays ordenados
		String sc1 = new String(c1);
		String sc2 = new String(c2);

		return sc1.equals(sc2);
	}
	
	public final static void clearConsole(){

        try{
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");

            }else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){
        
        }
    }
}
