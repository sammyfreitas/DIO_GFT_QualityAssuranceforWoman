package mais_desafios_gft_qa1;

import java.util.Scanner;

public class MultiplicacaoSimples {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("digite um número:  ");
		int n1 = scan.nextInt();
		System.out.println("digite um segundo número:  ");
		int n2 = scan.nextInt();
		
		int PROD = n1 * n2;
		
		System.out.println("PROD = " + PROD);
		
		scan.close();
	}

}