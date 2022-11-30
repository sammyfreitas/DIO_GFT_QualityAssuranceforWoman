package mais_desafios_gft_qa1;

import java.util.Scanner;

public class Xadrez {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("digite um número:  ");
		int n1 = scan.nextInt();
		System.out.println("digite um segundo número:  ");
		int n2 = scan.nextInt();
		
		if(n1%2 == 0) {
			if(n2%2 == 0) {
				System.out.println("1 - branco");
			} else {
				System.out.println("0 - preto");
			}
		} else {
			if(n2%2 != 0) {
				System.out.println("1 - branco");
			} else {
				System.out.println("0 - preto");
			}
		}

		scan.close();
	}

}