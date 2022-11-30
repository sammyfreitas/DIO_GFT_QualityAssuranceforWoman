package desafio_banco_digital;

public class PeJuridica extends Pessoa {
	
	
	private String nomeFantasia;
	private String cnpj;
	private Conta conta;
	

	public PeJuridica(String nome, String nomeFantasia, String endereco, String email, String cnpj) {
		super(nome, endereco, email);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String toString() {
		String dados = "Nome Empresarial:  " + this.nome + "\nNome Fantasia: " + this.nomeFantasia + 
						"\nEndereco Titular: " + this.endereco + "\nEmail do Titular: " + this.email + 
						"\nCNPJ do Titular: " + this.cnpj +
						"Saldo Atual: " + conta.getSaldo();
		return dados;
	}
	
}