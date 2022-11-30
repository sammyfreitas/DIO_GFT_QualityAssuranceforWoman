package desafio_banco_digital;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Principal {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	

	public static void main(String[] args) {
	
		Pessoa pe1 = new PeFisica("Joao Maria", "Rua do Amazonas, 1005, Distrito Central 1", "jm@mail.com", "123456789-55");
		Pessoa pe2 = new PeFisica("Maria das Neves", "Rua do Acre, 1006, Distrito Central 1", "mn@mail.com", "123456789-66");
		Pessoa pe3 = new PeFisica("Jose da Silva", "Rua do Amapa, 1007, Distrito Central 2", "js@mail.com", "123456789-77");
		Pessoa pe4 = new PeFisica("Mariana Leite", "Rua do Roraima, 1008, Distrito Central 2", "ml@mail.com", "123456789-88");
		
		Agencia ag1 = new Agencia("Agencia do Distrito Central 1", "Distrito Central 1");
		agencias.add(ag1);
		Agencia ag2 = new Agencia("Agencia do Distrito Central 2", "Distrito Central 2");
		agencias.add(ag2);
		
		
		ag1.criarNovaContaPoupanca(pe1);
		ag1.criarNovaContaPoupanca(pe2);
		
		ag2.criarNovaContaCorrente(pe3);
		ag2.criarNovaContaCorrente(pe4);
		
		
		
		telaPrincipal();
	}
	
	
	// INTERFACE
	public static void telaPrincipal() {
		
		int opcao;
		
		do {
			System.out.println("\n\n========== Tela de Acoes do Banco Digital ==========");
			System.out.println(" 1:  Ver Todas as Contas das Agencias");
			System.out.println(" 2:  Criar Nova Conta Pessoa Fiscia");
			System.out.println(" 3:  Criar Nova Conta Pessoa Juridica");
			System.out.println(" 4:  Ver Dados de uma Conta Especifica");
			System.out.println(" 5:  Deposito em Conta");
			System.out.println(" 6:  Saque em Conta");
			System.out.println(" 7:  Transferir para uma Conta");
			System.out.println(" 8:  Inativar Conta");
			System.out.println(" 9:  Ativar Conta");
			
			System.out.println(" 0:  Sair");
			
			 opcao = scan.nextInt();
			
			switch (opcao) {
			case 1: verContasAgencias(); break;
			case 2: criarContaFisica(); break;
			case 3: criarContaJuridica(); break;
			case 4: verDadosContaEspecifica(); break;
			case 5: depositoEmConta(); break;
			case 6: saqueEmConta(); break;
			case 7: transferenciaParaUmaConta(); break;
			case 8: inativarConta(); break;
			case 9: ativarConta(); break;
			case 0: break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		} while(opcao != 0);
		
		System.out.println("===== FIM DO SISTEMA =====");
	}
	

	


	
	
	// CONTROLE
	
	private static void ativarConta() {
		scan.nextLine();
		System.out.print("digite o numero da conta para ativar no formato [<PREFIXO> <ESPACO> <NUMERO>]:  ");
		String numero = scan.nextLine();
		for(Agencia a : agencias) {
			Conta c = a.buscarConta(numero);
			if(c != null) {
				System.out.println("Digite 1 para confirmar, Digite 0 para cancelar:  ");
				String confirmacao = scan.nextLine();
				if(confirmacao.equalsIgnoreCase("1")) {
					c.ativarConta();
				}
				
			} else {
				System.out.println("Erro interno....");
			}
		}
	}

	
	private static void inativarConta() {
		scan.nextLine();
		System.out.print("digite o numero da conta para inativar no formato [<PREFIXO> <ESPACO> <NUMERO>]:  ");
		String numero = scan.nextLine();
		for(Agencia a : agencias) {
			Conta c = a.buscarConta(numero);
			if(c != null) {
				System.out.println("Digite 1 para confirmar, Digite 0 para cancelar:  ");
				String confirmacao = scan.nextLine();
				if(confirmacao.equalsIgnoreCase("1")) {
					c.inativarConta();
				}
				
			} else {
				System.out.println("Erro interno....");
			}
		}
		
	}
	
	
	private static void transferenciaParaUmaConta() {
		scan.nextLine();
		System.out.print("digite o numero da conta de origem no formato [<PREFIXO> <ESPACO> <NUMERO>]:  ");
		String numeroOrigem = scan.nextLine();
		System.out.print("digite o numero da conta de destino no formato [<PREFIXO> <ESPACO> <NUMERO>]:  ");
		String numeroDestino = scan.nextLine();
		for(Agencia a : agencias) {
			ContaCorrente co = (ContaCorrente) a.buscarConta(numeroOrigem);
			ContaCorrente cd = (ContaCorrente) a.buscarConta(numeroDestino);
			if(co != null && cd != null) {
				System.out.println("Digite um valor para a trasnferencia:  ");
				double valor = scan.nextDouble();
				co.transferir(cd, valor);
				break;
			} else {
				System.out.println("Erro interno....");
			}
		}
		
	}
	
	
	private static void saqueEmConta() {
		scan.nextLine();
		System.out.print("digite o numero da conta no formato [<PREFIXO> <ESPACO> <NUMERO>]:  ");
		String numero = scan.nextLine();
		for(Agencia a : agencias) {
			Conta c = a.buscarConta(numero);
			if(c != null) {
				System.out.println("Digite um valor para o saque:  ");
				double valor = scan.nextDouble();
				c.sacar(valor);
				break;
			} else {
				System.out.println("Erro interno....");
			}
		}
		
	}




	private static void depositoEmConta() {
		scan.nextLine();
		System.out.print("digite o numero da conta no formato [<PREFIXO> <ESPACO> <NUMERO>]:  ");
		String numero = scan.nextLine();
		for(Agencia a : agencias) {
			Conta c = a.buscarConta(numero);
			if(c != null) {
				System.out.println("Digite um valor para o deposito:  ");
				double valor = scan.nextDouble();
				c.depositar(valor);
				break;
			} else {
				System.out.println("Erro interno....");
			}
		}
	}


	private static void verDadosContaEspecifica() {
		scan.nextLine();
		System.out.print("digite o numero da conta no formato [<PREFIXO> <NUMERO>]:  ");
		String numero = scan.nextLine();
		for(Agencia a : agencias) {
			String dados = a.getDadosContaEspecifica(numero);
			if(dados == null) {
				continue;
			} else {
				System.out.println(dados);
				break;
			}
		}
	}



	private static void verContasAgencias() {
		for(Agencia a : agencias) {
			System.out.println(a.getContas());
		}
	}


	public static void criarContaFisica() {
		scan.nextLine();
		System.out.print("digite o nome do titular:  ");
		String nome = scan.nextLine();
		System.out.print("digite o endereco do titular:  ");
		String endereco = scan.nextLine();
		System.out.print("digite o email do titular:  ");
		String email = scan.nextLine();
		System.out.print("digite o CPF do titular:  ");
		String cpf = scan.nextLine();
		System.out.print("digite 1 - para criar conta corrente; ou 2 - para conta poupanca:  ");
		String tipoConta = scan.nextLine();
		if(tipoConta.equalsIgnoreCase("1")) {
			Pessoa pessoa = new PeFisica(nome, endereco, email, cpf);
			int umaAGencia = (new Random().nextInt(agencias.size() - 1));
			Agencia agencia = agencias.get(umaAGencia);
			Conta conta = new ContaCorrente(agencia, pessoa);
			agencia.criarNovaContaCorrente(pessoa);
		} else {
			Pessoa pessoa = new PeFisica(nome, endereco, email, cpf);
			int umaAGencia = (new Random().nextInt(agencias.size() - 1));
			Agencia agencia = agencias.get(umaAGencia);
			Conta conta = new ContaPoupanca(agencia, pessoa);
			agencia.criarNovaContaPoupanca(pessoa);
		}
	}

	
	private static void criarContaJuridica() {
		scan.nextLine();
		System.out.print("digite o nome da empresa:  ");
		String nome = scan.nextLine();
		System.out.print("digite o nome fantasia:  ");
		String nomeFantasia = scan.nextLine();
		System.out.print("digite o endereco do titular:  ");
		String endereco = scan.nextLine();
		System.out.print("digite o email do titular:  ");
		String email = scan.nextLine();
		System.out.print("digite o CNPJ:  ");
		String cnpj = scan.nextLine();
		System.out.print("digite 1 - para criar conta corrente; ou 2 - para conta poupanca:  ");
		String tipoConta = scan.nextLine();
		if(tipoConta.equalsIgnoreCase("1")) {
			Pessoa pessoa = new PeJuridica(nome, nomeFantasia, endereco, email, cnpj);
			int umaAGencia = (new Random().nextInt(agencias.size() - 1));
			Agencia agencia = agencias.get(umaAGencia);
			Conta conta = new ContaCorrente(agencia, pessoa);
			agencia.criarNovaContaCorrente(pessoa);
		} else {
			Pessoa pessoa = new PeJuridica(nome, nomeFantasia, endereco, email, cnpj);
			int umaAGencia = (new Random().nextInt(agencias.size() - 1));
			Agencia agencia = agencias.get(umaAGencia);
			Conta conta = new ContaPoupanca(agencia, pessoa);
			agencia.criarNovaContaPoupanca(pessoa);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}