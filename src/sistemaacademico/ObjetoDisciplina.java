package sistemaacademico;

import java.util.Scanner;

public class ObjetoDisciplina extends Disciplina{

	public static void main(String[] args) {
		int codigo;
		Scanner lerCodigo = new Scanner(System.in);
		String nome;
		Scanner lerNome = new Scanner(System.in);
		
		ListaDeCurso.add(0, "vazio");
		
		Disciplina disciplina = new Disciplina();
		
		disciplina.cadastrar();
		
		System.out.println("Digite o curso que deseja alterar: ");
    	nome = lerNome.next();
    	
		disciplina.alterar(nome);
		
		System.out.println("Digite o identificador do curso para encontrar as disciplinas pertencentes: ");
    	codigo = lerCodigo.nextInt();
    	
    	disciplina.consultar(codigo);
    	
    	System.out.printf("\nInforme a posição a ser excluída ou, para sair, digite -1:\n");
        codigo = lerCodigo.nextInt();
        
        disciplina.excluir(codigo);
		
	

	}

}
