package mais_desafios_gft_qa1;

import java.util.Scanner;

public class DomingoManha {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {  // enquanto houver dados na entrada
			//System.out.println("digite uma hora:  ");
			String horario[] = scan.nextLine().split(":");
			int hora = Integer.parseInt(horario[0]);
			int min = Integer.parseInt(horario[1]);
			
			if(hora < 7) {
				System.out.println("Atraso maximo: 0");
			}
			else {
				System.out.println("Atraso maximo: " + (60 * (hora - 7) + min));
			}
			
			/*switch(horario[0]) {
			case("7"): System.out.println("Atraso maximo: " + horario[1]); break;
			case("8"): System.out.println("Atraso maximo: " + horario[1]); break;
			case("9"): System.out.println("Atraso maximo: " + horario[1]); break;
			default:  System.out.println("Atraso maximo: 0");
			}*/
		}
		scan.close();
	}

}