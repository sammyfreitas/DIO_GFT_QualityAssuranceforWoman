package desafio_banco_digital;

import java.util.ArrayList;

public class Agencia {
	
	private String nome;
	private long numero;
	private String endereco;
	private ArrayList<Conta> contas;
	
	private static long contadorAgencia = 0;
	
	
	public Agencia(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.numero = contadorAgencia++;
		this.contas = new ArrayList<Conta>();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public long getNumero() {
		return numero;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public void criarNovaContaCorrente(Pessoa pessoa) {
		Conta novaConta = new ContaCorrente(this, pessoa);
		contas.add(novaConta);
	}
	
	public void criarNovaContaPoupanca(Pessoa pessoa) {
		Conta novaConta = new ContaPoupanca(this, pessoa);
		contas.add(novaConta);
	}
	
	public String inativarConta(Conta conta) {
		if(conta.estadoAtivacao.equalsIgnoreCase("ativa")) {
			conta.inativarConta();
			return "Conta inativada";
		} else {
			return "Conta já estava inativa";
		}
	}
	
	
	public String getContas() {
		String dados = "\n[Prefixo 1:  Conta Corrente | Prefixo 2:  Conta Poupanca]\n"
				+ "\nAgencia: " + this.numero + "\n" + this.nome + "\n" + this.endereco + "\n";
		dados += "Contas existentes: ";
		for(Conta c : contas) {
			dados += "\nNumero: " + c.PREFIXO + " " + c.numero + " - " + c.estadoAtivacao;
		}
		return dados;
	}
	
	
	public String getDadosContaEspecifica(String numero) {
		String dados = null;
		for(Conta c : this.contas) {
			if(numero.equalsIgnoreCase(c.getNumero())) {
				Pessoa p = c.getPessoa();
				dados += "Agencia: " + c.getAgencia().getNome() +
						"\nNome Titular: " + p.getNome() + "\nEndereco: " + p.getEndereco() + 
						"\nEmail" + p.getEmail() + "\nSaldo Atual: " + c.getSaldo();
				return dados;
			}
		}
		return null;
	}
	
	
	public Conta buscarConta(String numero) {
		for(Conta c : this.contas) {
			if(numero.equalsIgnoreCase(c.getNumero())) {
				return c;
			}
		}
		return null;
	}
	

}






