public class Funcionario {
	private Integer id;
	private String nome;
	private Double salario;
	public Funcionario (Integer id,String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	
	public void darAumento(Double porcentagem) {
		salario *= (porcentagem / 100) + 1 ;
	}
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Double getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		return "id: " + id + "\nnome: " + nome + "\nsalario: " + salario;
	}
	
	
}
