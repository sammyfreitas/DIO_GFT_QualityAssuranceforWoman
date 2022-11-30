package desafio_banco_digital;

public class ContaCorrente extends Conta {
	
	
	
	public long getPREFIXO() {
		return PREFIXO;
	}


	public ContaCorrente(Agencia agencia, Pessoa pessoa) {
		super(agencia, pessoa);
		this.estadoAtivacao = "ativa";
		this.PREFIXO = (long) 001;
	}
	
	
	public boolean transferir(Conta destino, double valor) {
		if(this.estadoAtivacao.equalsIgnoreCase("ativa") && this.saldo >= 0) {
			this.sacar(valor);
			destino.depositar(valor);
			movimentacoes.add("Transferencia realizda no valor:  " + valor + ".  Saldo Atual:  " + this.saldo +
								"Conta destino:  " + destino.getNumero() + " - Titular: " + destino.getPessoa().getNome());
			 return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	/*
	 	public String getDadosTitular() {
		String dados = null;
		dados += "Nome " + pessoa.getNome() + "\nEndereco Titular: " + pessoa.getEndereco() + "\nEmail do Titular: " + pessoa.getEmail() + 
						"\nCNPJ do Titular: " + this.cnpj +
						"Saldo Atual: " + conta.getSaldo();
		return dados;
	}
	 */
	
}