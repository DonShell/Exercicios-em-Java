import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o tamanho do quadrado: (a partir de 5 para tornar-se visivel)");
		int tamanho = sc.nextInt();
		boolean caixa,X = false;
		for (int y = 0; y < tamanho; y++) {
			for (int x = 0; x < tamanho; x++) {
				caixa = (x * y * (x - (tamanho-1)) * (y - (tamanho-1)) == 0)? true : false ; 
				X = (x==y) || (x == (tamanho- 1  - y)) ? true : false;
				System.out.print( caixa | X ? "*" : " ");
			}
			System.out.println("");
		}
	}

}
