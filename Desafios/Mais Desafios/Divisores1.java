package mais_desafios_gft_qa1;

import java.util.Iterator;
import java.util.Scanner;

public class Divisores1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("digite um número para ver seus divisores:  ");
		String n = scan.nextLine();
		
		int numero = Integer.parseInt(n);
		
		System.out.println("divisores:  ");
		
		for(int i = 1; i <= numero; i++) {
			if(numero%i == 0) {
				System.out.println(i);
			}
		}
		
		scan.close();
	}

}