package desafio_banco_digital;

public class ContaPoupanca extends Conta {
	

	private double taxaJuros;
	

	public ContaPoupanca(Agencia agencia, Pessoa cliente) {
		super(agencia, cliente);
		this.taxaJuros = 0.52;
		this.estadoAtivacao = "ativa";
		this.PREFIXO = (long) 002;
	}

	
	public long getPREFIXO() {
		return PREFIXO;
	}
	
	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	public void aplicarTaxaJuros() {
		this.saldo += (this.saldo * this.taxaJuros) / 100; 
	}

}