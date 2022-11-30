package mais_desafios_gft_qa1;

import java.util.Scanner;

public class Media1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("digite a primeira nota:  ");
		double A = scan.nextDouble();
		System.out.println("digite a segunda nota:  ");
		double B = scan.nextDouble();
		
		A *= 3.5;
		B *= 7.5;
		
		double media = (A + B) / 11;
		
		System.out.printf("MEDIA = %.5f", media);

		scan.close();
	}

}