
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = gerarVetorAleatorio(10,-100,100);
		imprimirVetor(a);
		System.out.println("Organizando");
		imprimirVetor(organizarDecrescente(a));
	}

	public static int[] organizarDecrescente(int numero[])
	{
		int crescente[] = new int[numero.length];
		//= Array(numero.length);
		for (int i = 0; i < numero.length ; i++)
		{
			int maior = numero[0];
			int indiceDoMaior = 0;
			for (int iBuscador = 0; iBuscador < numero.length ; iBuscador++)
			{
				if (numero[iBuscador] >= maior)
				{
					maior = numero[iBuscador];
					indiceDoMaior = iBuscador;
				}
			}
			crescente[i] = maior;
			numero[indiceDoMaior] = Integer.MIN_VALUE;
		}				
		return crescente;
	}
	
	public static void imprimirVetor( int vetor[] )
	{
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(i + ": " + vetor[i] );			
		}
	}
	
	public static int[] gerarVetorAleatorio(int tamanho, int de, int ate)
	{
		int vetor[] = new int[tamanho];
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = (int) Math.round(Math.random() * (ate - de)) + de; 
		}
		return vetor;
	}
}
