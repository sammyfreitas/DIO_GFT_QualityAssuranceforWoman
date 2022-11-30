package mais_desafios_gft_qa1;

import java.util.Scanner;

public class RespostaTheon {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("digite o número de pessoas:  ");
		int numPessoas = scan.nextInt();
		
		int menorPunicao = 21;
		int posicaoPessoa = 0;
		
		for(int i = 0; i < numPessoas; i++) {
			System.out.println("digite o número de punicoes da " + (i+1) + ": ");
			int punicoes = scan.nextInt();
			if(punicoes < menorPunicao) {
				menorPunicao = punicoes;
				posicaoPessoa = i + 1;
			}
		}
		System.out.println("punicoes totais:  " + menorPunicao);
		System.out.println("pessoa da  " + posicaoPessoa + " posição");

		scan.close();
	}

}