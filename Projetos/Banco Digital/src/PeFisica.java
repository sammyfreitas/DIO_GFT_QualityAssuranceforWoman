package desafio_banco_digital;

public class PeFisica extends Pessoa {
	
	
	private String cpf;
	private Conta conta;

	
	public PeFisica(String nome, String endereco, String email, String cpf) {
		super(nome, endereco, email);
		this.cpf = cpf;
	}

	

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDadosPessoa() {
		String dados = "Nome Titular:  " + this.nome + "\nEndereco Titular: " + this.endereco +
						"\nEmail do Titular: " + this.email + "\nCPF do Titular: " + this.cpf +
						"Saldo Atual: " + conta.getSaldo();
		return dados;
	}
	
}