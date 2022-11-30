package desafio_banco_digital;

import java.util.ArrayList;

public abstract class Conta {
	
	protected Long numero;
	protected Agencia agencia;
	protected Pessoa pessoa;
	protected double saldo;
	protected String estadoAtivacao;
	protected Long PREFIXO = (long) 002;
	private static long contadorConta = 1000;
	protected ArrayList<String> movimentacoes;
	
	
	
	public Conta(Agencia agencia, Pessoa pessoa) {
		this.numero = contadorConta++;
		this.agencia = agencia;
		this.pessoa = pessoa;
		this.saldo = 0.0;
		this.movimentacoes = new ArrayList<String>();
		this.movimentacoes.add("Conta criada.  Saldo:  0.0"); //futuro colocar data
	}

	
	
	public Agencia getAgencia() {
		return agencia;
	}

	public String verificaAtivacao() {
		return estadoAtivacao;
	}

	public void inativarConta() {
		this.estadoAtivacao = "inativada";
	}
	
	public void ativarConta() {
		this.estadoAtivacao = "ativa";
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public String getNumero() {
		return this.PREFIXO + " " + this.numero;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	protected boolean depositar(double valor) {
		 if(estadoAtivacao.equalsIgnoreCase("ativa")) {
			 this.saldo += valor;
			 movimentacoes.add("Deposito efetuado no valor:  " + valor + ".  Saldo Atual:  " + this.saldo);
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	
	public boolean sacar(double valor) {
		 if(saldo >= valor && estadoAtivacao.equalsIgnoreCase("ativa")) {
			 this.saldo -= valor;
			 movimentacoes.add("Saque efetuado no valor:  " + valor + ".  Saldo Atual:  " + this.saldo);
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	
	public String getMovimentacoes() {
		if(estadoAtivacao.equalsIgnoreCase("ativa")) {
			String dados = "";
			for(String s : this.movimentacoes) {
				dados += s + "\n";
			}
			return dados;
		} else {
			return "Esta conta esta inativa";
		}
	}
	

	
}
