import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner ler = new Scanner(System.in);
	public static List<Funcionario> funcionarios =  new ArrayList<Funcionario>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu();
	} 
	
	public static void Menu() {
		Boolean emExecucao = true;
		do {
			System.out.println("Bem Vindo(a)! \n\n" 
					+"1 - Adicionar funcionario\n"
					+"2 - Listar funcionarios\n"
					+"3 - Dar aumento\n"
					+"4 - Excluir funcionario\n"
					+"5 - Fechar"
					);
			Integer opcao = ler.nextInt();
			ler.nextLine();
			
			switch (opcao) {
			case 1:
				adicionarFuncionario();
				break;
			case 2:
				listarFuncionarios();
				break;
			case 3:
				darAumento();
				break;
			case 4:
				excluirFuncionario();
				break;
			case 5:
				emExecucao = false;
			}
		}while(emExecucao);
	}
	
	static void listarFuncionarios()
	{
		for(Funcionario funcionario : funcionarios) System.out.println(funcionario);
	}
	
	static void darAumento()
	{	
		int indice = solicitarId();
		System.out.println("Qual a porcentagem que deseja aumenta do salario");
		Double porcentagem = ler.nextDouble();
		ler.nextLine();
		
		funcionarios.get(indice).darAumento(porcentagem);
	}
	
	public static void adicionarFuncionario() {
		String nome;
		Double salario;
		Integer id;

		System.out.println("Digite o nome do funcionario:");
		nome = ler.nextLine();
		
		System.out.println("Digite o salario do funcionario:");
		salario = ler.nextDouble();
		ler.nextLine();
		
		id = gerarId();
		
		funcionarios.add(new Funcionario(id,nome,salario));
		
		System.out.println("Funcionarios adicionado!\n Anote seu ID: " + id + "\n");
	}
	
	static int solicitarId(){
		
		Integer id = -1,indice = -1;
		do 
		{
			try 
			{
				System.out.println("Por favor, informe o ID do funcionario:");
				id = ler.nextInt();
			}
			catch(Exception erro)
			{
				System.out.println("Ops! Houve um erro. Tente digitar apenas numeros! ");
			}
		
			indice = validarId(id);
			if (indice != null) return indice; 
			else System.out.println("Ops! ID invalido.");
			
		}while(true);

	}
	static Integer validarId(int id)
	{
		Funcionario encontrado = funcionarios.stream().filter( f -> f.getId() == id).findFirst().orElse(null);
		
		if (encontrado != null) 
		{
			return funcionarios.indexOf(encontrado);
		}
		else
		{
			return null;
		}
	}
	
	static void excluirFuncionario()
	{
		int indice = solicitarId();
		funcionarios.remove(indice);
	}
	
	static int gerarId()
	{
		int id;
		do id = (int) (Math.random() * 99999); while(validarId(id) != null);
		return id;
	}
	
}
